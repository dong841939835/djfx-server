package com.qcloud.project.djfx.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.query.StockQuery;
		
public interface StockDao extends ISimpleDao<Stock, Long> {

	public boolean add(Stock stock);	
	
	public Stock get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Stock stock);
	
	public List<Stock> list(List<Long> idList);
	
	public Map<Long, Stock> map(Set<Long> idSet);
	
	public Page<Stock> page(StockQuery query, int start, int size);

	public List<Stock> listAll();
	
	public List<Stock> listByProductId(Long productId);

	public Stock getByRoleAndPro(Long roleId, Long productId);
	
}
