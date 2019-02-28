package com.qcloud.project.djfx.model;

import java.util.Date;
import java.math.BigDecimal;

public class Product {

	private Long id;

	// 产品名称
	private String productName;

	// 产品缩略图
	private String thumbnail;

	// 产品详情图
	private String detailMap;

	// 产品介绍
	private String introduce;

	// 产品价格
	private Double price;

	// 优惠价
	private Double concessionalRate;

	// 规格（150ml/瓶）
	private String specifications;

	// 库存id
	private Long sockId;

	// 创建时间
	private Date createTime;

	// 产品类型id
	private Long productCategoryId;

	// 订单id
	private Long orderId;

	// 状态（-1删除 0未删除）默认0
	private int state;

	public Product() {

	}

	public Product(Long id, String productName, String thumbnail, String detailMap, String introduce, Double price,
			Double concessionalRate, String specifications, Long sockId, Date createTime, Long productCategoryId,
			Long orderId, int state) {
		super();
		this.id = id;
		this.productName = productName;
		this.thumbnail = thumbnail;
		this.detailMap = detailMap;
		this.introduce = introduce;
		this.price = price;
		this.concessionalRate = concessionalRate;
		this.specifications = specifications;
		this.sockId = sockId;
		this.createTime = createTime;
		this.productCategoryId = productCategoryId;
		this.orderId = orderId;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDetailMap() {
		return detailMap;
	}

	public void setDetailMap(String detailMap) {
		this.detailMap = detailMap;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getConcessionalRate() {
		return concessionalRate;
	}

	public void setConcessionalRate(Double concessionalRate) {
		this.concessionalRate = concessionalRate;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public Long getSockId() {
		return sockId;
	}

	public void setSockId(Long sockId) {
		this.sockId = sockId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
