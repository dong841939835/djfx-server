package com.qcloud.project.djfx.web.handler.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.djfx.web.handler.ProductHandler;
import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.service.ProductCategoryService;
import com.qcloud.project.djfx.service.StockService;
import com.qcloud.project.djfx.web.vo.ProductVO;
import com.qcloud.project.djfx.web.vo.admin.AdminProductVO;

@Component
public class ProductHandlerImpl implements ProductHandler {

	@Autowired
	private ProductCategoryService productCategoryService;
	@Autowired
	private StockService stockService;

	@Override
	public List<ProductVO> toVOList(List<Product> list) {
		List<ProductVO> voList = new ArrayList<ProductVO>();
		for (Product product : list) {
			voList.add(toVO(product));
		}
		return voList;
	}

	@Override
	public ProductVO toVO(Product product) {
		String json = Json.toJson(product);
		return Json.toObject(json, ProductVO.class, true);

	}

	@Override
	public List<AdminProductVO> toVOList4Admin(List<Product> list) {
		List<AdminProductVO> voList = new ArrayList<AdminProductVO>();
		for (Product adminProduct : list) {
			voList.add(toVO4Admin(adminProduct));
		}
		return voList;
	}

	@Override
	public AdminProductVO toVO4Admin(Product product) {
		String json = Json.toJson(product);
		AdminProductVO adminProductVO = Json.toObject(json, AdminProductVO.class, true);
		String createTimeStr = DateUtil.date2String(product.getCreateTime(), "yyyy-MM-dd HH:mm");
		adminProductVO.setCreateTimeStr(createTimeStr);
		String productCategoryStr = productCategoryService.get(product.getProductCategoryId()).getTypeName();
		adminProductVO.setProductCategoryStr(productCategoryStr);
		adminProductVO.setSockLong(stockService.get(product.getSockId()).getTotalQuantity());
		return adminProductVO;
	}
}
