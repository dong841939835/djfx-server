package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.query.OrderQuery;
		
public interface OrderDao extends ISimpleDao<Order, Long> {

	public boolean add(Order order);	
	
	public Order get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Order order);
	
	public List<Order> list(List<Long> idList);
	
	public Map<Long, Order> map(Set<Long> idSet);
	
	public Page<Order> page(OrderQuery query, int start, int size);

	public List<Order> listAll();

	public List<Order> listByNumber(Long oNumber);
	
}
