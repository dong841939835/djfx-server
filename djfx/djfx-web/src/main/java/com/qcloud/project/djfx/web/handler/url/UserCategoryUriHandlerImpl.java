package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class UserCategoryUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/userCategory/list.do");
		list.add("/admin/userCategory/toAdd.do");
		list.add("/admin/userCategory/toEdit.do");
		list.add("/admin/userCategory/add.do");
		list.add("/admin/userCategory/edit.do");
		list.add("/admin/userCategory/delete.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/userCategory/list.do");
		return list;
	}
}
