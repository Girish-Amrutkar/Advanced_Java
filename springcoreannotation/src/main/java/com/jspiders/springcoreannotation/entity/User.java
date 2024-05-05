package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class User {

	@Value("1")
	private int id;
	@Value("Girish")
	private String name;
	@Value("girishamrutkar6@gmail.com")
	private String email;
	@Value("Girish@1234")
	private String password;
}
