package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.model.query.InitQuery;

public interface InitService {
	
	public boolean add(Init init);	
	
	public Init get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Init init);

	public Page<Init> page(InitQuery query, int start, int count);
	
	public List<Init> listAll();
}

