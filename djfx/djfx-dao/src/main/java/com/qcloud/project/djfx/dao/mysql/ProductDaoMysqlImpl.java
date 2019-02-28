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
import com.qcloud.project.djfx.dao.ProductDao;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.query.ProductQuery;
		
@Repository
public class ProductDaoMysqlImpl implements ProductDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Product product) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.insert", product) == 1;
	}	
	
	@Override
	public Product get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Product product){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.update", product) > 0;
	}
	
	@Override
	public List<Product> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Product> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Product> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Product> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.count4page",
				param);
		Page<Product> page = new Page<Product>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Product> page(ProductQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("productName", query.getProductName());

		List<Product> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.count4query",
				param);
		Page<Product> page = new Page<Product>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Product> listAll(){	
		List<Product> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductMapper.listAll");
		return list;
	}
}

