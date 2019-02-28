package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.djfx.web.handler.UserHandler;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.service.UserCategoryService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.web.vo.UserVO;
import com.qcloud.project.djfx.web.vo.admin.AdminUserVO;

@Component
public class UserHandlerImpl implements UserHandler {

	@Autowired
	private UserCategoryService userCategoryService;
	@Autowired
	private UserService userService;

	@Override
	public List<UserVO> toVOList(List<User> list) {
		List<UserVO> voList = new ArrayList<UserVO>();
		for (User user : list) {
			voList.add(toVO(user));
		}
		return voList;
	}

	@Override
	public UserVO toVO(User user) {
		String json = Json.toJson(user);
		return Json.toObject(json, UserVO.class, true);

	}

	@Override
	public List<AdminUserVO> toVOList4Admin(List<User> list) {
		List<AdminUserVO> voList = new ArrayList<AdminUserVO>();
		for (User adminUser : list) {
			voList.add(toVO4Admin(adminUser));
		}
		return voList;
	}

	@Override
	public AdminUserVO toVO4Admin(User user) {
		String json = Json.toJson(user);
		AdminUserVO adminUserVO = Json.toObject(json, AdminUserVO.class, true);
		String createTimeStr = DateUtil.date2String(user.getCreateTime(), "yyyy-MM-dd HH:mm");
		adminUserVO.setCreateTimeStr(createTimeStr);
		String roleCategoryStr = userCategoryService.get(user.getRoleCategoryId()).getTypeName();
		adminUserVO.setRoleCategoryStr(roleCategoryStr);
		if(user.getSuperiorId()==0){
			adminUserVO.setSuperiorName("我是最大的");
		}else{
			String superiorName = userService.get(user.getSuperiorId()).getName();
			adminUserVO.setSuperiorName(superiorName);
		}
		return adminUserVO;
	}
}
