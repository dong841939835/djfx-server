package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.User;
import com.qcloud.project.djfx.model.query.UserQuery;

public interface UserMapper {

	@Insert("insert into `djfx_user`(`id`,`name`,`userName`,`password`,`email`,`phone`,`contactAddress`,`qq`,`headPictureAddress`,`createTime`,`idCard`,`authorizationCode`,`superiorId`,`stockId`,`roleCategoryId`,`state`)"
			+ " values(#{id},#{name},#{userName},#{password},#{email},#{phone},#{contactAddress},#{qq},#{headPictureAddress},#{createTime},#{idCard},#{authorizationCode},#{superiorId},#{stockId},#{roleCategoryId},#{state})")
	public void insert(User user);

	@Select("select * from `djfx_user` where `id`=#{id}")
	public User get(Long id);

	@Update("update `djfx_user` set `name`=#{name},`userName`=#{userName},`password`=#{password},`email`=#{email},`phone`=#{phone},`contactAddress`=#{contactAddress},`qq`=#{qq},`headPictureAddress`=#{headPictureAddress},`idCard`=#{idCard},`authorizationCode`=#{authorizationCode},`superiorId`=#{superiorId},`stockId`=#{stockId},`roleCategoryId`=#{roleCategoryId},`state`=#{state} where `id`=#{id}")
	public void update(User user);

	@Update("update `djfx_user` set `state`= -1 where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_user` limit #{start},#{count}")
	public List<User> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_user`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_user` where `state` != -1")
	public List<User> listAll();
}