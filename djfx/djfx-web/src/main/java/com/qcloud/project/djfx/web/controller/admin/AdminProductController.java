package com.qcloud.project.djfx.web.controller.admin;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.qcloud.component.organization.OrganizationClient;
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
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.OrderService;
import com.qcloud.project.djfx.service.ProductService;
import com.qcloud.project.djfx.service.StockService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.util.UploadPhotos;
import com.qcloud.project.djfx.web.handler.ProductHandler;
import com.qcloud.project.djfx.model.query.ProductQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminProductVO;

@Controller
@RequestMapping(value = "/" + AdminProductController.DIR)
public class AdminProductController {

	public static final String DIR = "admin/product";

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductHandler productHandler;
	@Autowired
	private StockService stockService;
	@Autowired
	private AdminStockController adminStockController;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrganizationClient organizationClient;

	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, ProductQuery query) {

		Page<Product> page = productService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminProductVO> list = productHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/admin/djfx-Product-list", DIR + "/list?" + pageQueryStr,
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
		ModelAndView model = new ModelAndView("/admin/djfx-Product-add");
		return model;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView add(@RequestParam MultipartFile file,Product product,HttpServletRequest request) throws IllegalStateException, IOException {
		AssertUtil.assertNotEmpty(product.getProductName(), "商品名称不能为空");
		AssertUtil.assertNotNull(product.getPrice(), "商品价格不能为空");
		AssertUtil.assertNotEmpty(product.getSpecifications(), "商品规格不能为空");
		// AssertUtil.greatZero(product.getSockId(), "商品库存不能为空");
		AssertUtil.greatZero(product.getProductCategoryId(), "商品类型不能为空");
		product.setCreateTime(new Date());
		product.setConcessionalRate(0.0);
		//图片上传util类
		UploadPhotos u = new UploadPhotos();
		product.setThumbnail(u.upload(file, request));//储存到数据库
		productService.add(product);

		// 添加商品的时候添加库存
		Stock s = new Stock();
		s.setProductId(product.getId());
		s.setRoleId(2010008000010401L);
		s.setCreateTime(new Date());
		s.setSState(TypeEnum.StockType.NOSTOCK.getKey());
		stockService.add(s);

		// 更新商品的库存id
		product.setSockId(s.getId());
		productService.update(product);

		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setViewName("redirect:/admin/index.do#admin/product/list");
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Product product = productService.get(id);
		AdminProductVO adminProductVO = productHandler.toVO4Admin(product);
		ModelAndView model = new ModelAndView("/admin/djfx-Product-edit");
		model.addObject("product", adminProductVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@RequestMapping
	public AceAjaxView edit(Product product, String queryStr) {
		AssertUtil.assertNotEmpty(product.getProductName(), "商品名称不能为空");
		AssertUtil.assertNotNull(product.getPrice(), "商品价格不能为空");
		AssertUtil.assertNotEmpty(product.getSpecifications(), "商品规格不能为空");
		AssertUtil.greatZero(product.getSockId(), "商品库存不能为空");
		AssertUtil.greatZero(product.getProductCategoryId(), "商品类型不能为空");
		productService.update(product);

		// 修改商品的时候修改库存也要存进相应的库存

		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		productService.delete(id);
		adminStockController.delete4Product(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView show(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Product product = productService.get(id);
		AdminProductVO adminProductVO = productHandler.toVO4Admin(product);
		ModelAndView model = new ModelAndView("/admin/djfx-Product-show");
		model.addObject("product", adminProductVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@RequestMapping
	@NoReferer
	public ModelAndView stockPurchase(HttpServletRequest request, PPage pPage, ProductQuery query) {

		Page<Product> page = productService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminProductVO> list = productHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/user/djfx-stockPurchase", DIR + "/stockPurchase?" + pageQueryStr,
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
	public ModelAndView toAddOrder() {
		ModelAndView model = new ModelAndView("/user/djfx-addToCart");
		return model;
	}

	@RequestMapping
	public AceAjaxView addOrder(Order order) {
		AceAjaxView aceAjaxView = new AceAjaxView();
		order.setCreateTime(DateUtil.getTime());
		order.setRoleId(organizationClient.getClerk().getId());

		// 判断上级有没有那么多库存
		long superiorId = userService.get(order.getRoleId()).getSuperiorId();
		Stock s = stockService.getByRoleAndPro(superiorId, order.getProductId());
		if (s.getTotalQuantity() < order.getoPNumber()) {
			aceAjaxView.setMessage("您的上级并没有那么多库存");
			return aceAjaxView;
		}

		double sum = 0;
		Product product = productService.get(order.getProductId());
		if (product.getConcessionalRate() != 0.0) {
			sum = order.getoPNumber() * product.getConcessionalRate();
		} else {
			sum = order.getoPNumber() * product.getPrice();
		}
		order.setoSum(sum);
		order.setProcessingState(TypeEnum.OrderProcessingState.WEICHULI.getKey());
		orderService.add(order);

		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
}
