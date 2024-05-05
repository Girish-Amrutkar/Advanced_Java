package com.jspiders.cardekhocasestudy.main;

import java.util.Scanner;

import com.jspiders.cardekhocasestudy.operation.CarOperation;

public class CarMain {
	
	private static CarOperation carOperation = new CarOperation();

	public static void main(String[] args) {
		
		boolean flag = true;
		
		while (flag) {
			System.out.println("Enter 1 to add car details.\nEnter 2 to search car by id.\nEnter 3 to fetch all cars.\nEnter 4 to delete a car.\nEnter 5 to update car price.\nEnter 6 to exit\nEnter your choice");
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1: 
				carOperation.addCar(scanner);
				break;
			
			case 2: 
				carOperation.searchCarById(scanner);
				break;
				
			case 3:
				carOperation.fetchAllCars();
				break;
			
			case 4:
				carOperation.deleteCar(scanner);
				break;
				
			case 5:
				carOperation.updateCar(scanner);
				break;
				
			case 6:
				flag = false;
				System.out.println("Thank You!!!");
				
			default:
				System.out.println("Invalid Selection");
				break;
			}	
		}
	}
}
