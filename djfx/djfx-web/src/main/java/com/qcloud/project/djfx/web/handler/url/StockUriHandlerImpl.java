package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class StockUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/stock/list.do");
		list.add("/admin/stock/toAdd.do");
		list.add("/admin/stock/toEdit.do");
		list.add("/admin/stock/add.do");
		list.add("/admin/stock/edit.do");
		list.add("/admin/stock/delete.do");
		list.add("/admin/stock/userStock.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/stock/list.do");
		return list;
	}
}
