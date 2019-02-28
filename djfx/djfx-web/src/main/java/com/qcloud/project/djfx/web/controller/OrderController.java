package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.OrderService;
import com.qcloud.project.djfx.web.handler.OrderHandler;
		
@Controller
@RequestMapping(value = OrderController.DIR)
public class OrderController {
	
	public static final String DIR = "/order";
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderHandler orderHandler;

}
