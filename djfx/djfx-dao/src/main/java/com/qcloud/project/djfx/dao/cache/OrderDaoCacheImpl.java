package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.OrderDao;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.query.OrderQuery;

@Repository
public class OrderDaoCacheImpl implements OrderDao {
	
	@Autowired
	private OrderDao orderDaoMysqlImpl;
	
	@Autowired
	private OrderDao orderDaoRedisImpl;

	@Override
	public boolean add(Order order) {
		return orderDaoMysqlImpl.add(order);
	}

	@Override
	public Order get(Long id) {
		return orderDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return orderDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Order order){
		return orderDaoMysqlImpl.update(order);
	}
	
	@Override
	public List<Order> list(List<Long> idList) {
		return CacheLoader.list(orderDaoRedisImpl, orderDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Order> map(Set<Long> idSet){
		return CacheLoader.map(orderDaoRedisImpl, orderDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Order> page(int start, int count){
		return orderDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Order> page(OrderQuery query, int start, int count){
		return orderDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Order> listAll(){
		return orderDaoMysqlImpl.listAll();
	}

	@Override
	public List<Order> listByNumber(Long oNumber) {
		return orderDaoMysqlImpl.listByNumber(oNumber);
	}
}

