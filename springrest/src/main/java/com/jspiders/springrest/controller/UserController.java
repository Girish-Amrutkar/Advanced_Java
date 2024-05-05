package com.jspiders.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.User;
import com.jspiders.springrest.response.ResponseStructure;
import com.jspiders.springrest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user) {
		User addedUser = userService.addUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (addedUser != null) {
			responseStructure.setMessage("User Added Successfully!!!");
			responseStructure.setData(addedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("User already exist!!!");
			responseStructure.setData(addedUser);
			responseStructure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<User>> validateUser(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "password") String password) {
		User user = userService.validateUser(userName, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setMessage("Signed in Successfully!!!");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		} else {
			responseStructure.setMessage("Invalid Username and Password");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<User>> validateUserByEmail(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
		User user = userService.validateUserByEmail(email, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setMessage("Signed in Successfully!!!");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		} else {
			responseStructure.setMessage("Invalid Email and Password");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<User>> validateUserByMobile(@RequestParam(name = "mobile") long mobile,
			@RequestParam(name = "password") String password) {
		User user = userService.validateUserByMobile(mobile, password);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (user != null) {
			responseStructure.setMessage("Signed in Successfully!!!");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.FOUND);
		} else {
			responseStructure.setMessage("Invalid Mobile and Password");
			responseStructure.setData(user);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (updatedUser != null) {
			responseStructure.setMessage("User Details Updated!!!");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("User not found!!!");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/user")
	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {
		User deletedUser = userService.deleteUser(id);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (deletedUser != null) {
			responseStructure.setMessage("User Details Deleted!!!");
			responseStructure.setData(deletedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("User not Found!!!");
			responseStructure.setData(deletedUser);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/user")
	public ResponseEntity<ResponseStructure<User>> updateCarListForUser(@RequestParam(name = "userId") int userId,
			@RequestParam(name = "carId") int carId) {
		User updatedUser = userService.updateCarListForUser(userId, carId);
		ResponseStructure<User> responseStructure = new ResponseStructure<>();
		if (updatedUser != null) {
			responseStructure.setMessage("User Car List for the User is updated!!!");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setMessage("Invalid User ID or Car ID");
			responseStructure.setData(updatedUser);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
}
