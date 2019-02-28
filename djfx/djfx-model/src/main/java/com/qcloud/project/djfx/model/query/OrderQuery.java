package com.qcloud.project.djfx.model.query;

import java.util.Date;

public class OrderQuery {

	private Integer state;

	private Integer processingState;

	private Integer state2;

	private Integer state3;

	private Date startTime;

	private Date endTime;

	// 订单号
	private Long oNumber;

	private Integer searchState;
	
	private Integer searchState2;

	private Long roleId;

	public OrderQuery() {
		super();
	}

	public OrderQuery(Integer state, Integer processingState, Integer state2, Date startTime, Date endTime,
			Long oNumber, Integer searchState) {
		super();
		this.state = state;
		this.processingState = processingState;
		this.state2 = state2;
		this.startTime = startTime;
		this.endTime = endTime;
		this.oNumber = oNumber;
		this.searchState = searchState;
	}

	public Integer getSearchState2() {
		return searchState2;
	}

	public void setSearchState2(Integer searchState2) {
		this.searchState2 = searchState2;
	}

	public Integer getState3() {
		return state3;
	}

	public void setState3(Integer state3) {
		this.state3 = state3;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getProcessingState() {
		return processingState;
	}

	public void setProcessingState(Integer processingState) {
		this.processingState = processingState;
	}

	public Integer getState2() {
		return state2;
	}

	public void setState2(Integer state2) {
		this.state2 = state2;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getoNumber() {
		return oNumber;
	}

	public void setoNumber(Long oNumber) {
		this.oNumber = oNumber;
	}

	public Integer getSearchState() {
		return searchState;
	}

	public void setSearchState(Integer searchState) {
		this.searchState = searchState;
	}

}
