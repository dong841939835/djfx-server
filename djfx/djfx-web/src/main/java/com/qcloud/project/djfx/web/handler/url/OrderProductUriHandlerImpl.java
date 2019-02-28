package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class OrderProductUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/orderProduct/list.do");
		list.add("/admin/orderProduct/toAdd.do");
		list.add("/admin/orderProduct/toEdit.do");
		list.add("/admin/orderProduct/add.do");
		list.add("/admin/orderProduct/edit.do");
		list.add("/admin/orderProduct/exportManifest.do");
		list.add("/admin/orderProduct/placeAnOrder.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/orderProduct/list.do");
		return list;
	}
}
