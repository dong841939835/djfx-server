package com.qcloud.project.djfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.StockDao;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.service.StockService;
import com.qcloud.project.djfx.model.query.StockQuery;
		
@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "djfx_stock";

	@Override
	public boolean add(Stock stock) {
		long id = autoIdGenerator.get(ID_KEY);
		stock.setId(id);
		
		return stockDao.add(stock);
	}

	@Override
	public Stock get(Long id) {	
		return stockDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return stockDao.delete(id);
	}
	
	@Override
	public boolean update(Stock stock) {
		return stockDao.update(stock);
	}
	
	@Override
	public Page<Stock> page(StockQuery query, int start, int count) {
		return stockDao.page(query, start, count);
	}
	
	public List<Stock> listAll(){
		return stockDao.listAll();
	}

	@Override
	public List<Stock> listByProductId(Long productId) {
		return stockDao.listByProductId(productId);
	}

	@Override
	public Stock getByRoleAndPro(Long roleId, Long productId) {
		return stockDao.getByRoleAndPro(roleId,productId);
	}
}

