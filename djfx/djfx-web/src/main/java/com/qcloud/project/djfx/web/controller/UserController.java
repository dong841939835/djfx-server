package com.qcloud.project.djfx.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.project.djfx.service.UserService;
import com.qcloud.project.djfx.web.handler.UserHandler;

@Controller
@RequestMapping(value = UserController.DIR)
public class UserController {

	public static final String DIR = "/user";

	@Autowired
	private UserService userService;
	@Autowired
	private UserHandler userHandler;

}
