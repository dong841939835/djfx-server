package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.web.vo.UserVO;
import com.qcloud.project.djfx.web.vo.admin.AdminUserVO;

public interface UserHandler {

	List<UserVO> toVOList(List<User> list);

	UserVO toVO(User user);

	List<AdminUserVO> toVOList4Admin(List<User> list);

	AdminUserVO toVO4Admin(User user);
}
