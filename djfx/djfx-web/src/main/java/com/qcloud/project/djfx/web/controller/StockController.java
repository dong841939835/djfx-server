package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.StockService;
import com.qcloud.project.djfx.web.handler.StockHandler;
		
@Controller
@RequestMapping(value = StockController.DIR)
public class StockController {
	
	public static final String DIR = "/stock";
	
	@Autowired
	private StockService stockService;
	@Autowired
	private StockHandler stockHandler;

}
