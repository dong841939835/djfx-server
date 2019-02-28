package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;

public interface ProductCategoryService {
	
	public boolean add(ProductCategory productCategory);	
	
	public ProductCategory get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(ProductCategory productCategory);

	public Page<ProductCategory> page(ProductCategoryQuery query, int start, int count);
	
	public List<ProductCategory> listAll();
}

