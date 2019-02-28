package com.qcloud.project.djfx.model;

import java.util.Date;
import java.math.BigDecimal;

public class OrderProduct {

	private Long id;

	private String productId;

	private Long orderId;

	public OrderProduct() {

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

	public OrderProduct(Long id, String productId, Long orderId) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
	}

}
