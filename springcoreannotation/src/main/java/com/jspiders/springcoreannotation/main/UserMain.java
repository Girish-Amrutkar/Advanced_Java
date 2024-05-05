package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jspiders.springcoreannotation.config.UserConfig;
import com.jspiders.springcoreannotation.config.UserConfig2;
import com.jspiders.springcoreannotation.entity.User;

public class UserMain {

	public static void main(String[] args) {
		
		//with the help of config class and passing the class name to get the Bean.
		ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(UserConfig.class);
		User user1 = applicationContext1.getBean(User.class);
		System.out.println(user1);
		((AnnotationConfigApplicationContext) applicationContext1).close();
		
		//with the help of config class and passing the bean name to get the bean.
		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(UserConfig.class);
		User user2 = (User) applicationContext2.getBean("user");
		System.out.println(user2);
		((AnnotationConfigApplicationContext) applicationContext2).close();
		
		//with the help of base package and passing the bean name to get the bean.
		ApplicationContext applicationContext3 = new AnnotationConfigApplicationContext("com.jspiders.springcoreannotation");
		User user = (User) applicationContext3.getBean("user");
		System.out.println(user);
		((AnnotationConfigApplicationContext) applicationContext3).close();
		
		//with the help of annotation ComponentScan which takes a attribute as base package, giving the config class and passing the bean name to get the bean.
		ApplicationContext applicationContext4 = new AnnotationConfigApplicationContext(UserConfig2.class);
		User user3 = (User) applicationContext4.getBean("user");
		System.out.println(user3);
		((AnnotationConfigApplicationContext) applicationContext4).close();
	}
}
