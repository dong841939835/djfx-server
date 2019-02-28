package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.InitService;
import com.qcloud.project.djfx.web.handler.InitHandler;
		
@Controller
@RequestMapping(value = InitController.DIR)
public class InitController {
	
	public static final String DIR = "/init";
	
	@Autowired
	private InitService initService;
	@Autowired
	private InitHandler initHandler;

}
