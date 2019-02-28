package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProductUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/product/list.do");
		list.add("/admin/product/toAdd.do");
		list.add("/admin/product/toEdit.do");
		list.add("/admin/product/add.do");
		list.add("/admin/product/edit.do");
		list.add("/admin/product/delete.do");
		list.add("/admin/product/show.do");
		list.add("/admin/product/stockPurchase.do");
		list.add("/admin/product/toAddOrder.do");
		list.add("/admin/product/addOrder.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/product/list.do");
		return list;
	}
}
