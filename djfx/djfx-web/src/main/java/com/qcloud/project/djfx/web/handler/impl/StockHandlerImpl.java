package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.djfx.web.handler.StockHandler;
import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.model.key.TypeEnum;
import com.qcloud.project.djfx.service.ProductCategoryService;
import com.qcloud.project.djfx.service.ProductService;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.web.vo.StockVO;
import com.qcloud.project.djfx.web.vo.admin.AdminStockVO;

@Component
public class StockHandlerImpl implements StockHandler {

	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductCategoryService productCategoryService;

	@Override
	public List<StockVO> toVOList(List<Stock> list) {
		List<StockVO> voList = new ArrayList<StockVO>();
		for (Stock stock : list) {
			voList.add(toVO(stock));
		}
		return voList;
	}

	@Override
	public StockVO toVO(Stock stock) {
		String json = Json.toJson(stock);
		return Json.toObject(json, StockVO.class, true);

	}

	@Override
	public List<AdminStockVO> toVOList4Admin(List<Stock> list) {
		List<AdminStockVO> voList = new ArrayList<AdminStockVO>();
		for (Stock adminStock : list) {
			voList.add(toVO4Admin(adminStock));
		}
		return voList;
	}

	@Override
	public AdminStockVO toVO4Admin(Stock stock) {
		String json = Json.toJson(stock);
		AdminStockVO adminStockVO = Json.toObject(json, AdminStockVO.class, true);
		if (stock.getSState() == TypeEnum.StockType.HAVESTOCK.getKey()) {
			adminStockVO.setStateStr(TypeEnum.StockType.HAVESTOCK.getName());
		} else if (stock.getSState() == TypeEnum.StockType.NOSTOCK.getKey()) {
			adminStockVO.setStateStr(TypeEnum.StockType.NOSTOCK.getName());
		}
		
		adminStockVO.setProductFile(productService.get(stock.getProductId()).getThumbnail());
		adminStockVO.setCreateTimeStr(DateUtil.date2String(stock.getCreateTime(), "yyyy-MM-dd HH:mm"));
		adminStockVO.setRoleName(userService.get(stock.getRoleId()).getName());
		adminStockVO.setProductName(productService.get(stock.getProductId()).getProductName());
		long pcId = productService.get(stock.getProductId()).getProductCategoryId();
		adminStockVO.setProductCategoryName(productCategoryService.get(pcId).getTypeName());
		adminStockVO.setProductPrice(productService.get(stock.getProductId()).getPrice());
		adminStockVO.setProductSpecifications(productService.get(stock.getProductId()).getSpecifications());

		return adminStockVO;
	}
}
