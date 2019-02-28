package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class ProductCategoryUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/productCategory/list.do");
		list.add("/admin/productCategory/toAdd.do");
		list.add("/admin/productCategory/toEdit.do");
		list.add("/admin/productCategory/add.do");
		list.add("/admin/productCategory/edit.do");
		list.add("/admin/productCategory/delete.do");
		list.add("/admin/productCategory/listProductCategory4Select.do");
			
		return list;
	}

	@Override
	public List<String> permissionUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/productCategory/list.do");
		return list;
	}
}
