package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class UserUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/user/list.do");
		list.add("/admin/user/toAdd.do");
		list.add("/admin/user/toEdit.do");
		list.add("/admin/user/add.do");
		list.add("/admin/user/edit.do");
		list.add("/admin/user/show.do");
		list.add("/admin/user/delete.do");
		list.add("/admin/user/pCenter.do");
		list.add("/admin/user/toAddSubordinate.do");
		list.add("/admin/user/addSubordinate.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/user/list.do");
		return list;
	}
	
}
