package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.entity.User;

public class UserMain {

	public static void main(String[] args) {
		
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("user_config.xml");
//		User user = applicationContext.getBean(User.class);
//		System.out.println(user);
//		((ClassPathXmlApplicationContext) applicationContext).close();

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("user_config.xml");
		User user1 = (User) applicationContext.getBean("user1");
		System.out.println(user1);
		((ClassPathXmlApplicationContext) applicationContext).close();
		
		ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("user_config.xml");
		User user2 = (User) applicationContext2.getBean("user2");
		System.out.println(user2);
		((ClassPathXmlApplicationContext) applicationContext2).close();
		
		ApplicationContext applicationContext3 = new ClassPathXmlApplicationContext("user_config.xml");
		User user3 = (User) applicationContext3.getBean("user3");
		System.out.println(user3);
		((AbstractApplicationContext) applicationContext3).close();
	}
}
