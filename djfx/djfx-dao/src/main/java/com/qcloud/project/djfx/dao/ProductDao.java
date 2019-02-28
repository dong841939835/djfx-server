package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.query.ProductQuery;
		
public interface ProductDao extends ISimpleDao<Product, Long> {

	public boolean add(Product product);	
	
	public Product get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Product product);
	
	public List<Product> list(List<Long> idList);
	
	public Map<Long, Product> map(Set<Long> idSet);
	
	public Page<Product> page(ProductQuery query, int start, int size);

	public List<Product> listAll();
	
}
