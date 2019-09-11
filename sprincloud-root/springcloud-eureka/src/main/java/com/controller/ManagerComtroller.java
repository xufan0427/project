package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fan.pojo.TbUser;
import com.fan.service.UserService;

@CrossOrigin
@RestController	
@RequestMapping("/manager")
public class ManagerComtroller {   

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser")
	public String getUserInfo(@RequestParam(required=true) Long userId) {
		System.out.println("用户id---"+userId+"--------");
		TbUser TbUser = userService.getUser(userId);
		return TbUser.getUsername();
	}
}
