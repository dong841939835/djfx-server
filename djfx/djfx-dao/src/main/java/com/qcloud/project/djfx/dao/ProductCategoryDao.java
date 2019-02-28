package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;
		
public interface ProductCategoryDao extends ISimpleDao<ProductCategory, Long> {

	public boolean add(ProductCategory productCategory);	
	
	public ProductCategory get(Long id);

	public boolean delete(Long id);
	
	public boolean update(ProductCategory productCategory);
	
	public List<ProductCategory> list(List<Long> idList);
	
	public Map<Long, ProductCategory> map(Set<Long> idSet);
	
	public Page<ProductCategory> page(ProductCategoryQuery query, int start, int size);

	public List<ProductCategory> listAll();
	
}
