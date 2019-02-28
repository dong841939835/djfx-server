package com.qcloud.project.djfx.web.controller.admin;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qcloud.component.template.client.excel.ExcelClient;
import com.qcloud.component.template.client.instance.ClientFactory;
import com.qcloud.component.template.client.instance.OperatePVFactory;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.OrderProductService;
import com.qcloud.project.djfx.service.OrderService;
import com.qcloud.project.djfx.util.GetOrderUtil;
import com.qcloud.project.djfx.web.handler.OrderProductHandler;
import com.qcloud.project.djfx.model.query.OrderProductQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminOrderProductVO;

@Controller
@RequestMapping(value = "/" + AdminOrderProductController.DIR)
public class AdminOrderProductController {

	public static final String DIR = "admin/orderProduct";

	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private OrderProductHandler orderProductHandler;
	@Autowired
	private OrderService orderService;

	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, OrderProductQuery query) {

		Page<OrderProduct> page = orderProductService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminOrderProductVO> list = orderProductHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/admin/djfx-OrderProduct-list", DIR + "/list?" + pageQueryStr,
				pPage.getPageNum(), pPage.getPageSize(), page.getCount());
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String str = (String) e.nextElement();
			String val = StringUtil.nullToEmpty(request.getParameter(str));
			map.put(str, val);
		}
		pagingView.addObject("query", map);
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));

		return pagingView;
	}

	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/djfx-OrderProduct-add");
		return model;
	}

	@RequestMapping
	public AceAjaxView add(OrderProduct orderProduct) {
		orderProductService.add(orderProduct);

		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		OrderProduct orderProduct = orderProductService.get(id);
		AdminOrderProductVO adminOrderProductVO = orderProductHandler.toVO4Admin(orderProduct);
		ModelAndView model = new ModelAndView("/admin/djfx-OrderProduct-edit");
		model.addObject("orderProduct", adminOrderProductVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@RequestMapping
	public AceAjaxView edit(OrderProduct orderProduct, String queryStr) {
		orderProductService.update(orderProduct);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}

	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		orderProductService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	/**
	 * 一键导出
	 */
	@RequestMapping
	public void exportManifest(HttpServletRequest request, HttpServletResponse response, OrderProductQuery query)
			throws Exception {

		try {
			response.setContentType("application/x-download");
			response.setContentType("application/octet-stream");
			response.setCharacterEncoding("UTF-8");
			String agent = request.getHeader("USER-AGENT").toLowerCase();
			String fileName = "货单信息";
			String codedFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			if (agent.contains("firefox")) {
				response.setCharacterEncoding("utf-8");
				response.setHeader("content-disposition",
						"attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
			} else {
				response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

			Integer total = orderProductService.count4query(query); // 查询总条数
			int start = 0;
			int size = 1000; // 一次处理1000条数据，具体可修改
			int pagecount = 0;
			if (total != null && total.intValue() > 0) {
				// 页数
				if ((total % size) == 0) {
					pagecount = total / size;
				} else {
					pagecount = (total / size) + 1;
				}
				for (int i = 0; i < pagecount; i++) {
					start = size * i;
					Page<OrderProduct> page = orderProductService.page(query, start, size);
					List<AdminOrderProductVO> list = orderProductHandler.toVOList4Admin(page.getData());
					for (AdminOrderProductVO obj : list) {
						Map<String, Object> dataMap = new HashMap<String, Object>();
						dataMap.put("productName", obj.getProductName());// 名字&数量
						dataMap.put("sum", obj.getSum());// 总价格
						dataMap.put("roleName", obj.getRoleName());// 收货人
						dataMap.put("address", obj.getAddress());// 收货地址
						dataMap.put("phone", obj.getPhone());// 收货人电话
						dataMap.put("stateStr", obj.getStateStr());// 货单状态
						dataList.add(dataMap);
					}
				}
			}
			map.put("result", dataList);
			String fileDir = request.getRealPath("/WEB-INF/excel");
			ExcelClient excelClient = ClientFactory.getExcelClientInstance();
			excelClient.parse(OperatePVFactory.getTemplateFilePV(fileDir + "/djfx_manifest.xls"),
					OperatePVFactory.getObjectValuePV(map), OperatePVFactory.getROOSPV(response.getOutputStream()));
		} catch (Exception e) {
			throw new Exception("导出excel出错:" + e.getMessage(), e);
		}
	}

	// 下单
	@RequestMapping
	@Transactional
	public AceAjaxView placeAnOrder(String ids_str) {
		OrderProduct orderProduct = new OrderProduct();
		GetOrderUtil getOrderUtil = new GetOrderUtil();
		orderProduct.setProductId(ids_str);
		long number = 0;
		boolean f = true;
		while (f) {
			number = getOrderUtil.getOrder();
			OrderProduct o = orderProductService.getByOrderId(number);
			if (o != null) {
				f = true;
			} else {
				f = false;
			}

		}
		orderProduct.setOrderId(number);
		orderProductService.add(orderProduct);
		// 分解ins_str修改状态
		String[] strArr = ids_str.split("-");// 截取字符串
		long[] strArrNum = (long[]) ConvertUtils.convert(strArr, long.class);// 转换long类型的数组
		//order状态操作
		for (long l : strArrNum) {
			Order order = orderService.get(l);
			order.setState(TypeEnum.OrderState.YIXIADAN.getKey());
			order.setoNumber(number);
			orderService.update(order);
		}
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("下单成功");
		aceAjaxView.setUrl("admin/order/orderForm");
		return aceAjaxView;
	}
}
