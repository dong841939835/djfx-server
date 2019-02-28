package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.web.vo.InitVO;
import com.qcloud.project.djfx.web.vo.admin.AdminInitVO;

public interface InitHandler {

	List<InitVO> toVOList(List<Init> list);

	InitVO toVO(Init init);

	List<AdminInitVO> toVOList4Admin(List<Init> list);

	AdminInitVO toVO4Admin(Init init);
}
