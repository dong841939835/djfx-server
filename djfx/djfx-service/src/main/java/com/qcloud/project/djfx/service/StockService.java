package com.qcloud.project.djfx.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.query.StockQuery;

public interface StockService {
	
	public boolean add(Stock stock);	
	
	public Stock get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(Stock stock);

	public Page<Stock> page(StockQuery query, int start, int count);
	
	public List<Stock> listAll();
	
	public List<Stock> listByProductId(Long productId);
	
	public Stock getByRoleAndPro(Long roleId,Long productId);
}

