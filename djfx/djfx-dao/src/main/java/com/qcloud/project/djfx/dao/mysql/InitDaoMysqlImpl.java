package com.qcloud.project.djfx.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.djfx.dao.InitDao;
import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.model.query.InitQuery;
		
@Repository
public class InitDaoMysqlImpl implements InitDao {

	@Resource(name = "sqlOperator-djfx")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Init init) {
		return sqlOperator.insert("com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.insert", init) == 1;
	}	
	
	@Override
	public Init get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Init init){
		return sqlOperator.update("com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.update", init) > 0;
	}
	
	@Override
	public List<Init> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Init> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Init> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Init> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.count4page",
				param);
		Page<Init> page = new Page<Init>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Init> page(InitQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Init> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.count4query",
				param);
		Page<Init> page = new Page<Init>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Init> listAll(){	
		List<Init> list = sqlOperator.selectList(
				"com.qcloud.project.djfx.dao.mysql.mapper.InitMapper.listAll");
		return list;
	}
}

