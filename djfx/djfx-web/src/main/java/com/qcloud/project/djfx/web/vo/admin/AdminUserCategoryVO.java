package com.qcloud.project.djfx.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminUserCategoryVO {
	
	//标识符
	private long id;		
	
	//类型（1总部 2经销商 3消费者）
	private int type;		
	
	//类型名称
	private String typeName;		

	public AdminUserCategoryVO(){
	
	}

	public AdminUserCategoryVO(long id,int type,String typeName){
		this.id = id;		
		this.type = type;		
		this.typeName = typeName;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}	
		
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}	
		
}
