package com.jspiders.springcoreannotation.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class PanCard {

	@Value("1")
	private int id;
	@Value("BSOPA7170E")
	private String pan;
	
}
