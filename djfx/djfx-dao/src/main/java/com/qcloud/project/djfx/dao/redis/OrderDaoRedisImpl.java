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
import com.qcloud.project.djfx.dao.OrderDao;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.query.OrderQuery;

@Repository
public class OrderDaoRedisImpl implements OrderDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(Order order) {			
		throw new NotImplementedException();
	}

	@Override
	public Order get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Order order){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Order> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Order> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Order> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Order> page(OrderQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Order> listAll(){	
		throw new NotImplementedException();
	}

	@Override
	public List<Order> listByNumber(Long oNumber) {
		throw new NotImplementedException();
	}
}

