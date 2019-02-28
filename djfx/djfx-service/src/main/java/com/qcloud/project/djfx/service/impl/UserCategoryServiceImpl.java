package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.UserCategoryDao;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.service.UserCategoryService;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;
		
@Service
public class UserCategoryServiceImpl implements UserCategoryService{
	
	@Autowired
	private UserCategoryDao userCategoryDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_userCategory";

	@Override
	public boolean add(UserCategory userCategory) {
		long id = autoIdGenerator.get(ID_KEY);
		userCategory.setId(id);
		
		return userCategoryDao.add(userCategory);
	}

	@Override
	public UserCategory get(Long id) {	
		return userCategoryDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return userCategoryDao.delete(id);
	}
	
	@Override
	public boolean update(UserCategory userCategory) {
		return userCategoryDao.update(userCategory);
	}
	
	@Override
	public Page<UserCategory> page(UserCategoryQuery query, int start, int count) {
		return userCategoryDao.page(query, start, count);
	}
	
	public List<UserCategory> listAll(){
		return userCategoryDao.listAll();
	}
}

