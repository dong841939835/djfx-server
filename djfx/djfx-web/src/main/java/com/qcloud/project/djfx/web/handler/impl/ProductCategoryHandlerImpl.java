package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.djfx.web.handler.ProductCategoryHandler;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.web.vo.ProductCategoryVO;
import com.qcloud.project.djfx.web.vo.admin.AdminProductCategoryVO;

@Component
public class ProductCategoryHandlerImpl implements ProductCategoryHandler {

	@Override
	public List<ProductCategoryVO> toVOList(List<ProductCategory> list){
		List<ProductCategoryVO> voList = new ArrayList<ProductCategoryVO>();
		for (ProductCategory productCategory : list) {
			voList.add(toVO(productCategory));
		}
		return voList;
	}

	@Override
	public ProductCategoryVO toVO(ProductCategory productCategory){
		String json = Json.toJson(productCategory);
		return Json.toObject(json, ProductCategoryVO.class, true);

	}

	@Override
	public List<AdminProductCategoryVO> toVOList4Admin(List<ProductCategory> list){
		List<AdminProductCategoryVO> voList = new ArrayList<AdminProductCategoryVO>();
		for (ProductCategory adminProductCategory : list) {
			voList.add(toVO4Admin(adminProductCategory));
		}
		return voList;
	}

	@Override
	public AdminProductCategoryVO toVO4Admin(ProductCategory productCategory){
		String json = Json.toJson(productCategory);
		return Json.toObject(json, AdminProductCategoryVO.class, true);
	}
}
