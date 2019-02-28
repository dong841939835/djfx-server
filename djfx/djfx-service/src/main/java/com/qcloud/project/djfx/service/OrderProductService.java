package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.query.OrderProductQuery;
import com.qcloud.project.djfx.model.query.OrderQuery;

public interface OrderProductService {
	
	public boolean add(OrderProduct orderProduct);	
	
	public OrderProduct get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(OrderProduct orderProduct);

	public Page<OrderProduct> page(OrderProductQuery query, int start, int count);
	
	public List<OrderProduct> listAll();
	
	public Integer count4query(OrderProductQuery query);
	
	public OrderProduct getByOrderId(Long orderId);
}

