package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.ProductCategoryDao;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.service.ProductCategoryService;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;
		
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_productCategory";

	@Override
	public boolean add(ProductCategory productCategory) {
		long id = autoIdGenerator.get(ID_KEY);
		productCategory.setId(id);
		
		return productCategoryDao.add(productCategory);
	}

	@Override
	public ProductCategory get(Long id) {	
		return productCategoryDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return productCategoryDao.delete(id);
	}
	
	@Override
	public boolean update(ProductCategory productCategory) {
		return productCategoryDao.update(productCategory);
	}
	
	@Override
	public Page<ProductCategory> page(ProductCategoryQuery query, int start, int count) {
		return productCategoryDao.page(query, start, count);
	}
	
	public List<ProductCategory> listAll(){
		return productCategoryDao.listAll();
	}
}

