package com.qcloud.project.djfx.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.djfx.dao.ProductCategoryDao;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;

@Repository
public class ProductCategoryDaoRedisImpl implements ProductCategoryDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(ProductCategory productCategory) {			
		throw new NotImplementedException();
	}

	@Override
	public ProductCategory get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(ProductCategory productCategory){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ProductCategory> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ProductCategory> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ProductCategory> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<ProductCategory> page(ProductCategoryQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ProductCategory> listAll(){	
		throw new NotImplementedException();
	}
}

