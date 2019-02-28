package com.qcloud.project.djfx.model.query;

public class OrderProductQuery {

	private Integer state;

	private Long orderId;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public OrderProductQuery() {

	}
}
