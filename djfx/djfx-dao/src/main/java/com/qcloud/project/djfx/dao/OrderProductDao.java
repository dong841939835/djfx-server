package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.query.OrderProductQuery;

public interface OrderProductDao extends ISimpleDao<OrderProduct, Long> {

	public boolean add(OrderProduct orderProduct);

	public OrderProduct get(Long id);

	public boolean delete(Long id);

	public boolean update(OrderProduct orderProduct);

	public List<OrderProduct> list(List<Long> idList);

	public Map<Long, OrderProduct> map(Set<Long> idSet);

	public Page<OrderProduct> page(OrderProductQuery query, int start, int size);

	public List<OrderProduct> listAll();

	public Integer count4query(OrderProductQuery query);

	public OrderProduct getByOrderId(Long orderId);

}
