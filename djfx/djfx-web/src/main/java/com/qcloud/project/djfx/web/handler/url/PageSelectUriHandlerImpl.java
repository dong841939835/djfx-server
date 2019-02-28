package com.qcloud.project.djfx.web.handler.url;

import java.util.ArrayList;
import java.util.List;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class PageSelectUriHandlerImpl extends AbstractUriHandler{

	@Override
	public List<String> adminUris() {
		List<String> list = new ArrayList<String>();
		list.add("/admin/pageSelect/toSelectSuperior.do");
		list.add("/admin/pageSelect/getUserTreeAjax.do");
		return list;
	}
	
}
