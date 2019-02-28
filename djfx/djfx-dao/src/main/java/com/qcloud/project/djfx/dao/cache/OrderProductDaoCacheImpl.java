package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.OrderProductDao;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.query.OrderProductQuery;

@Repository
public class OrderProductDaoCacheImpl implements OrderProductDao {
	
	@Autowired
	private OrderProductDao orderProductDaoMysqlImpl;
	
	@Autowired
	private OrderProductDao orderProductDaoRedisImpl;

	@Override
	public boolean add(OrderProduct orderProduct) {
		return orderProductDaoMysqlImpl.add(orderProduct);
	}

	@Override
	public OrderProduct get(Long id) {
		return orderProductDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return orderProductDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(OrderProduct orderProduct){
		return orderProductDaoMysqlImpl.update(orderProduct);
	}
	
	@Override
	public List<OrderProduct> list(List<Long> idList) {
		return CacheLoader.list(orderProductDaoRedisImpl, orderProductDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, OrderProduct> map(Set<Long> idSet){
		return CacheLoader.map(orderProductDaoRedisImpl, orderProductDaoMysqlImpl, idSet);
	}

	@Override
	public Page<OrderProduct> page(int start, int count){
		return orderProductDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<OrderProduct> page(OrderProductQuery query, int start, int count){
		return orderProductDaoMysqlImpl.page(query, start, count);
	}
	
	public List<OrderProduct> listAll(){
		return orderProductDaoMysqlImpl.listAll();
	}

	@Override
	public Integer count4query(OrderProductQuery query) {
		return orderProductDaoMysqlImpl.count4query(query);
	}

	@Override
	public OrderProduct getByOrderId(Long orderId) {
		return orderProductDaoMysqlImpl.getByOrderId(orderId);
	}
}

