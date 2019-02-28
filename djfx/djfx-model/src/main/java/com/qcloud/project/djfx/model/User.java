package com.qcloud.project.djfx.model;

import java.util.Date;
import java.math.BigDecimal;

public class User {

	private Long id;

	// 昵称
	private String name;

	// 账号
	private String userName;

	// 密码
	private String password;

	// 邮箱
	private String email;

	// 电话
	private long phone;

	// 联系地址
	private String contactAddress;

	// qq
	private long qq;

	// 头像地址
	private String headPictureAddress;

	// 创建时间
	private Date createTime;

	// 身份证
	private long idCard;

	// 授权码
	private String authorizationCode;

	// 上级id
	private long superiorId;

	// 库存id
	private long stockId;

	// 角色类型id
	private long roleCategoryId;

	// 状态（-1删除 0未删除）默认0
	private int state;

	public User() {

	}

	public User(Long id, String name, String userName, String password, String email, long phone, String contactAddress,
			long qq, String headPictureAddress, Date createTime, long idCard, String authorizationCode, long superiorId,
			long stockId, long roleCategoryId, int state) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.contactAddress = contactAddress;
		this.qq = qq;
		this.headPictureAddress = headPictureAddress;
		this.createTime = createTime;
		this.idCard = idCard;
		this.authorizationCode = authorizationCode;
		this.superiorId = superiorId;
		this.stockId = stockId;
		this.roleCategoryId = roleCategoryId;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public long getQq() {
		return qq;
	}

	public void setQq(long qq) {
		this.qq = qq;
	}

	public String getHeadPictureAddress() {
		return headPictureAddress;
	}

	public void setHeadPictureAddress(String headPictureAddress) {
		this.headPictureAddress = headPictureAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public long getSuperiorId() {
		return superiorId;
	}

	public void setSuperiorId(long superiorId) {
		this.superiorId = superiorId;
	}

	public long getStockId() {
		return stockId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public long getRoleCategoryId() {
		return roleCategoryId;
	}

	public void setRoleCategoryId(long roleCategoryId) {
		this.roleCategoryId = roleCategoryId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
