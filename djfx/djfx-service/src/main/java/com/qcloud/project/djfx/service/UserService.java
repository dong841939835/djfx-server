package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.model.query.UserQuery;

public interface UserService {
	
	public boolean add(User user);	
	
	public User get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(User user);

	public Page<User> page(UserQuery query, int start, int count);
	
	public List<User> listAll();
	
	public User getByUserName(String userName);
	
	public User getBysuperiorId(Long superiorId);
}

