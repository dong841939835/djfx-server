package com.qcloud.project.djfx.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.StockService;
import com.qcloud.project.djfx.web.handler.StockHandler;
import com.qcloud.project.djfx.model.query.StockQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminStockVO;

import oracle.net.aso.s;

@Controller
@RequestMapping(value = "/" + AdminStockController.DIR)
public class AdminStockController {

	public static final String DIR = "admin/stock";

	@Autowired
	private StockService stockService;
	@Autowired
	private StockHandler stockHandler;
	@Autowired
	private OrganizationClient organizationClient;

	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, StockQuery query) {
		query.setRoleId(organizationClient.getClerk().getId());

		Page<Stock> page = stockService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminStockVO> list = stockHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/admin/djfx-Stock-list", DIR + "/list?" + pageQueryStr,
				pPage.getPageNum(), pPage.getPageSize(), page.getCount());
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));

		return pagingView;
	}

	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/djfx-Stock-add");
		return model;
	}

	@RequestMapping
	public AceAjaxView add(Stock stock) {
		stockService.add(stock);

		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Stock stock = stockService.get(id);
		AdminStockVO adminStockVO = stockHandler.toVO4Admin(stock);
		ModelAndView model = new ModelAndView("/admin/djfx-Stock-edit");
		model.addObject("stock", adminStockVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@RequestMapping
	public AceAjaxView edit(Stock stock, String queryStr) {
		long totalQuantity = stock.getTotalQuantity();
		if (totalQuantity > 0) {
			stock.setSState(TypeEnum.StockType.HAVESTOCK.getKey());
		} else {
			stock.setSState(TypeEnum.StockType.NOSTOCK.getKey());
		}
		stockService.update(stock);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Stock stock = stockService.get(id);
		stock.setSState(TypeEnum.StockType.DELETE.getKey());
		stockService.update(stock);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	public AceAjaxView delete4Product(Long productId) {
		AssertUtil.assertNotNull(productId, "ID不能为空");
		List<Stock> stocks = stockService.listByProductId(productId);
		for (Stock stock : stocks) {
			stock.setSState(TypeEnum.StockType.DELETE.getKey());
			stockService.update(stock);
		}
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	@RequestMapping
	@NoReferer
	public ModelAndView userStock(HttpServletRequest request, PPage pPage, StockQuery query) {

		query.setRoleId(organizationClient.getClerk().getId());

		Page<Stock> page = stockService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminStockVO> list = stockHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/user/djfx-userStock", DIR + "/userStock?" + pageQueryStr,
				pPage.getPageNum(), pPage.getPageSize(), page.getCount());
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));

		return pagingView;
	}
}
