package com.qcloud.project.djfx.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.djfx.dao.OrderProductDao;
import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.query.OrderProductQuery;
		
@Repository
public class OrderProductDaoMysqlImpl implements OrderProductDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(OrderProduct orderProduct) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.insert", orderProduct) == 1;
	}	
	
	@Override
	public OrderProduct get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(OrderProduct orderProduct){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.update", orderProduct) > 0;
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
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<OrderProduct> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.count4page",
				param);
		Page<OrderProduct> page = new Page<OrderProduct>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<OrderProduct> page(OrderProductQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("state", query.getState());
		param.put("orderId", query.getOrderId());
		

		List<OrderProduct> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.count4query",
				param);
		Page<OrderProduct> page = new Page<OrderProduct>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<OrderProduct> listAll(){	
		List<OrderProduct> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.listAll");
		return list;
	}

	@Override
	public Integer count4query(OrderProductQuery query) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("state", query.getState());
		
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.count4query",
				param);
		return total;
	}

	@Override
	public OrderProduct getByOrderId(Long orderId) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.OrderProductMapper.getByOrderId", orderId);
	}
}

