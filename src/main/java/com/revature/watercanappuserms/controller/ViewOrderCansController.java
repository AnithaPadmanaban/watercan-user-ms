package com.revature.watercanappuserms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.watercanappuserms.dto.Message;
import com.revature.watercanappuserms.dto.OrderInfo;
import com.revature.watercanappuserms.exception.ServiceException;
import com.revature.watercanappuserms.service.ViewOrderCanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
public class ViewOrderCansController {
	@Autowired
	ViewOrderCanService viewOrderCanService;
	
	@GetMapping("viewOrderCan")
	@ApiOperation("ViewOrderCanApi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Message.class),
			@ApiResponse(code = 400, message = "Failure") })
	public ResponseEntity<?> viewStock() throws ServiceException {
		
		String message = null;
		String errorMessage = null;
		List<OrderInfo> list =null;
		list=viewOrderCanService.findAllOrderCan();
		message = "Success";
		if (message != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
}

}