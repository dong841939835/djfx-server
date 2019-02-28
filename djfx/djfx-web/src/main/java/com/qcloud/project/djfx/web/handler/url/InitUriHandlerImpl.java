package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class InitUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/init/list.do");
		list.add("/admin/init/toAdd.do");
		list.add("/admin/init/toEdit.do");
		list.add("/admin/init/add.do");
		list.add("/admin/init/edit.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/init/list.do");
		return list;
	}
}
