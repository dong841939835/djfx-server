package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.web.vo.UserCategoryVO;
import com.qcloud.project.djfx.web.vo.admin.AdminUserCategoryVO;

public interface UserCategoryHandler {

	List<UserCategoryVO> toVOList(List<UserCategory> list);

	UserCategoryVO toVO(UserCategory userCategory);

	List<AdminUserCategoryVO> toVOList4Admin(List<UserCategory> list);

	AdminUserCategoryVO toVO4Admin(UserCategory userCategory);
}
