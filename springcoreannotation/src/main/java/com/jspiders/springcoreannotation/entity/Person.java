package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope(value = "prototype")
public class Person {

	@Value("1")
	private int id;
	@Value("Girish")
	private String name;
	@Value("girishamrutkar6@gmail.com")
	private String email;
	//@Autowired: it is used to make automatic connection between two classes beans.
	@Autowired
	private Aadhar aadhar;
	@Autowired
	private PanCard panCard;
	
	//By using constructor we are passing values for the particular fields we have initiated.
//	public Person(@Value("1") int id,@Value("Girish") String name,@Value("girishamrutkar6@gmail.com") String email,@Autowired PanCard panCard) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.panCard = panCard;
//	}
//	
//	public Aadhar getAadhar() {
//		return aadhar;
//	}
//	
//	public void setAadhar(@Autowired Aadhar aadhar) {
//		this.aadhar = aadhar;
//	}
//
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", name=" + name + ", email=" + email + ", aadhar=" + aadhar + ", panCard="
//				+ panCard + "]";
//	}
//	
	
}
