package com.jspiders.cardekhocasestudy.operation;

import java.util.ArrayList;
import java.util.Scanner;

import com.jspiders.cardekhocasestudy.entity.Car;

public class CarOperation {

	ArrayList<Car> cars = new ArrayList<>();

	public void addCar(Scanner scanner) {

		Car car = new Car();
		System.out.println("Enter car id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter car name");
		String name = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter car price");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Enter car color");
		String color = scanner.nextLine();
		scanner.nextLine();
		System.out.println("Enter car brand");
		String brand = scanner.nextLine();
		scanner.nextLine();

		car.setId(id);
		car.setName(name);
		car.setPrice(price);
		car.setColor(color);
		car.setBrand(brand);
		cars.add(car);
		System.out.println("Car added Successfully!!!");
	}

	public void searchCarById(Scanner scanner) {
		boolean flag = false;
		System.out.println("Ener car id");
		int id = scanner.nextInt();
		for (Car car : cars) {
			if (car.getId() == id) {
				flag = true;
				System.out.println(car);
				break;
			}
		}
		if (!flag) {
			System.out.println("Car not found...");
		}
	}

	public void fetchAllCars() {
		if (cars.size() > 0) {
			for (Car car : cars) {
				System.out.println(car);
			}
		} else {
			System.out.println("Cars not found");
		}
	}

	public void deleteCar(Scanner scanner) {
		boolean flag = false;
		System.out.println("Enter car id");
		int id = scanner.nextInt();
		for (Car car : cars) {
			if (car.getId() == id) {
				flag = true;
				cars.remove(car);
				System.out.println("Car deleted...");
				break;
			}
		}
		if (!flag) {
			System.out.println("Car not found");
		}
	}

	public void updateCar(Scanner scanner) {
		boolean flag = false;
		System.out.println("Enter car id");
		int id = scanner.nextInt();
		for (Car car : cars) {
			if (car.getId() == id) {
				flag = true;
				System.out.println("Enter new price");
				double price = scanner.nextDouble();
				car.setPrice(price);
				System.out.println("Car price updated");
			}
		}
		if (!flag) {
			System.out.println("Car not found");
		}
	}

}
