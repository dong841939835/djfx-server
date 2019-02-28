package com.qcloud.project.djfx.web.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.qcloud.component.admin.model.key.TypeEnum.AdminEnableType;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.page.PageParameterUtil;
import com.qcloud.pirates.web.page.PiratesParameterKey;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.UserCategoryService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.web.handler.UserHandler;
import com.qcloud.project.djfx.model.query.UserQuery;
import com.qcloud.project.djfx.web.vo.admin.AdminUserVO;

import oracle.jdbc.dcn.TableChangeDescription.TableOperation;

@Controller
@RequestMapping(value = "/" + AdminUserController.DIR)
public class AdminUserController {

	public static final String DIR = "admin/user";

	@Autowired
	private UserService userService;
	@Autowired
	private UserHandler userHandler;
	@Autowired
	private UserCategoryService userCategoryService;
	@Autowired
	private OrganizationClient organizationClient;
	@Autowired
	private ClerkService clerkService;
	@Autowired
	private ClerkHelper clerkHelper;

	@RequestMapping
	@NoReferer
	public ModelAndView list(HttpServletRequest request, PPage pPage, UserQuery query) {

		Page<User> page = userService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminUserVO> list = userHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/admin/djfx-User-list", DIR + "/list?" + pageQueryStr,
				pPage.getPageNum(), pPage.getPageSize(), page.getCount());
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));

		return pagingView;
	}

	@RequestMapping
	public ModelAndView toAdd() {
		List<UserCategory> userCategory = userCategoryService.listAll();
		ModelAndView model = new ModelAndView("/admin/djfx-User-add");
		model.addObject("roleCategory", userCategory);
		return model;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView add(User user) {
		AssertUtil.assertNotEmpty(user.getName(), "用户昵称不能为空");
		AssertUtil.assertNotEmpty(user.getUserName(), "用户账号不能为空");
		AssertUtil.assertNotEmpty(user.getPassword(), "用户密码不能为空");
		AssertUtil.assertNotEmpty(user.getEmail(), "用户邮箱不能为空");
		AssertUtil.assertNotNull(user.getPhone(), "用户电话不能为空");
		AssertUtil.assertNotEmpty(user.getContactAddress(), "用户地址不能为空");
		AssertUtil.assertNotNull(user.getIdCard(), "用户身份证不能为空");
		AssertUtil.greatZero(user.getSuperiorId(), "用户上级ID不能为空");
		AssertUtil.greatZero(user.getRoleCategoryId(), "用户类型ID不能为空");

		AceAjaxView aceAjaxView = new AceAjaxView();

		User user2 = userService.getByUserName(user.getUserName());
		if (user2 != null) {
			aceAjaxView.setMessage("账号已存在");
			return aceAjaxView;
		}

		user.setCreateTime(new Date());
		userService.add(user);

		// 同步到clerk的数据库
		Clerk clerk = new Clerk();
		long departmentId = TypeEnum.Department.JINGXIAOSHANG.getKey();
		clerk.setLoginAccount(user.getUserName());
		clerk.setName(user.getName());
		clerk.setMobile(Long.toString(user.getPhone()));
		clerk.setJobEmail(user.getEmail());
		clerkService.add(clerk, departmentId);
		// clerk表修改密码 同步id便于后面个人登陆的操作
		clerkService.changePwd(clerk.getId(), user.getPassword());
		clerk.setId(user.getId());
		clerkService.update(clerk);

		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView toEdit(HttpServletRequest request, Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		User user = userService.get(id);
		AdminUserVO adminUserVO = userHandler.toVO4Admin(user);
		ModelAndView model = new ModelAndView("/admin/djfx-User-edit");
		List<UserCategory> userCategory = userCategoryService.listAll();
		model.addObject("roleCategory", userCategory);
		model.addObject("user", adminUserVO);
		Clerk clerk = clerkHelper.getClerk(request);
		long clerkId = clerk.getId();
		model.addObject("clerkId", clerkId);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView edit(HttpServletRequest request, User user, String queryStr) {
		AssertUtil.assertNotEmpty(user.getName(), "用户昵称不能为空");
		AssertUtil.assertNotEmpty(user.getUserName(), "用户账号不能为空");
		AssertUtil.assertNotEmpty(user.getPassword(), "用户密码不能为空");
		AssertUtil.assertNotEmpty(user.getEmail(), "用户邮箱不能为空");
		AssertUtil.assertNotNull(user.getPhone(), "用户电话不能为空");
		AssertUtil.assertNotEmpty(user.getContactAddress(), "用户地址不能为空");
		AssertUtil.assertNotNull(user.getIdCard(), "用户身份证不能为空");
		AssertUtil.assertNotNull(user.getSuperiorId(), "用户上级ID不能为空");
		AssertUtil.greatZero(user.getRoleCategoryId(), "用户类型ID不能为空");
		userService.update(user);

		// clerk表修改密码 总部登陆不修改密码
		Clerk clerk = clerkHelper.getClerk(request);
		if (clerk.getId() != TypeEnum.ZhongBu.ZHONGBUID.getKey()) {
			clerkService.changePwd(clerk.getId(), user.getPassword());
		}

		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");

		// 总部走总部，其余走别的地方
		if (clerk.getId() == TypeEnum.ZhongBu.ZHONGBUID.getKey()) {
			aceAjaxView.setUrl(DIR + "/list?" + StringUtil.nullToEmpty(queryStr));
		} else {
			aceAjaxView.setUrl(DIR + "/pCenter?" + StringUtil.nullToEmpty(queryStr));
		}
		return aceAjaxView;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		userService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		User user = userService.get(id);
		//同时禁用clerk帐号
		Clerk clerk = clerkService.get(id);
		clerk.setEnable(AdminEnableType.DISABLE.getKey());
        clerkService.update(clerk);
        
		if (user.getSuperiorId() == organizationClient.getClerk().getId()
				|| organizationClient.getClerk().getId() != TypeEnum.ZhongBu.ZHONGBUID.getKey()) {
			aceAjaxView.setUrl(DIR + "/pCenter");
		} else {
			aceAjaxView.setUrl(DIR + "/list");
		}
		return aceAjaxView;
	}

	@RequestMapping
	public ModelAndView show(Long id, String queryStr) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		User user = userService.get(id);
		AdminUserVO adminUserVO = userHandler.toVO4Admin(user);
		ModelAndView model = new ModelAndView("/admin/djfx-User-show");
		model.addObject("user", adminUserVO);
		model.addObject("queryStr", StringUtil.nullToEmpty(queryStr));
		return model;
	}

	@RequestMapping
	public ModelAndView pCenter(HttpServletRequest request, PPage pPage, UserQuery query) {
		// 个人信息
		long id = organizationClient.getClerk().getId();
		User user = userService.get(id);
		AdminUserVO adminUserVO = userHandler.toVO4Admin(user);

		// 下级信息
		query.setSuperiorId(organizationClient.getClerk().getId());
		Page<User> page = userService.page(query, pPage.getPageStart(), pPage.getPageSize());
		List<AdminUserVO> list = userHandler.toVOList4Admin(page.getData());

		String pageQueryStr = StringUtil.nullToEmpty(
				(String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.PAGE_QUERY_STRING));
		String queryStr = StringUtil
				.nullToEmpty((String) PageParameterUtil.getParameterValues(request, PiratesParameterKey.QUERY_STRING));
		AcePagingView pagingView = new AcePagingView("/user/djfx-pCenter", DIR + "/pCenter?" + pageQueryStr,
				pPage.getPageNum(), pPage.getPageSize(), page.getCount());
		pagingView.addObject("result", list);
		pagingView.addObject("queryStr", URLEncoder.encode(queryStr));
		pagingView.addObject("user", adminUserVO);

		return pagingView;
	}

	@RequestMapping
	public ModelAndView toAddSubordinate() {
		ModelAndView model = new ModelAndView("/user/djfx-addSubordinate");
		return model;
	}

	@Transactional
	@RequestMapping
	public AceAjaxView addSubordinate(User user) {
		AssertUtil.assertNotEmpty(user.getName(), "用户昵称不能为空");
		AssertUtil.assertNotEmpty(user.getUserName(), "用户账号不能为空");
		AssertUtil.assertNotEmpty(user.getPassword(), "用户密码不能为空");
		AssertUtil.assertNotEmpty(user.getEmail(), "用户邮箱不能为空");
		AssertUtil.assertNotNull(user.getPhone(), "用户电话不能为空");
		AssertUtil.assertNotEmpty(user.getContactAddress(), "用户地址不能为空");
		AssertUtil.assertNotNull(user.getIdCard(), "用户身份证不能为空");
		user.setSuperiorId(organizationClient.getClerk().getId());
		user.setCreateTime(new Date());
		Long userCId = null;
		// 修改role类型
		User user2 = userService.get(user.getSuperiorId());
		int type = userCategoryService.get(user2.getRoleCategoryId()).getType();
		type++;
		List<UserCategory> listUC = userCategoryService.listAll();
		for (UserCategory userCategory : listUC) {
			if (userCategory.getType() == type) {
				userCId = userCategory.getId();
			}
		}
		user.setRoleCategoryId(userCId);
		User u = userService.getByUserName(user.getUserName());

		AceAjaxView aceAjaxView = new AceAjaxView();
		if (u != null) {
			aceAjaxView.setMessage("账号已存在");
			return aceAjaxView;
		}

		userService.add(user);

		// 同步到clerk的数据库
		Clerk clerk = new Clerk();
		long departmentId = TypeEnum.Department.JINGXIAOSHANG.getKey();
		clerk.setLoginAccount(user.getUserName());
		clerk.setName(user.getName());
		clerk.setMobile(Long.toString(user.getPhone()));
		clerk.setJobEmail(user.getEmail());
		clerkService.add(clerk, departmentId);
		// clerk表修改密码 同步id便于后面个人登陆的操作	发行没有同步成功
		clerkService.changePwd(clerk.getId(), user.getPassword());
		clerk.setId(user.getId());
		clerkService.update(clerk);

		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/pCenter");
		return aceAjaxView;
	}

}
