package com.revature.watercanappuserms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.watercanappuserms.dto.OrderInfo;

@Service
public class ViewOrder {
	@Autowired
	private RestTemplate restTemplate;

	String apiUrl = "https://watercanapp-ordercan.herokuapp.com/";

	public List<OrderInfo> viewOrderCan() {
		ResponseEntity<OrderInfo[]> getForEntity = restTemplate.getForEntity(apiUrl + "/orderCan", OrderInfo[].class);
		System.out.println(getForEntity);
		OrderInfo[] stockList = getForEntity.getBody();
		List<OrderInfo> list = new ArrayList<OrderInfo>();
		for (OrderInfo orderInfo : stockList) {
			list.add(orderInfo);
		}
		return list;
	}
}
