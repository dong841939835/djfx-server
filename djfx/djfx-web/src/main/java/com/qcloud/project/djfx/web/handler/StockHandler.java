package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.Stock;
import com.qcloud.project.djfx.web.vo.StockVO;
import com.qcloud.project.djfx.web.vo.admin.AdminStockVO;

public interface StockHandler {

	List<StockVO> toVOList(List<Stock> list);

	StockVO toVO(Stock stock);

	List<AdminStockVO> toVOList4Admin(List<Stock> list);

	AdminStockVO toVO4Admin(Stock stock);
}
