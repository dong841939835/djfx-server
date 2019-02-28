package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.ProductDao;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.service.ProductService;
import com.qcloud.project.djfx.model.query.ProductQuery;
		
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_product";

	@Override
	public boolean add(Product product) {
		long id = autoIdGenerator.get(ID_KEY);
		product.setId(id);
		
		return productDao.add(product);
	}

	@Override
	public Product get(Long id) {	
		return productDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return productDao.delete(id);
	}
	
	@Override
	public boolean update(Product product) {
		return productDao.update(product);
	}
	
	@Override
	public Page<Product> page(ProductQuery query, int start, int count) {
		return productDao.page(query, start, count);
	}
	
	public List<Product> listAll(){
		return productDao.listAll();
	}
}

