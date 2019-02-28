package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.OrderProductService;
import com.qcloud.project.djfx.web.handler.OrderProductHandler;
		
@Controller
@RequestMapping(value = OrderProductController.DIR)
public class OrderProductController {
	
	public static final String DIR = "/orderProduct";
	
	@Autowired
	private OrderProductService orderProductService;
	@Autowired
	private OrderProductHandler orderProductHandler;

}
