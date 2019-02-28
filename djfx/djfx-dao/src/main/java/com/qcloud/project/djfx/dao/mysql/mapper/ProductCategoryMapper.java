package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.ProductCategory;
import com.qcloud.project.djfx.model.query.ProductCategoryQuery;

public interface ProductCategoryMapper {

	@Insert("insert into `djfx_productCategory`(`id`,`type`,`thumbnail`,`typeName`)"
			+ " values(#{id},#{type},#{thumbnail},#{typeName})")
	public void insert(ProductCategory productCategory);

	@Select("select * from `djfx_productCategory` where `id`=#{id}")
	public ProductCategory get(Long id);

	@Update("update `djfx_productCategory` set `type`=#{type},`thumbnail`=#{thumbnail},`typeName`=#{typeName} where `id`=#{id}")
	public void update(ProductCategory productCategory);

	@Delete("delete from `djfx_productCategory` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_productCategory` limit #{start},#{count}")
	public List<ProductCategory> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_productCategory`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_productCategory`")
	public List<ProductCategory> listAll();
}