package com.qcloud.project.djfx.web.handler;

import java.util.List;

import com.qcloud.project.djfx.model.Product;
import com.qcloud.project.djfx.web.vo.ProductVO;
import com.qcloud.project.djfx.web.vo.admin.AdminProductVO;

public interface ProductHandler {

	List<ProductVO> toVOList(List<Product> list);

	ProductVO toVO(Product product);

	List<AdminProductVO> toVOList4Admin(List<Product> list);

	AdminProductVO toVO4Admin(Product product);
}
