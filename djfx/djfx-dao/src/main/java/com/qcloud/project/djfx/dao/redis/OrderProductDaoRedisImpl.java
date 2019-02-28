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
import com.qcloud.project.djfx.dao.OrderProductDao;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.query.OrderProductQuery;

@Repository
public class OrderProductDaoRedisImpl implements OrderProductDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(OrderProduct orderProduct) {			
		throw new NotImplementedException();
	}

	@Override
	public OrderProduct get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(OrderProduct orderProduct){
		throw new NotImplementedException();
	}
	
	@Override
	public List<OrderProduct> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, OrderProduct> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<OrderProduct> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<OrderProduct> page(OrderProductQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<OrderProduct> listAll(){	
		throw new NotImplementedException();
	}

	@Override
	public Integer count4query(OrderProductQuery query) {
		throw new NotImplementedException();
	}

	@Override
	public OrderProduct getByOrderId(Long orderId) {
		throw new NotImplementedException();
	}
}

