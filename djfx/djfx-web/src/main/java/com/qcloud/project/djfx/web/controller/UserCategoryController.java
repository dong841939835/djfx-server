package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcloud.project.djfx.service.UserCategoryService;
import com.qcloud.project.djfx.web.handler.UserCategoryHandler;
		
@Controller
@RequestMapping(value = UserCategoryController.DIR)
public class UserCategoryController {
	
	public static final String DIR = "/userCategory";
	
	@Autowired
	private UserCategoryService userCategoryService;
	@Autowired
	private UserCategoryHandler userCategoryHandler;

}
