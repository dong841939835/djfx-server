package com.qcloud.project.djfx.web.controller.admin;

import org.apache.poi.hssf.model.Model;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.service.ProductCategoryService;
import com.qcloud.project.djfx.util.UploadPhotos;
import com.qcloud.project.djfx.web.handler.ProductCategoryHandler;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminProductCategoryVO;

@Controller
@RequestMapping(value = "/" + AdminProductCategoryController.DIR)
public class AdminProductCategoryController {

	public static final String DIR = "admin/productCategory";

	@Autowired
	private ProductCategoryService productCategoryService;
	@Autowired
	private ProductCategoryHandler productCategoryHandler;

	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, ProductCategoryQuery query) {

		Page<ProductCategory> page = productCategoryService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminProductCategoryVO> list = productCategoryHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/admin/djfx-ProductCategory-list", DIR + "/list?" + pageQueryStr,
				pPage.getPageNum(), pPage.getPageSize(), page.getCount());
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));

		return pagingView;
	}

	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/djfx-ProductCategory-add");
		return model;
	}
	
	@Transactional
	@RequestMapping
	public AceAjaxView add(@RequestParam MultipartFile file,ProductCategory productCategory,HttpServletRequest request) throws IllegalStateException, IOException {
		AssertUtil.greatZero(productCategory.getType(), "用户类型不能为空");
		AssertUtil.assertNotEmpty(productCategory.getTypeName(), "用户类型名称不能为空");
		List<ProductCategory> lists = productCategoryService.listAll();
		Boolean b = true;
		// 判断类型是否重复
		for (ProductCategory productCategory2 : lists) {
			if (productCategory2.getType() == productCategory.getType()) {
				b = false;
			}
		}
		AceAjaxView aceAjaxView = new AceAjaxView();
		if (b) {
			//图片上传util类
			UploadPhotos u = new UploadPhotos();
			productCategory.setThumbnail(u.upload(file, request));//储存到数据库
			productCategoryService.add(productCategory);
			aceAjaxView.setMessage("添加成功");
			//aceAjaxView.setViewName("redirect:/admin/productCategory/list.do");/admin/index.do#admin/productCategory/list
			aceAjaxView.setViewName("redirect:/admin/index.do#admin/productCategory/list");
		} else {
			aceAjaxView.setMessage("类型已存在");
		}
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		ProductCategory productCategory = productCategoryService.get(id);
		AdminProductCategoryVO adminProductCategoryVO = productCategoryHandler.toVO4Admin(productCategory);
		ModelAndView model = new ModelAndView("/admin/djfx-ProductCategory-edit");
		model.addObject("productCategory", adminProductCategoryVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@RequestMapping
	public AceAjaxView edit(ProductCategory productCategory, String queryStr) {
		AssertUtil.greatZero(productCategory.getType(), "用户类型不能为空");
		AssertUtil.assertNotEmpty(productCategory.getTypeName(), "用户类型名称不能为空");
		AceAjaxView aceAjaxView = new AceAjaxView();
		productCategoryService.update(productCategory);
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}

	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		productCategoryService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	@RequestMapping
	@NoReferer
	public ModelAndView listProductCategory4Select(HttpServletRequest request, PPage pPage,
			ProductCategoryQuery query) {
		Page<ProductCategory> page = productCategoryService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminProductCategoryVO> list = productCategoryHandler.toVOList4Admin(page.getData());
		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/admin/djfx-ProductCategory-listProductCategory4Select",
				DIR + "/listProductCategory4Select?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(),
				page.getCount());
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String str = (String) e.nextElement();
			String val = StringUtil.nullToEmpty(request.getParameter(str));
			map.put(str, val);
		}
		pagingView.addObject("query", map);
		return pagingView;
	}
}
