package com.qcloud.project.djfx.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.djfx.model.Order;
import com.qcloud.project.djfx.model.query.OrderQuery;

public interface OrderMapper {

	@Insert("insert into `djfx_order`(`id`,`oName`,`oNumber`,`oSum`,`oAddress`,`roleId`,`oPNumber`,`productId`,`createTime`,`completionTime`,`state`,`processingState`)"
			+ " values(#{id},#{oName},#{oNumber},#{oSum},#{oAddress},#{roleId},#{oPNumber},#{productId},#{createTime},#{completionTime},#{state},#{processingState})")
	public void insert(Order order);

	@Select("select * from `djfx_order` where `id`=#{id}")
	public Order get(Long id);

	@Update("update `djfx_order` set `oName`=#{oName},`oNumber`=#{oNumber},`oSum`=#{oSum},`oAddress`=#{oAddress},`roleId`=#{roleId},`oPNumber`=#{oPNumber},`productId`=#{productId},`completionTime`=#{completionTime},`state`=#{state},`processingState`=#{processingState} where `id`=#{id}")
	public void update(Order order);

	@Delete("delete from `djfx_order` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `djfx_order` limit #{start},#{count}")
	public List<Order> list4page(Map<String,Object> param);

	@Select("select count(*) from `djfx_order`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `djfx_order`")
	public List<Order> listAll();
	
	@Select("select * from `djfx_order` where `oNumber` = #{oNumber}")
	public List<Order> listByNumber(Long oNumber);
}