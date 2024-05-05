package com.jspiders.springcoreannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jspiders.springcoreannotation.config.PersonConfig;
import com.jspiders.springcoreannotation.entity.Person;

public class PersonMain {

	public static void main(String[] args) {
		
		//with the help of config class and passing the bean name to get bean.
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person = (Person) applicationContext.getBean("person");
		Person person2 = (Person) applicationContext.getBean("person");
		System.out.println(person);
		System.out.println(person2);
		((AnnotationConfigApplicationContext) applicationContext).close();
	}
}
