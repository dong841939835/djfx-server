package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.UserCategory;
import com.qcloud.project.djfx.model.query.UserCategoryQuery;

public interface UserCategoryMapper {

	@Insert("insert into `djfx_userCategory`(`id`,`type`,`typeName`)"
			+ " values(#{id},#{type},#{typeName})")
	public void insert(UserCategory userCategory);

	@Select("select * from `djfx_userCategory` where `id`=#{id}")
	public UserCategory get(Long id);

	@Update("update `djfx_userCategory` set `type`=#{type},`typeName`=#{typeName} where `id`=#{id}")
	public void update(UserCategory userCategory);

	@Delete("delete from `djfx_userCategory` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_userCategory` limit #{start},#{count}")
	public List<UserCategory> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_userCategory`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_userCategory`")
	public List<UserCategory> listAll();
}