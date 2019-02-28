package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class OrderUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/order/list.do");
		list.add("/admin/order/toAdd.do");
		list.add("/admin/order/toEdit.do");
		list.add("/admin/order/add.do");
		list.add("/admin/order/edit.do");
		list.add("/admin/order/sent.do");
		list.add("/admin/order/shoppingCart.do");
		list.add("/admin/order/delete.do");
		list.add("/admin/order/orderForm.do");
		list.add("/admin/order/cancelOrder.do");
		list.add("/admin/order/placeOrder.do");
		list.add("/admin/order/receivingGoods.do");
		list.add("/admin/order/falseDeletion.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/order/list.do");
		return list;
	}
}
