package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.ProductCategoryDao;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;

@Repository
public class ProductCategoryDaoCacheImpl implements ProductCategoryDao {
	
	@Autowired
	private ProductCategoryDao productCategoryDaoMysqlImpl;
	
	@Autowired
	private ProductCategoryDao productCategoryDaoRedisImpl;

	@Override
	public boolean add(ProductCategory productCategory) {
		return productCategoryDaoMysqlImpl.add(productCategory);
	}

	@Override
	public ProductCategory get(Long id) {
		return productCategoryDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return productCategoryDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(ProductCategory productCategory){
		return productCategoryDaoMysqlImpl.update(productCategory);
	}
	
	@Override
	public List<ProductCategory> list(List<Long> idList) {
		return CacheLoader.list(productCategoryDaoRedisImpl, productCategoryDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, ProductCategory> map(Set<Long> idSet){
		return CacheLoader.map(productCategoryDaoRedisImpl, productCategoryDaoMysqlImpl, idSet);
	}

	@Override
	public Page<ProductCategory> page(int start, int count){
		return productCategoryDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ProductCategory> page(ProductCategoryQuery query, int start, int count){
		return productCategoryDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ProductCategory> listAll(){
		return productCategoryDaoMysqlImpl.listAll();
	}
}

