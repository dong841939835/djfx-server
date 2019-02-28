package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.web.vo.OrderVO;
import com.qcloud.project.djfx.web.vo.admin.AdminOrderVO;

public interface OrderHandler {

	List<OrderVO> toVOList(List<Order> list);

	OrderVO toVO(Order order);

	List<AdminOrderVO> toVOList4Admin(List<Order> list);

	AdminOrderVO toVO4Admin(Order order);
}
