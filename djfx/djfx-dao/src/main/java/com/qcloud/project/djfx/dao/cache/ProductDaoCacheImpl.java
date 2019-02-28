package com.qcloud.project.djfx.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.djfx.dao.ProductDao;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.query.ProductQuery;

@Repository
public class ProductDaoCacheImpl implements ProductDao {
	
	@Autowired
	private ProductDao productDaoMysqlImpl;
	
	@Autowired
	private ProductDao productDaoRedisImpl;

	@Override
	public boolean add(Product product) {
		return productDaoMysqlImpl.add(product);
	}

	@Override
	public Product get(Long id) {
		return productDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return productDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Product product){
		return productDaoMysqlImpl.update(product);
	}
	
	@Override
	public List<Product> list(List<Long> idList) {
		return CacheLoader.list(productDaoRedisImpl, productDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Product> map(Set<Long> idSet){
		return CacheLoader.map(productDaoRedisImpl, productDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Product> page(int start, int count){
		return productDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Product> page(ProductQuery query, int start, int count){
		return productDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Product> listAll(){
		return productDaoMysqlImpl.listAll();
	}
}

