package com.jspiders.cardekhowithservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhowithservlet.jdbc.CarJDBC;

@WebServlet("/add_car")
public class AddCar extends HttpServlet{
		
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String brand = req.getParameter("brand");
		String fuel_type = req.getParameter("fuel_type");
		double price = Double.parseDouble(req.getParameter("price"));
		
		int res = CarJDBC.addCar(id, name, brand, fuel_type, price);
		if (res == 1) {
			req.setAttribute("message", "Car Added");
		}else {
			req.setAttribute("message", "Car not Added");
		}
		req.setAttribute("message", "Car added Successfully");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("add_car.jsp");
		requestDispatcher.forward(req, resp);
	}

}
	
