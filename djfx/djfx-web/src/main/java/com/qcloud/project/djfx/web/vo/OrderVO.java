package com.qcloud.project.djfx.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class OrderVO {
	
	private long id;		
	
	//订单名称
	private String oName;		
	
	//订单号
	private long oNumber;		
	
	//订单总金额
	private double oSum;		
	
	//订单目标地址
	private String oAddress;		
	
	//订单属于哪个角色
	private long roleId;		
	
	//每个商品需求的数量
	private long oPNumber;		
	
	//产品id
	private long productId;		
	
	//创建时间
	private Date createTime;		
	
	//订单完成时间（已送达的时候完成）
	private Date completionTime;		
	
	//状态（-1删除 0草稿 1已下单 2撤下中 9已完成）默认1
	private int state;		
	
	//总部处理状态（1未处理 2已发货）默认1
	private int processingState;		

	public OrderVO(){
	
	}

	public OrderVO(long id,String oName,long oNumber,double oSum,String oAddress,long roleId,long oPNumber,long productId,Date createTime,Date completionTime,int state,int processingState){
		this.id = id;		
		this.oName = oName;		
		this.oNumber = oNumber;		
		this.oSum = oSum;		
		this.oAddress = oAddress;		
		this.roleId = roleId;		
		this.oPNumber = oPNumber;		
		this.productId = productId;		
		this.createTime = createTime;		
		this.completionTime = completionTime;		
		this.state = state;		
		this.processingState = processingState;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setOName(String oName) {
		this.oName = oName;
	}

	public String getOName() {
		return oName;
	}	
		
	public void setONumber(long oNumber) {
		this.oNumber = oNumber;
	}

	public long getONumber() {
		return oNumber;
	}	
		
	public void setOSum(double oSum) {
		this.oSum = oSum;
	}

	public double getOSum() {
		return oSum;
	}	
		
	public void setOAddress(String oAddress) {
		this.oAddress = oAddress;
	}

	public String getOAddress() {
		return oAddress;
	}	
		
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}	
		
	public void setOPNumber(long oPNumber) {
		this.oPNumber = oPNumber;
	}

	public long getOPNumber() {
		return oPNumber;
	}	
		
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}	
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}	
		
	public void setCompletionTime(Date completionTime) {
		this.completionTime = completionTime;
	}

	public Date getCompletionTime() {
		return completionTime;
	}	
		
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}	
		
	public void setProcessingState(int processingState) {
		this.processingState = processingState;
	}

	public int getProcessingState() {
		return processingState;
	}	
		
}
