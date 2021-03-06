package com.revature.watercanappuserms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.watercanappuserms.dto.Message;
import com.revature.watercanappuserms.dto.RegisterInfo;
import com.revature.watercanappuserms.dto.UserLoginInfo;
import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.model.User;
import com.revature.watercanappuserms.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("userLogin")
	// @ResponseStatus(code = HttpStatus.OK)
	@ApiOperation("UserLoginApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Login Success", response = Message.class),
			@ApiResponse(code = 400, message = "User Login Failure") })
	public ResponseEntity<?> login(@RequestBody UserLoginInfo userLoginInfo) {
		String errorMessage = null;
		User user = null;

		try {
			user = userService.loginProcess(userLoginInfo);

		} catch (ServiceException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			Message message=new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("register")
	@ApiOperation("RegsterApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Register Success", response = Message.class),
			@ApiResponse(code = 400, message = "Register Failure") })
	public ResponseEntity<?> register(@RequestBody RegisterInfo registerInfo) {
		String result = null;

		User user = null;
		try {
			user = userService.registerProcess(registerInfo);
		} catch (ServiceException e) {
			result = e.getMessage();
		}
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			Message errorMessage = new Message(result);
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	@GetMapping("viewUsers")
	@ApiOperation("viewUsersApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Failure") })
	public ResponseEntity<?> viewUsers() {
		String result = null;

		List<User> user = new ArrayList<User>();
		try {
			user = userService.listAllUsers();
		} catch (ServiceException e) {
			result = e.getMessage();
		}
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			Message errorMessage = new Message(result);
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
