package com.qcloud.project.djfx.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class StockVO {
	
	private long id;		
	
	//产品id
	private long productId;		
	
	//用户角色id
	private long roleId;		
	
	//创建时间
	private Date createTime;		
	
	//换算出来的总数量（50个/箱）
	private long totalQuantity;		
	
	//状态（-9删除 -1没库存 0有库存）默认0
	private int sState;		

	public StockVO(){
	
	}

	public StockVO(long id,long productId,long roleId,Date createTime,long totalQuantity,int sState){
		this.id = id;		
		this.productId = productId;		
		this.roleId = roleId;		
		this.createTime = createTime;		
		this.totalQuantity = totalQuantity;		
		this.sState = sState;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getProductId() {
		return productId;
	}	
		
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getRoleId() {
		return roleId;
	}	
		
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}	
		
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public long getTotalQuantity() {
		return totalQuantity;
	}	
		
	public void setSState(int sState) {
		this.sState = sState;
	}

	public int getSState() {
		return sState;
	}	
		
}
