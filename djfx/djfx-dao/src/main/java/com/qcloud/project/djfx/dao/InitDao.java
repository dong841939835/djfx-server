package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.model.query.InitQuery;
		
public interface InitDao extends ISimpleDao<Init, Long> {

	public boolean add(Init init);	
	
	public Init get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Init init);
	
	public List<Init> list(List<Long> idList);
	
	public Map<Long, Init> map(Set<Long> idSet);
	
	public Page<Init> page(InitQuery query, int start, int size);

	public List<Init> listAll();
	
}
