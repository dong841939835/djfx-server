package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.Init;
import com.qcloud.project.djfx.model.query.InitQuery;

public interface InitMapper {

	@Insert("insert into `djfx_init`(`id`,`name`)"
			+ " values(#{id},#{name})")
	public void insert(Init init);

	@Select("select * from `djfx_init` where `id`=#{id}")
	public Init get(Long id);

	@Update("update `djfx_init` set `name`=#{name} where `id`=#{id}")
	public void update(Init init);

	@Delete("delete from `djfx_init` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_init` limit #{start},#{count}")
	public List<Init> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_init`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_init`")
	public List<Init> listAll();
}