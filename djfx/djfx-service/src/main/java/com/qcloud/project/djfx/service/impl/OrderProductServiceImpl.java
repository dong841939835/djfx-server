package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.OrderProductDao;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.service.OrderProductService;
import com.qcloud.project.djfx.model.query.OrderProductQuery;
		
@Service
public class OrderProductServiceImpl implements OrderProductService{
	
	@Autowired
	private OrderProductDao orderProductDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_order_product";

	@Override
	public boolean add(OrderProduct orderProduct) {
		long id = autoIdGenerator.get(ID_KEY);
		orderProduct.setId(id);
		
		return orderProductDao.add(orderProduct);
	}

	@Override
	public OrderProduct get(Long id) {	
		return orderProductDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return orderProductDao.delete(id);
	}
	
	@Override
	public boolean update(OrderProduct orderProduct) {
		return orderProductDao.update(orderProduct);
	}
	
	@Override
	public Page<OrderProduct> page(OrderProductQuery query, int start, int count) {
		return orderProductDao.page(query, start, count);
	}
	
	public List<OrderProduct> listAll(){
		return orderProductDao.listAll();
	}

	@Override
	public Integer count4query(OrderProductQuery query) {
		return orderProductDao.count4query(query);
	}

	@Override
	public OrderProduct getByOrderId(Long orderId) {
		return orderProductDao.getByOrderId(orderId);
	}
}

