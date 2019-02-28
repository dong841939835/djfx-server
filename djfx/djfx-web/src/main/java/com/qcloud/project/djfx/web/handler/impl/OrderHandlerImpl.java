package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.djfx.web.handler.OrderHandler;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.ProductService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.web.vo.OrderVO;
import com.qcloud.project.djfx.web.vo.admin.AdminOrderVO;

@Component
public class OrderHandlerImpl implements OrderHandler {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	@Override
	public List<OrderVO> toVOList(List<Order> list){
		List<OrderVO> voList = new ArrayList<OrderVO>();
		for (Order order : list) {
			voList.add(toVO(order));
		}
		return voList;
	}

	@Override
	public OrderVO toVO(Order order){
		String json = Json.toJson(order);
		return Json.toObject(json, OrderVO.class, true);

	}

	@Override
	public List<AdminOrderVO> toVOList4Admin(List<Order> list){
		List<AdminOrderVO> voList = new ArrayList<AdminOrderVO>();
		for (Order adminOrder : list) {
			voList.add(toVO4Admin(adminOrder));
		}
		return voList;
	}

	@Override
	public AdminOrderVO toVO4Admin(Order order){
		String json = Json.toJson(order);
		AdminOrderVO adminOrderVO = Json.toObject(json, AdminOrderVO.class, true);
		adminOrderVO.setCreateTimeStr(DateUtil.date2String(order.getCreateTime(),"yyyy-MM-dd HH:mm"));
		if(order.getProcessingState()==TypeEnum.OrderProcessingState.WEICHULI.getKey()){
			adminOrderVO.setProcessingStateStr(TypeEnum.OrderProcessingState.WEICHULI.getName());
		}else if(order.getProcessingState()==TypeEnum.OrderProcessingState.FAHUOZHONG.getKey()){
			adminOrderVO.setProcessingStateStr(TypeEnum.OrderProcessingState.FAHUOZHONG.getName());
		}else if (order.getProcessingState()==TypeEnum.OrderProcessingState.YISONGDA.getKey()) {
			adminOrderVO.setProcessingStateStr(TypeEnum.OrderProcessingState.YISONGDA.getName());
		}else if (order.getProcessingState()==TypeEnum.OrderProcessingState.ZANBUCHULI.getKey()) {
			adminOrderVO.setProcessingStateStr(TypeEnum.OrderProcessingState.ZANBUCHULI.getName());
		}
		if(order.getState()==TypeEnum.OrderState.CAOGAO.getKey()){
			adminOrderVO.setStateStr(TypeEnum.OrderState.CAOGAO.getName());
		}else if(order.getState()==TypeEnum.OrderState.YIXIADAN.getKey()){
			adminOrderVO.setStateStr(TypeEnum.OrderState.YIXIADAN.getName());
		}else if(order.getState()==TypeEnum.OrderState.CHEXIAZHONG.getKey()){
			adminOrderVO.setStateStr(TypeEnum.OrderState.CHEXIAZHONG.getName());
		}else if(order.getState()==TypeEnum.OrderState.YIWANCHENG.getKey()){
			adminOrderVO.setStateStr(TypeEnum.OrderState.YIWANCHENG.getName());
		}
		
		adminOrderVO.setRoleName(userService.get(order.getRoleId()).getName());
		adminOrderVO.setProductName(productService.get(order.getProductId()).getProductName());
		return adminOrderVO;
	}
}
