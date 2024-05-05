package com.jspiders.designpatterns.main;

import java.util.Scanner;

import com.jspiders.designpatterns.creational.Beverages;
import com.jspiders.designpatterns.creational.GingerTea;
import com.jspiders.designpatterns.creational.GreenTea;
import com.jspiders.designpatterns.creational.LemonTea;
import com.jspiders.designpatterns.creational.MasalaTea;

public class FactoryMain {

	public static void main(String[] args) {
		
		try {
			factory().order();
		} catch (NullPointerException e) {
			System.out.println("No Tea Ordered...");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static Beverages factory() {
		Beverages beverages = null;
		System.out.println("Enter 1 to order Masala Tea\nEnter 2 to order Green Tea\nEnter 3 to order Lemon Tea\nEnter 4 to order Ginger Tea");
		System.out.println("Enter Your Choice!!!");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			beverages = new MasalaTea();
			break;
		case 2:
			beverages = new GreenTea();
			break;
		case 3:
			beverages = new LemonTea();
			break;
		case 4:
			beverages = new GingerTea();
			break;
		default:
			System.out.println("Invalid Choice!!!");
			break;
		}
		return beverages;
	}
}
