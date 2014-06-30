package com.springdata.examples.redis.impl;

import org.springframework.stereotype.Component;

import com.springdata.examples.redis.dto.UserDto;

@Component
public class UserCache extends RedisCacheServiceImpl<String, UserDto> {
	
}
