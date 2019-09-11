package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fan.pojo.TbUser;
import com.fan.service.FileService;
import com.fan.service.UserService;

@CrossOrigin
@RestController	
@RequestMapping("/manager")
public class ManagerComtroller {   

	@Autowired
	private UserService userService;
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/getUser")
	public String getUserInfo(@RequestParam(required=true) Long userId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
		System.out.println("用户id---"+userId+"--------");
		//TbUser TbUser = userService.getUser(userId);
		fileService.miaosha();
		System.out.println("当前时间getUserInfo---"+sdf.format(new Date())+"--------");
		//return TbUser.getUsername();
		return "用户不存在";
	}
}
