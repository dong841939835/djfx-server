package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.OrderProduct;
import com.qcloud.project.djfx.model.query.OrderProductQuery;

public interface OrderProductMapper {

	@Insert("insert into `djfx_order_product`(`id`,`productId`,`orderId`)"
			+ " values(#{id},#{productId},#{orderId})")
	public void insert(OrderProduct orderProduct);

	@Select("select * from `djfx_order_product` where `id`=#{id}")
	public OrderProduct get(Long id);

	@Update("update `djfx_order_product` set `productId`=#{productId},`orderId`=#{orderId} where `id`=#{id}")
	public void update(OrderProduct orderProduct);

	@Delete("delete from `djfx_order_product` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_order_product` limit #{start},#{count}")
	public List<OrderProduct> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_order_product`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_order_product`")
	public List<OrderProduct> listAll();
}