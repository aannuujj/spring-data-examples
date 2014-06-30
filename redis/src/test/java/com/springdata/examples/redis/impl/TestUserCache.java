package com.springdata.examples.redis.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springdata.examples.redis.dto.UserDto;

@ContextConfiguration(locations={"classpath:spring-data-example-redis.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserCache {

	@Autowired UserCache userCache;

	@Test 
	public void shouldSetAndGetUser() {
		UserDto user = createUserDto();
		
		userCache.set("U.1", user);
		UserDto returnUser = userCache.get("U.1");

		assertNotNull("user is null", returnUser);
		assertEquals( "user wasn't found" , user, returnUser);
	}
	
	@Test 
	public void shouldDeleteUser() {
		UserDto user = createUserDto();
		
		userCache.set("U.1.d", user);
		UserDto returnUser = userCache.get("U.1.d");
		
		assertNotNull("user is null", returnUser);
		assertEquals( "user wasn't found" , user, returnUser);
		
		userCache.delete("U.1.d");
		
		returnUser = userCache.get("U.1.d");
		assertNull(returnUser);
	}
	
	protected UserDto createUserDto() {
		UserDto user = new UserDto();
		user.setName("testname");
		user.setDescription("testdescription");
		return user;
	}
}
