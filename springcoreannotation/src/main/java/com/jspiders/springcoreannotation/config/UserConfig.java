package com.jspiders.springcoreannotation.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotation.entity.User;

public class UserConfig {

	@Bean(name = "user")
	private User getUser() {
		return new User();
	}
}
