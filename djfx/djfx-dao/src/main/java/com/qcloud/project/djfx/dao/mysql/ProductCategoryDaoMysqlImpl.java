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
import com.qcloud.project.djfx.dao.ProductCategoryDao;
import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;
		
@Repository
public class ProductCategoryDaoMysqlImpl implements ProductCategoryDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(ProductCategory productCategory) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.insert", productCategory) == 1;
	}	
	
	@Override
	public ProductCategory get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(ProductCategory productCategory){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.update", productCategory) > 0;
	}
	
	@Override
	public List<ProductCategory> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ProductCategory> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ProductCategory> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ProductCategory> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.count4page",
				param);
		Page<ProductCategory> page = new Page<ProductCategory>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<ProductCategory> page(ProductCategoryQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("typeName", query.getTypeName());

		List<ProductCategory> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.count4query",
				param);
		Page<ProductCategory> page = new Page<ProductCategory>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<ProductCategory> listAll(){	
		List<ProductCategory> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.ProductCategoryMapper.listAll");
		return list;
	}
}

