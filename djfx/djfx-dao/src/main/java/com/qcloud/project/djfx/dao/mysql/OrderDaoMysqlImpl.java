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
import com.qcloud.project.djfx.dao.OrderDao;
import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.query.OrderQuery;
		
@Repository
public class OrderDaoMysqlImpl implements OrderDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Order order) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.insert", order) == 1;
	}	
	
	@Override
	public Order get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Order order){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.update", order) > 0;
	}
	
	@Override
	public List<Order> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Order> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Order> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Order> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.count4page",
				param);
		Page<Order> page = new Page<Order>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Order> page(OrderQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("state1", query.getState());
		param.put("state2", query.getState2());
		param.put("state3", query.getState3());
		if (query.getoNumber()!= null) {
			param.put("oNumber", query.getoNumber());
		}
		if (query.getStartTime()!=null) {
			param.put("startTime", query.getStartTime());
		}
		if (query.getEndTime()!=null) {
			param.put("endTime", query.getEndTime());
		}
		if (query.getSearchState()!=null) {
			param.put("searchState", query.getSearchState());
		}
		param.put("roleId", query.getRoleId());
		param.put("searchState2", query.getSearchState2());

		List<Order> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.count4query",
				param);
		Page<Order> page = new Page<Order>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Order> listAll(){	
		List<Order> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.listAll");
		return list;
	}

	@Override
	public List<Order> listByNumber(Long oNumber) {
		List<Order> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.OrderMapper.listByNumber");
		return list;
	}
}

