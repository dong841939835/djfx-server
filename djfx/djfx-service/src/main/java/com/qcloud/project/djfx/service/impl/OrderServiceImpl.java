package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.OrderDao;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.service.OrderService;
import com.qcloud.project.djfx.model.query.OrderQuery;
		
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_order";

	@Override
	public boolean add(Order order) {
		long id = autoIdGenerator.get(ID_KEY);
		order.setId(id);
		
		return orderDao.add(order);
	}

	@Override
	public Order get(Long id) {	
		return orderDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return orderDao.delete(id);
	}
	
	@Override
	public boolean update(Order order) {
		return orderDao.update(order);
	}
	
	@Override
	public Page<Order> page(OrderQuery query, int start, int count) {
		return orderDao.page(query, start, count);
	}
	
	public List<Order> listAll(){
		return orderDao.listAll();
	}

	@Override
	public List<Order> listByNumber(Long oNumber) {
		return orderDao.listByNumber(oNumber);
	}
}

