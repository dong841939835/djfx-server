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
import com.qcloud.project.djfx.dao.UserCategoryDao;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;

@Repository
public class UserCategoryDaoRedisImpl implements UserCategoryDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(UserCategory userCategory) {			
		throw new NotImplementedException();
	}

	@Override
	public UserCategory get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(UserCategory userCategory){
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}
	
	@Override
	public Page<UserCategory> page(UserCategoryQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<UserCategory> listAll(){	
		throw new NotImplementedException();
	}
}

