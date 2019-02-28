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
import com.qcloud.project.djfx.dao.StockDao;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.query.StockQuery;
		
@Repository
public class StockDaoMysqlImpl implements StockDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Stock stock) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.insert", stock) == 1;
	}	
	
	@Override
	public Stock get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Stock stock){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.update", stock) > 0;
	}
	
	@Override
	public List<Stock> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Stock> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Stock> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Stock> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.count4page",
				param);
		Page<Stock> page = new Page<Stock>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Stock> page(StockQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("roleId", query.getRoleId());

		List<Stock> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.count4query",
				param);
		Page<Stock> page = new Page<Stock>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Stock> listAll(){	
		List<Stock> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.listAll");
		return list;
	}

	@Override
	public List<Stock> listByProductId(Long productId) {
		List<Stock> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.listByProductId",productId);
		return list;
	}

	@Override
	public Stock getByRoleAndPro(Long roleId, Long productId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("productId", productId);
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.StockMapper.getByRoleAndPro", param);
	}
}

