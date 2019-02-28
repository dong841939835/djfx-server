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
import com.qcloud.project.djfx.dao.UserDao;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.model.query.UserQuery;
		
@Repository
public class UserDaoMysqlImpl implements UserDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(User user) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.insert", user) == 1;
	}	
	
	@Override
	public User get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(User user){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.update", user) > 0;
	}
	
	@Override
	public List<User> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, User> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<User> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<User> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.count4page",
				param);
		Page<User> page = new Page<User>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<User> page(UserQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("superiorId", query.getSuperiorId());

		List<User> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.count4query",
				param);
		Page<User> page = new Page<User>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<User> listAll(){	
		List<User> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.listAll");
		return list;
	}

	@Override
	public User getByUserName(String userName) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.getByUserName", userName);
	}

	@Override
	public User getBysuperiorId(Long superiorId) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.UserMapper.getBysuperiorId", superiorId);
	}
}

