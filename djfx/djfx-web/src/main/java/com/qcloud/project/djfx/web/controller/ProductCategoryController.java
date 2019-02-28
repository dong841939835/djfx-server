package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.ProductCategoryService;
import com.qcloud.project.djfx.web.handler.ProductCategoryHandler;
		
@Controller
@RequestMapping(value = ProductCategoryController.DIR)
public class ProductCategoryController {
	
	public static final String DIR = "/productCategory";
	
	@Autowired
	private ProductCategoryService productCategoryService;
	@Autowired
	private ProductCategoryHandler productCategoryHandler;

}
