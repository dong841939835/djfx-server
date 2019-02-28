package com.qcloud.project.djfx.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.OrderService;
import com.qcloud.project.djfx.service.StockService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.util.GetOrderUtil;
import com.qcloud.project.djfx.web.handler.OrderHandler;
import com.qcloud.project.djfx.model.query.OrderQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminOrderVO;

import oracle.net.aso.q;
		
@Controller
@RequestMapping(value = "/" + AdminOrderController.DIR)
public class AdminOrderController {
	
	public static final String DIR = "admin/order";
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderHandler orderHandler;
	@Autowired
	private StockService stockService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrganizationClient organizationClient ;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, OrderQuery query) {
	    query.setState(TypeEnum.OrderState.CAOGAO.getKey());
	    //query.setState2(TypeEnum.OrderState.YIWANCHENG.getKey());
		
		Page<Order> page = orderService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminOrderVO> list = orderHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/djfx-Order-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());	
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
		ModelAndView model = new ModelAndView("/admin/djfx-Order-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Order order) {
		orderService.add(order);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Order order=orderService.get(id);
		AdminOrderVO adminOrderVO=orderHandler.toVO4Admin(order);
		ModelAndView model = new ModelAndView("/admin/djfx-Order-edit");
		model.addObject("order", adminOrderVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Order order, String queryStr) {
		orderService.update(order);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		orderService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/shoppingCart");
		return aceAjaxView;
	}	
	
	@Transactional
	@RequestMapping
	public AceAjaxView sent(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Order order= orderService.get(id);
		order.setProcessingState(TypeEnum.OrderProcessingState.FAHUOZHONG.getKey());
		orderService.update(order);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("已发送");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	@NoReferer
	public ModelAndView shoppingCart(HttpServletRequest request, PPage pPage, OrderQuery query) {
		
		query.setRoleId(organizationClient.getClerk().getId());
		query.setSearchState2(TypeEnum.OrderState.CAOGAO.getKey());
		
		Page<Order> page = orderService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminOrderVO> list = orderHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/user/djfx-shoppingCart", DIR
				+ "/shoppingCart?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());	
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	@NoReferer
	public ModelAndView orderForm(HttpServletRequest request, PPage pPage, OrderQuery query) {
	    query.setState3(TypeEnum.OrderState.CAOGAO.getKey());
	    query.setRoleId(organizationClient.getClerk().getId());
		
		Page<Order> page = orderService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminOrderVO> list = orderHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/user/djfx-orderForm", DIR
				+ "/orderForm?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());	
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
	
	//取消订单
	@RequestMapping
	public AceAjaxView cancelOrder(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Order order = orderService.get(id);
		order.setState(TypeEnum.OrderState.CHEXIAZHONG.getKey());
		order.setProcessingState(TypeEnum.OrderProcessingState.ZANBUCHULI.getKey());
		orderService.update(order);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("取消成功");
		aceAjaxView.setUrl(DIR + "/orderForm");
		return aceAjaxView;
	}	
	
	//下单
	@RequestMapping
	public AceAjaxView placeOrder(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Order order = orderService.get(id);
		order.setState(TypeEnum.OrderState.YIXIADAN.getKey());
		order.setProcessingState(TypeEnum.OrderProcessingState.WEICHULI.getKey());
		orderService.update(order);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("下单成功");
		aceAjaxView.setUrl(DIR + "/orderForm");
		return aceAjaxView;
	}	
	
	
	//收货
	@Transactional
	@RequestMapping
	public AceAjaxView receivingGoods(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Order order = orderService.get(id);
		order.setState(TypeEnum.OrderState.YIWANCHENG.getKey());
		order.setProcessingState(TypeEnum.OrderProcessingState.YISONGDA.getKey());
		order.setCompletionTime(DateUtil.getTime());
		orderService.update(order);
		
		//收获增加本人库存，减少boss库存
		long roleId = order.getRoleId();
		long productId = order.getProductId();
		long totalQuantity = 0;
		Stock stock = stockService.getByRoleAndPro(roleId, productId);
		if(stock!=null){
			totalQuantity = stock.getTotalQuantity() + order.getoPNumber();
			stock.setTotalQuantity(totalQuantity);
			stockService.update(stock);
		}else {
			Stock s = new Stock();
			s.setTotalQuantity(order.getoPNumber());
			s.setCreateTime(DateUtil.getTime());
			s.setProductId(productId);
			s.setRoleId(roleId);
			stockService.add(s);
		}
		//减少boss库存
		roleId = userService.get(order.getRoleId()).getSuperiorId();
		Stock stock2 = stockService.getByRoleAndPro(roleId, productId);
		long totalQuantity2 = stock2.getTotalQuantity() - order.getoPNumber();
		stock2.setTotalQuantity(totalQuantity2);
		stockService.update(stock2);
		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("收货成功");
		aceAjaxView.setUrl(DIR + "/orderForm");
		return aceAjaxView;
	}	
	
	//假删除
	@RequestMapping
	public AceAjaxView falseDeletion(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Order order = orderService.get(id);
		order.setState(TypeEnum.OrderState.DELETE.getKey());
		orderService.update(order);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/orderForm");
		return aceAjaxView;
	}	
	
}
