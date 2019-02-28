package com.qcloud.project.djfx.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.djfx.dao.UserDao;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.model.query.UserQuery;

@Repository
public class UserDaoRedisImpl implements UserDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(User user) {			
		throw new NotImplementedException();
	}

	@Override
	public User get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(User user){
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}
	
	@Override
	public Page<User> page(UserQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<User> listAll(){	
		throw new NotImplementedException();
	}

	@Override
	public User getByUserName(String userName) {
		throw new NotImplementedException();
	}

	@Override
	public User getBysuperiorId(Long superiorId) {
		throw new NotImplementedException();
	}
}

