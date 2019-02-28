package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.djfx.web.handler.UserCategoryHandler;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.web.vo.UserCategoryVO;
import com.qcloud.project.djfx.web.vo.admin.AdminUserCategoryVO;

@Component
public class UserCategoryHandlerImpl implements UserCategoryHandler {

	@Override
	public List<UserCategoryVO> toVOList(List<UserCategory> list){
		List<UserCategoryVO> voList = new ArrayList<UserCategoryVO>();
		for (UserCategory userCategory : list) {
			voList.add(toVO(userCategory));
		}
		return voList;
	}

	@Override
	public UserCategoryVO toVO(UserCategory userCategory){
		String json = Json.toJson(userCategory);
		return Json.toObject(json, UserCategoryVO.class, true);

	}

	@Override
	public List<AdminUserCategoryVO> toVOList4Admin(List<UserCategory> list){
		List<AdminUserCategoryVO> voList = new ArrayList<AdminUserCategoryVO>();
		for (UserCategory adminUserCategory : list) {
			voList.add(toVO4Admin(adminUserCategory));
		}
		return voList;
	}

	@Override
	public AdminUserCategoryVO toVO4Admin(UserCategory userCategory){
		String json = Json.toJson(userCategory);
		return Json.toObject(json, AdminUserCategoryVO.class, true);
	}
}
