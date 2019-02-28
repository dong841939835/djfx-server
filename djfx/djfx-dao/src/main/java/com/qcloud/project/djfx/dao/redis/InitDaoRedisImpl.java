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
import com.qcloud.project.djfx.dao.InitDao;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.model.query.InitQuery;

@Repository
public class InitDaoRedisImpl implements InitDao {

	//@Resource(name = "redis-djfx")
	//private Redis redis;

	@Override
	public boolean add(Init init) {			
		throw new NotImplementedException();
	}

	@Override
	public Init get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Init init){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Init> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Init> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Init> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Init> page(InitQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Init> listAll(){	
		throw new NotImplementedException();
	}
}

