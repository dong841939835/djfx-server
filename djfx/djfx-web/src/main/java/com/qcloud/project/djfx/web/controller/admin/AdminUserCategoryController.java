package com.qcloud.project.djfx.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.List;
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
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.service.UserCategoryService;
import com.qcloud.project.djfx.web.handler.UserCategoryHandler;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminUserCategoryVO;
		
@Controller
@RequestMapping(value = "/" + AdminUserCategoryController.DIR)
public class AdminUserCategoryController {
	
	public static final String DIR = "admin/userCategory";
	
	@Autowired
	private UserCategoryService userCategoryService;
	@Autowired
	private UserCategoryHandler userCategoryHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, UserCategoryQuery query) {
	    
		Page<UserCategory> page = userCategoryService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminUserCategoryVO> list = userCategoryHandler.toVOList4Admin(page.getData());
		
	    String pageQueryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
        String queryStr = StringUtil.nullToEmpty((String)PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));   
		AcePagingView pagingView = new AcePagingView("/admin/djfx-UserCategory-list", DIR
				+ "/list?" + pageQueryStr, pPage.getPageNum(), pPage.getPageSize(), page.getCount());		
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/djfx-UserCategory-add");
		return model;
	}
	
	/*AssertUtil.assertNotNull(jobPublish.getState(),"状态不能为空");
	AssertUtil.greatZero(jobPublish.getJobId(),"岗位不能为空");
	AssertUtil.assertNotEmpty(jobPublish.getDutyDescribe(),"岗位职责不能为空");*/
	@RequestMapping
	public AceAjaxView add(UserCategory userCategory) {
		AssertUtil.greatZero(userCategory.getType(), "用户类型不能为空");
		AssertUtil.assertNotEmpty(userCategory.getTypeName(), "用户类型名称不能为空");
		List<UserCategory> lists=userCategoryService.listAll();
		Boolean b=true;
		//判断类型是否重复
		for (UserCategory userCategory2 : lists) {
			if(userCategory2.getType()==userCategory.getType()){
				b=false;
			}
		}
		AceAjaxView aceAjaxView = new AceAjaxView();
		if(b){
			userCategoryService.add(userCategory);
			aceAjaxView.setMessage("添加成功");
			aceAjaxView.setUrl(DIR + "/list");
		}else{
			aceAjaxView.setMessage("类型已存在");
		}
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		UserCategory userCategory=userCategoryService.get(id);
		AdminUserCategoryVO adminUserCategoryVO=userCategoryHandler.toVO4Admin(userCategory);
		ModelAndView model = new ModelAndView("/admin/djfx-UserCategory-edit");
		model.addObject("userCategory", adminUserCategoryVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(UserCategory userCategory, String queryStr) {
		AssertUtil.greatZero(userCategory.getType(), "用户类型不能为空");
		AssertUtil.assertNotEmpty(userCategory.getTypeName(), "用户类型名称不能为空");
		AceAjaxView aceAjaxView = new AceAjaxView();
		userCategoryService.update(userCategory);
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		userCategoryService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
}
