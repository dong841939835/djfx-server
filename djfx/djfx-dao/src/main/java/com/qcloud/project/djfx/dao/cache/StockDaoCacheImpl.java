package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.StockDao;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.query.StockQuery;

@Repository
public class StockDaoCacheImpl implements StockDao {
	
	@Autowired
	private StockDao stockDaoMysqlImpl;
	
	@Autowired
	private StockDao stockDaoRedisImpl;

	@Override
	public boolean add(Stock stock) {
		return stockDaoMysqlImpl.add(stock);
	}

	@Override
	public Stock get(Long id) {
		return stockDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return stockDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Stock stock){
		return stockDaoMysqlImpl.update(stock);
	}
	
	@Override
	public List<Stock> list(List<Long> idList) {
		return CacheLoader.list(stockDaoRedisImpl, stockDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Stock> map(Set<Long> idSet){
		return CacheLoader.map(stockDaoRedisImpl, stockDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Stock> page(int start, int count){
		return stockDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Stock> page(StockQuery query, int start, int count){
		return stockDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Stock> listAll(){
		return stockDaoMysqlImpl.listAll();
	}

	@Override
	public List<Stock> listByProductId(Long productId) {
		return stockDaoMysqlImpl.listByProductId(productId);
	}

	@Override
	public Stock getByRoleAndPro(Long roleId, Long productId) {
		return stockDaoMysqlImpl.getByRoleAndPro(roleId,productId);
	}
}

