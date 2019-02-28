package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.query.StockQuery;

public interface StockMapper {

	@Insert("insert into `djfx_stock`(`id`,`productId`,`roleId`,`createTime`,`totalQuantity`,`sState`)"
			+ " values(#{id},#{productId},#{roleId},#{createTime},#{totalQuantity},#{sState})")
	public void insert(Stock stock);

	@Select("select * from `djfx_stock` where `id`=#{id}")
	public Stock get(Long id);

	@Update("update `djfx_stock` set `productId`=#{productId},`roleId`=#{roleId},`totalQuantity`=#{totalQuantity},`sState`=#{sState} where `id`=#{id}")
	public void update(Stock stock);

	@Delete("delete from `djfx_stock` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_stock` limit #{start},#{count}")
	public List<Stock> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_stock`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_stock`")
	public List<Stock> listAll();
	
	@Select("select * from `djfx_stock` where `productId` = #{productId}")
	public List<Stock> listByProductId(Long productId);
}