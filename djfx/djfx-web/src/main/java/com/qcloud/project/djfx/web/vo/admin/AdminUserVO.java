package com.qcloud.project.djfx.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminUserVO {

	private long id;

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

	// 时间str
	private String createTimeStr;

	// 身份证
	private long idCard;

	// 授权码
	private String authorizationCode;

	// 上级id
	private long superiorId;
	
	// 上级昵称
	private String superiorName;

	// 库存id
	private long stockId;

	// 角色类型id
	private long roleCategoryId;

	// 类型名称
	private String roleCategoryStr;

	// 状态（-1删除 0未删除）默认0
	private int state;

	public AdminUserVO() {

	}

	public AdminUserVO(long id, String name, String userName, String password, String email, long phone,
			String contactAddress, long qq, String headPictureAddress, Date createTime, long idCard,
			String authorizationCode, long superiorId, long stockId, long roleCategoryId, int state) {
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

	public String getSuperiorName() {
		return superiorName;
	}

	public void setSuperiorName(String superiorName) {
		this.superiorName = superiorName;
	}

	public String getRoleCategoryStr() {
		return roleCategoryStr;
	}

	public void setRoleCategoryStr(String roleCategoryStr) {
		this.roleCategoryStr = roleCategoryStr;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
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

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public long getPhone() {
		return phone;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setQq(long qq) {
		this.qq = qq;
	}

	public long getQq() {
		return qq;
	}

	public void setHeadPictureAddress(String headPictureAddress) {
		this.headPictureAddress = headPictureAddress;
	}

	public String getHeadPictureAddress() {
		return headPictureAddress;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	public long getIdCard() {
		return idCard;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setSuperiorId(long superiorId) {
		this.superiorId = superiorId;
	}

	public long getSuperiorId() {
		return superiorId;
	}

	public void setStockId(long stockId) {
		this.stockId = stockId;
	}

	public long getStockId() {
		return stockId;
	}

	public void setRoleCategoryId(long roleCategoryId) {
		this.roleCategoryId = roleCategoryId;
	}

	public long getRoleCategoryId() {
		return roleCategoryId;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}
