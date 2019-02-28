package com.qcloud.project.djfx.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ProductCategoryVO {
	
	private long id;		
	
	//产品类型
	private int type;		
	
	//缩略图地址
	private String thumbnail;		
	
	//类型名称
	private String typeName;		

	public ProductCategoryVO(){
	
	}

	public ProductCategoryVO(long id,int type,String thumbnail,String typeName){
		this.id = id;		
		this.type = type;		
		this.thumbnail = thumbnail;		
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
		
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getThumbnail() {
		return thumbnail;
	}	
		
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}	
		
}
