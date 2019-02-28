package com.qcloud.project.djfx.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class OrderProductVO {

	private Long id;

	private String productId;

	private Long orderId;

	public OrderProductVO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrderProductVO(Long id, String productId, Long orderId) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
	}

}
