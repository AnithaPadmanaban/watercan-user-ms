package com.revature.watercanappuserms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.watercanappuserms.dto.AdminLoginInfo;
import com.revature.watercanappuserms.dto.Message;
import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.model.Admin;
import com.revature.watercanappuserms.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("adminLogin")
	@ApiOperation("AdminLoginApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Admin Login Success", response = Message.class),
			@ApiResponse(code = 400, message = "Admin Login Failure") })
	public ResponseEntity<?> adminLogin(AdminLoginInfo adminLoginInfo) {
		String errorMessage = null;
		Admin admin = null;
		try {
			admin = adminService.adminLoginProcess(adminLoginInfo);
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
		}

		if (admin != null) {
			return new ResponseEntity<>(admin, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}
}
