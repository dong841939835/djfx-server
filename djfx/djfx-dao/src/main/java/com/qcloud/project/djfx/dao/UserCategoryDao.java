package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;
		
public interface UserCategoryDao extends ISimpleDao<UserCategory, Long> {

	public boolean add(UserCategory userCategory);	
	
	public UserCategory get(Long id);

	public boolean delete(Long id);
	
	public boolean update(UserCategory userCategory);
	
	public List<UserCategory> list(List<Long> idList);
	
	public Map<Long, UserCategory> map(Set<Long> idSet);
	
	public Page<UserCategory> page(UserCategoryQuery query, int start, int size);

	public List<UserCategory> listAll();
	
}
