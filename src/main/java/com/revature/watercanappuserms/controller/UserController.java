package com.revature.watercanappuserms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<?> login(UserLoginInfo userLoginInfo) {
		String errorMessage = null;
		User user = new User();
		
		try {
			user = userService.loginProcess(userLoginInfo);
			
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	

	@PostMapping("register")
	@ApiOperation("RegsterApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Register Success", response = Message.class),
			@ApiResponse(code = 400, message = "Register Failure") })
	public ResponseEntity<?> register(RegisterInfo registerInfo ) {
		String result = null;
		String message = null;
		try {
		
			userService.registerProcess(registerInfo);
			message = "Success";
		} catch (ServiceException e) {
			result = e.getMessage();
		}
		if (message != null) {
			return new ResponseEntity<>(message, HttpStatus.OK);
		} else {
			Message errorMessage = new Message(result);
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
}
