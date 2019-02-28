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
import com.qcloud.project.djfx.dao.UserCategoryDao;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;
		
@Repository
public class UserCategoryDaoMysqlImpl implements UserCategoryDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(UserCategory userCategory) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.insert", userCategory) == 1;
	}	
	
	@Override
	public UserCategory get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(UserCategory userCategory){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.update", userCategory) > 0;
	}
	
	@Override
	public List<UserCategory> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, UserCategory> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<UserCategory> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<UserCategory> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.count4page",
				param);
		Page<UserCategory> page = new Page<UserCategory>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<UserCategory> page(UserCategoryQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<UserCategory> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.count4query",
				param);
		Page<UserCategory> page = new Page<UserCategory>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<UserCategory> listAll(){	
		List<UserCategory> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserCategoryMapper.listAll");
		return list;
	}
}

