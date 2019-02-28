package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.model.query.ProductQuery;

public interface ProductMapper {

	@Insert("insert into `djfx_product`(`id`,`productName`,`thumbnail`,`detailMap`,`introduce`,`price`,`concessionalRate`,`specifications`,`sockId`,`createTime`,`productCategoryId`,`orderId`,`state`)"
			+ " values(#{id},#{productName},#{thumbnail},#{detailMap},#{introduce},#{price},#{concessionalRate},#{specifications},#{sockId},#{createTime},#{productCategoryId},#{orderId},#{state})")
	public void insert(Product product);

	@Select("select * from `djfx_product` where `id`=#{id}")
	public Product get(Long id);

	@Update("update `djfx_product` set `productName`=#{productName},`thumbnail`=#{thumbnail},`detailMap`=#{detailMap},`introduce`=#{introduce},`price`=#{price},`concessionalRate`=#{concessionalRate},`specifications`=#{specifications},`sockId`=#{sockId},`productCategoryId`=#{productCategoryId},`orderId`=#{orderId},`state`=#{state} where `id`=#{id}")
	public void update(Product product);

	@Update("update `djfx_product` set `state`= -1 where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_product` limit #{start},#{count}")
	public List<Product> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_product`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_product`")
	public List<Product> listAll();
}