package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;

public interface UserCategoryService {
	
	public boolean add(UserCategory userCategory);	
	
	public UserCategory get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(UserCategory userCategory);

	public Page<UserCategory> page(UserCategoryQuery query, int start, int count);
	
	public List<UserCategory> listAll();
}

