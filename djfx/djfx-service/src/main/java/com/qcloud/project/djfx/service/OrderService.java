package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.query.OrderQuery;

public interface OrderService {
	
	public boolean add(Order order);	
	
	public Order get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Order order);

	public Page<Order> page(OrderQuery query, int start, int count);
	
	public List<Order> listAll();
	
	public List<Order> listByNumber(Long oNumber);
}

