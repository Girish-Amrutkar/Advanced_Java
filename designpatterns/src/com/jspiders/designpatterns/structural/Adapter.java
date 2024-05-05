package com.jspiders.designpatterns.structural;

public class Adapter extends Employee implements Event{

	@Override
	public void womensDay() {
		System.out.println("The chief guest of Women's Day is "+getName());
	}

	@Override
	public void mensDay() {
		System.out.println("The chief guest of Men's Day is "+getName());
	}
}
