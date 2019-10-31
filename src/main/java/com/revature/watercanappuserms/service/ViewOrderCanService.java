package com.revature.watercanappuserms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.watercanappuserms.dto.OrderInfo;

@Service
public class ViewOrderCanService {
	
@Autowired
	ViewOrder viewOrder;

public List<OrderInfo> findAllOrderCan() {
	 List<OrderInfo> stockList=viewOrder.viewOrderCan();
	 return stockList;
	
}


}
