package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.InitDao;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.service.InitService;
import com.qcloud.project.djfx.model.query.InitQuery;
		
@Service
public class InitServiceImpl implements InitService{
	
	@Autowired
	private InitDao initDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_init";

	@Override
	public boolean add(Init init) {
		long id = autoIdGenerator.get(ID_KEY);
		init.setId(id);
		
		return initDao.add(init);
	}

	@Override
	public Init get(Long id) {	
		return initDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return initDao.delete(id);
	}
	
	@Override
	public boolean update(Init init) {
		return initDao.update(init);
	}
	
	@Override
	public Page<Init> page(InitQuery query, int start, int count) {
		return initDao.page(query, start, count);
	}
	
	public List<Init> listAll(){
		return initDao.listAll();
	}
}

