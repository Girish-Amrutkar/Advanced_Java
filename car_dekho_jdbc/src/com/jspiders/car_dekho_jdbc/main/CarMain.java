package com.jspiders.car_dekho_jdbc.main;

import java.io.IOException;
import java.util.Scanner;

public class CarMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		System.out.println("\n\n--------------- Welcome to Car Dekho ---------------");
		while (flag) {
			System.out.println(
					"1. Add a New Car\n2. Update Car Details\n3. Search a Car\n4. Delete a car\n5. Show all Cars\n6. Exit");
			System.out.println("Enter the option number: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the number, how many cars you want to add.");
				int num = scanner.nextInt();
				int id = 0;
				String name = null;
				String brand = null;
				String fuel = null;
				int price = 0;
				for (int i = 1; i <= num; i++) {
					System.out.println("---------Enter car " + i + " record---------");
					System.out.println("Enter Car Id: ");
					id = scanner.nextInt();
					if (id < 1) {
						System.out.println("Please enter valid car Id");
						System.out.println("Retry adding car...");
					} else {
						scanner.nextLine();
						System.out.println("Enter Name of Car: ");
						name = scanner.nextLine();
						System.out.println("Enter Car Brand: ");
						brand = scanner.nextLine();
						System.out.println("Enter Fuel Type: ");
						fuel = scanner.nextLine();
						System.out.println("Enter Price: ");
						price = scanner.nextInt();
						Car.addCar(id, name, brand, fuel, price);
					}
				}
				System.out.println("Car(s) added Successfully\n\n");
				break;
			case 2:
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				System.out.println("Enter price: ");
				price = scanner.nextInt();
				Car.updateDetails(id, price);
				System.out.println("Selected car record has been updated\n\n");
				break;
			case 3:
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				Car.searchCar(id);
//				System.out.println("Searching...");
				break;
			case 4:
				System.out.println("Enter Id: ");
				id = scanner.nextInt();
				Car.deleteCar(id);
//				System.out.println("Selected car record has been deleted\n\n");
				break;
			case 5:
				Car.allCars();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
		scanner.close();
	}
}