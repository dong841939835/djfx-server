package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.UserDao;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.model.query.UserQuery;

@Repository
public class UserDaoCacheImpl implements UserDao {
	
	@Autowired
	private UserDao userDaoMysqlImpl;
	
	@Autowired
	private UserDao userDaoRedisImpl;

	@Override
	public boolean add(User user) {
		return userDaoMysqlImpl.add(user);
	}

	@Override
	public User get(Long id) {
		return userDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return userDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(User user){
		return userDaoMysqlImpl.update(user);
	}
	
	@Override
	public List<User> list(List<Long> idList) {
		return CacheLoader.list(userDaoRedisImpl, userDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, User> map(Set<Long> idSet){
		return CacheLoader.map(userDaoRedisImpl, userDaoMysqlImpl, idSet);
	}

	@Override
	public Page<User> page(int start, int count){
		return userDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<User> page(UserQuery query, int start, int count){
		return userDaoMysqlImpl.page(query, start, count);
	}
	
	public List<User> listAll(){
		return userDaoMysqlImpl.listAll();
	}

	@Override
	public User getByUserName(String userName) {
		return userDaoMysqlImpl.getByUserName(userName);
	}

	@Override
	public User getBysuperiorId(Long superiorId) {
		return userDaoMysqlImpl.getBysuperiorId(superiorId);
	}
}

