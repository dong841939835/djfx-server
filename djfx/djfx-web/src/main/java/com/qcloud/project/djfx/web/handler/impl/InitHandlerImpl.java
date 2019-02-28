package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.djfx.web.handler.InitHandler;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.web.vo.InitVO;
import com.qcloud.project.djfx.web.vo.admin.AdminInitVO;

@Component
public class InitHandlerImpl implements InitHandler {

	@Override
	public List<InitVO> toVOList(List<Init> list){
		List<InitVO> voList = new ArrayList<InitVO>();
		for (Init init : list) {
			voList.add(toVO(init));
		}
		return voList;
	}

	@Override
	public InitVO toVO(Init init){
		String json = Json.toJson(init);
		return Json.toObject(json, InitVO.class, true);

	}

	@Override
	public List<AdminInitVO> toVOList4Admin(List<Init> list){
		List<AdminInitVO> voList = new ArrayList<AdminInitVO>();
		for (Init adminInit : list) {
			voList.add(toVO4Admin(adminInit));
		}
		return voList;
	}

	@Override
	public AdminInitVO toVO4Admin(Init init){
		String json = Json.toJson(init);
		return Json.toObject(json, AdminInitVO.class, true);
	}
}
