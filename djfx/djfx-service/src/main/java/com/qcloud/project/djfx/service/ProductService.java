package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.query.ProductQuery;

public interface ProductService {
	
	public boolean add(Product product);	
	
	public Product get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Product product);

	public Page<Product> page(ProductQuery query, int start, int count);
	
	public List<Product> listAll();
}

