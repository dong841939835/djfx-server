package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.djfx.web.handler.OrderProductHandler;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.OrderService;
import com.qcloud.project.djfx.service.ProductService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.web.vo.OrderProductVO;
import com.qcloud.project.djfx.web.vo.admin.AdminOrderProductVO;

@Component
public class OrderProductHandlerImpl implements OrderProductHandler {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;

	@Override
	public List<OrderProductVO> toVOList(List<OrderProduct> list) {
		List<OrderProductVO> voList = new ArrayList<OrderProductVO>();
		for (OrderProduct orderProduct : list) {
			voList.add(toVO(orderProduct));
		}
		return voList;
	}

	@Override
	public OrderProductVO toVO(OrderProduct orderProduct) {
		String json = Json.toJson(orderProduct);
		return Json.toObject(json, OrderProductVO.class, true);

	}

	@Override
	public List<AdminOrderProductVO> toVOList4Admin(List<OrderProduct> list) {
		List<AdminOrderProductVO> voList = new ArrayList<AdminOrderProductVO>();
		for (OrderProduct adminOrderProduct : list) {
			voList.add(toVO4Admin(adminOrderProduct));
		}
		return voList;
	}

	@Override
	public AdminOrderProductVO toVO4Admin(OrderProduct orderProduct) {
		String json = Json.toJson(orderProduct);
		AdminOrderProductVO adminOrderProductVO = Json.toObject(json, AdminOrderProductVO.class, true);
		// 拆分字符串变为id
		String[] orderIdStr = orderProduct.getProductId().split("-");
		long[] orderIdLong = (long[]) ConvertUtils.convert(orderIdStr, long.class);

		String productName = "";
		// long productNum = 0;
		Double sum = 0.0;
		int state = 0;

		for (long orderId : orderIdLong) {
			Order order = orderService.get(orderId);
			productName += productService.get(order.getProductId()).getProductName() + "&" + order.getoPNumber()
					+ " , ";
			sum += order.getOSum();
			adminOrderProductVO.setRoleName(userService.get(order.getRoleId()).getName());
			adminOrderProductVO.setAddress(userService.get(order.getRoleId()).getContactAddress());
			adminOrderProductVO.setPhone(userService.get(order.getRoleId()).getPhone());
			state = order.getProcessingState();
			if (state == TypeEnum.OrderProcessingState.WEICHULI.getKey()) {
				adminOrderProductVO.setStateStr("未发货");
			} else if (state == TypeEnum.OrderProcessingState.FAHUOZHONG.getKey()
					|| state == TypeEnum.OrderProcessingState.YISONGDA.getKey()) {
				adminOrderProductVO.setStateStr("已发货");
			} else if(state == TypeEnum.OrderProcessingState.ZANBUCHULI.getKey()){
				adminOrderProductVO.setStateStr("订单被撤销，暂不处理");
			}
		}
		adminOrderProductVO.setProductName(productName);
		adminOrderProductVO.setSum(sum);

		return adminOrderProductVO;
	}
}
