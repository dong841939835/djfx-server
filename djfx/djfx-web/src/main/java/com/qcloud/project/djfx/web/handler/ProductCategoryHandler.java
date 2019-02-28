package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.web.vo.ProductCategoryVO;
import com.qcloud.project.djfx.web.vo.admin.AdminProductCategoryVO;

public interface ProductCategoryHandler {

	List<ProductCategoryVO> toVOList(List<ProductCategory> list);

	ProductCategoryVO toVO(ProductCategory productCategory);

	List<AdminProductCategoryVO> toVOList4Admin(List<ProductCategory> list);

	AdminProductCategoryVO toVO4Admin(ProductCategory productCategory);
}
