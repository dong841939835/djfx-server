package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.UserCategoryDao;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;

@Repository
public class UserCategoryDaoCacheImpl implements UserCategoryDao {
	
	@Autowired
	private UserCategoryDao userCategoryDaoMysqlImpl;
	
	@Autowired
	private UserCategoryDao userCategoryDaoRedisImpl;

	@Override
	public boolean add(UserCategory userCategory) {
		return userCategoryDaoMysqlImpl.add(userCategory);
	}

	@Override
	public UserCategory get(Long id) {
		return userCategoryDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return userCategoryDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(UserCategory userCategory){
		return userCategoryDaoMysqlImpl.update(userCategory);
	}
	
	@Override
	public List<UserCategory> list(List<Long> idList) {
		return CacheLoader.list(userCategoryDaoRedisImpl, userCategoryDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, UserCategory> map(Set<Long> idSet){
		return CacheLoader.map(userCategoryDaoRedisImpl, userCategoryDaoMysqlImpl, idSet);
	}

	@Override
	public Page<UserCategory> page(int start, int count){
		return userCategoryDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<UserCategory> page(UserCategoryQuery query, int start, int count){
		return userCategoryDaoMysqlImpl.page(query, start, count);
	}
	
	public List<UserCategory> listAll(){
		return userCategoryDaoMysqlImpl.listAll();
	}
}

