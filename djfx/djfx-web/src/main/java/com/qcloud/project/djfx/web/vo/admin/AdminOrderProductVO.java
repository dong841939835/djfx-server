package com.qcloud.project.djfx.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminOrderProductVO {

	private Long id;

	private String productId;

	private Long orderId;
	
	//产品名称，逗号隔开
	private String productName;
	
	//产品数量，逗号隔开
	private Long productNum;
	
	//总价格
	private Double sum;
	
	//产品属于谁
	private String roleName;
	
	//产品地址
	private String address;
	
	//收货人电话
	private Long phone;
	
	//状态 processingState 1未发货  2.3已发货
	private String stateStr;

	public AdminOrderProductVO() {

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

	public AdminOrderProductVO(Long id, String productId, Long orderId) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
}
