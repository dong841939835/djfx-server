package com.qcloud.project.djfx.web.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.service.UserCategoryService;
import com.qcloud.project.djfx.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/" + AdminPageSelectController.DIR)
public class AdminPageSelectController {

	public static final String DIR = "admin/pageSelect";

	@Resource(name = "redis-djfx")
	private Redis redis;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCategoryService userCategoryService;

	@RequestMapping
	public ModelAndView toSelectSuperior(HttpServletRequest request, String type) {
		ModelAndView view = new ModelAndView();
		view.setViewName("/admin/djfx-Superior-select");
		view.addObject("type", type);
		return view;
	}

	@RequestMapping
	public FrontAjaxView getUserTreeAjax(HttpServletRequest request) {
		
		JSONArray userTree = new JSONArray();
		String str = redis.get("djfx_user_tree_array");
		if (StringUtils.isEmpty(str)) {
			List<User> users = userService.listAll();
			for (User u : users) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("id", u.getId());
				jsonObj.put("pId", u.getSuperiorId());
				jsonObj.put("name", u.getName()+"   "+userCategoryService.get(u.getRoleCategoryId()).getTypeName());
				jsonObj.put("open", "true");
				userTree.add(jsonObj);
				
			}
			redis.set("djfx_user_tree_array", Json.toJson(userTree), 3);
		} else {
			userTree = Json.toObject(str, JSONArray.class);
		}

		FrontAjaxView view = new FrontAjaxView();
		view.addObject("zNodes", userTree);
		return view;
	}

}
