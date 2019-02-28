package com.qcloud.project.djfx.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminInitVO {
	
	//ID
	private long id;		
	
	//名称
	private String name;		

	public AdminInitVO(){
	
	}

	public AdminInitVO(long id,String name){
		this.id = id;		
		this.name = name;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
}
