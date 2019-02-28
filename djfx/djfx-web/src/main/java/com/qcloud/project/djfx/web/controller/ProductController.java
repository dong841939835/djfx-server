package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.ProductService;
import com.qcloud.project.djfx.web.handler.ProductHandler;
		
@Controller
@RequestMapping(value = ProductController.DIR)
public class ProductController {
	
	public static final String DIR = "/product";
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductHandler productHandler;

}
