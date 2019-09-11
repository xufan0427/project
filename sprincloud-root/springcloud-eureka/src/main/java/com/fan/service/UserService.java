package com.fan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.mapper.TbUserMapper;
import com.fan.pojo.TbUser;
import com.fan.redis.RedisUtil;

@Service
public class UserService {

	@Autowired
	private TbUserMapper userMapper;
	
	@Autowired
	private RedisUtil redisUtil;
	
	public TbUser getUser(long userId) {
		Object username=redisUtil.get(userId+"id");
		TbUser user=null;
		if(username==null) {
			System.out.println("从数据库查............");
			user = userMapper.selectByPrimaryKey(userId);
			if(user==null) {
				user= new TbUser();
				user.setUsername("用户不存在！");
			}else {
				redisUtil.set(user.getId()+"id", user.getUsername());
			}
			
		}else {
			user= new TbUser();
			user.setUsername(username.toString());
		}
		
		
		return user;
	}
}
