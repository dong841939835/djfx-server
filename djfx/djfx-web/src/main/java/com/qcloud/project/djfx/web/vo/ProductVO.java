package com.qcloud.project.djfx.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ProductVO {
	
	private long id;		
	
	//产品名称
	private String productName;		
	
	//产品缩略图
	private String thumbnail;		
	
	//产品详情图
	private String detailMap;		
	
	//产品介绍
	private String introduce;		
	
	//产品价格
	private double price;		
	
	//优惠价
	private double concessionalRate;		
	
	//规格（150ml/瓶）
	private String specifications;		
	
	//库存id
	private long sockId;		
	
	//创建时间
	private Date createTime;		
	
	//产品类型id
	private long productCategoryId;		
	
	//订单id
	private long orderId;		
	
	//状态（-1删除 0未删除）默认0
	private int state;		

	public ProductVO(){
	
	}

	public ProductVO(long id,String productName,String thumbnail,String detailMap,String introduce,double price,double concessionalRate,String specifications,long sockId,Date createTime,long productCategoryId,long orderId,int state){
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
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductName() {
		return productName;
	}	
		
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnail() {
		return thumbnail;
	}	
		
	public void setDetailMap(String detailMap) {
		this.detailMap = detailMap;
	}

	public String getDetailMap() {
		return detailMap;
	}	
		
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIntroduce() {
		return introduce;
	}	
		
	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}	
		
	public void setConcessionalRate(double concessionalRate) {
		this.concessionalRate = concessionalRate;
	}

	public double getConcessionalRate() {
		return concessionalRate;
	}	
		
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public String getSpecifications() {
		return specifications;
	}	
		
	public void setSockId(long sockId) {
		this.sockId = sockId;
	}

	public long getSockId() {
		return sockId;
	}	
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}	
		
	public void setProductCategoryId(long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public long getProductCategoryId() {
		return productCategoryId;
	}	
		
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderId() {
		return orderId;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
}
