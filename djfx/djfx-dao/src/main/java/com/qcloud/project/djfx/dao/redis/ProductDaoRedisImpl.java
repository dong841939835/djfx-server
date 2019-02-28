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
import com.qcloud.project.djfx.dao.ProductDao;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.query.ProductQuery;

@Repository
public class ProductDaoRedisImpl implements ProductDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(Product product) {			
		throw new NotImplementedException();
	}

	@Override
	public Product get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Product product){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Product> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Product> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Product> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Product> page(ProductQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Product> listAll(){	
		throw new NotImplementedException();
	}
}

