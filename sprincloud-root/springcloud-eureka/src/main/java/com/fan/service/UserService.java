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
		TbUser user = userMapper.selectByPrimaryKey(userId);
		if(user==null) {
			user= new TbUser();
			user.setUsername("用户不存在！");
		}
		redisUtil.set(user.getUsername(), user.getUsername());
		//redisUtil.setRemove("userNmae", user.getUsername());
		return user;
	}
}
