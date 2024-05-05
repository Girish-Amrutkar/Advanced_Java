package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Aadhar {

	@Value("1")
	private int id;
	@Value("941728897311")
	private long aadharNumber;
}
