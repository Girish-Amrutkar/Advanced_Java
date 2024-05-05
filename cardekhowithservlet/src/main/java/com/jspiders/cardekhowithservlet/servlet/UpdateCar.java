package com.jspiders.cardekhowithservlet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspiders.cardekhowithservlet.jdbc.CarJDBC;

@WebServlet("/delete_car")
public class UpdateCar extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int res = CarJDBC.updateCar(id, name);
		if (res == 1) {
			req.setAttribute("message", "Car Details Updated...");
		}else {
			req.setAttribute("message", "Car not available...");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("update_car.jsp");
		requestDispatcher.forward(req, resp);
	
	}
}
