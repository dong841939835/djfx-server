package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.InitDao;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.model.query.InitQuery;

@Repository
public class InitDaoCacheImpl implements InitDao {
	
	@Autowired
	private InitDao initDaoMysqlImpl;
	
	@Autowired
	private InitDao initDaoRedisImpl;

	@Override
	public boolean add(Init init) {
		return initDaoMysqlImpl.add(init);
	}

	@Override
	public Init get(Long id) {
		return initDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return initDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Init init){
		return initDaoMysqlImpl.update(init);
	}
	
	@Override
	public List<Init> list(List<Long> idList) {
		return CacheLoader.list(initDaoRedisImpl, initDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Init> map(Set<Long> idSet){
		return CacheLoader.map(initDaoRedisImpl, initDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Init> page(int start, int count){
		return initDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Init> page(InitQuery query, int start, int count){
		return initDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Init> listAll(){
		return initDaoMysqlImpl.listAll();
	}
}

