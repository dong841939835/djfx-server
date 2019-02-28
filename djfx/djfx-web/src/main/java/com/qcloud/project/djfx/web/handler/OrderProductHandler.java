package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.web.vo.OrderProductVO;
import com.qcloud.project.djfx.web.vo.admin.AdminOrderProductVO;

public interface OrderProductHandler {

	List<OrderProductVO> toVOList(List<OrderProduct> list);

	OrderProductVO toVO(OrderProduct orderProduct);

	List<AdminOrderProductVO> toVOList4Admin(List<OrderProduct> list);

	AdminOrderProductVO toVO4Admin(OrderProduct orderProduct);
}
