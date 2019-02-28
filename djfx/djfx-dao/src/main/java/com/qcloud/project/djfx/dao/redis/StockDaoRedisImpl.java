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
import com.qcloud.project.djfx.dao.StockDao;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.query.StockQuery;

@Repository
public class StockDaoRedisImpl implements StockDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(Stock stock) {			
		throw new NotImplementedException();
	}

	@Override
	public Stock get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Stock stock){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Stock> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Stock> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Stock> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Stock> page(StockQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Stock> listAll(){	
		throw new NotImplementedException();
	}

	@Override
	public List<Stock> listByProductId(Long productId) {
		throw new NotImplementedException();
	}

	@Override
	public Stock getByRoleAndPro(Long roleId, Long productId) {
		throw new NotImplementedException();
	}
}

