package com.qcloud.project.djfx.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminStockVO {

	private long id;

	// 产品id
	private long productId;

	// 产品类型
	private String productCategoryName;

	// 产品名字
	private String productName;

	// 产品进货价格
	private Double productPrice;

	// 产品规格
	private String productSpecifications;

	// 产品图片
	private String productFile;

	// 用户角色id
	private long roleId;

	// 属于哪个角色的名称
	private String roleName;

	// 创建时间
	private Date createTime;

	// 时间str
	private String createTimeStr;

	// 换算出来的总数量（50个/箱）
	private long totalQuantity;

	// 状态（-9删除 -1没库存 0有库存）默认0
	private int sState;

	private String stateStr;

	public AdminStockVO() {

	}

	public AdminStockVO(long id, long productId, long roleId, Date createTime, long totalQuantity, int sState) {
		this.id = id;
		this.productId = productId;
		this.roleId = roleId;
		this.createTime = createTime;
		this.totalQuantity = totalQuantity;
		this.sState = sState;
	}

	public String getProductFile() {
		return productFile;
	}

	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(String productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public int getsState() {
		return sState;
	}

	public void setsState(int sState) {
		this.sState = sState;
	}

	public String getStateStr() {
		return stateStr;
	}

	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
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

}
