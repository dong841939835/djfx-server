package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.UserDao;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.model.query.UserQuery;
		
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_user";

	@Override
	public boolean add(User user) {
		long id = autoIdGenerator.get(ID_KEY);
		user.setId(id);
		
		return userDao.add(user);
	}

	@Override
	public User get(Long id) {	
		return userDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return userDao.delete(id);
	}
	
	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}
	
	@Override
	public Page<User> page(UserQuery query, int start, int count) {
		return userDao.page(query, start, count);
	}
	
	public List<User> listAll(){
		return userDao.listAll();
	}

	@Override
	public User getByUserName(String userName) {
		return userDao.getByUserName(userName);
	}

	@Override
	public User getBysuperiorId(Long superiorId) {
		return userDao.getBysuperiorId(superiorId);
	}
}

