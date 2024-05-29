package com.kimberly.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kimberly.apirest.model.DataOrderDto;
import com.kimberly.apirest.model.ResponseOfService;
import com.kimberly.apirest.service.IOrderService;
import com.kimberly.apirest.service.impl.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/order")
public class OrderControler {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/create")
	public @ResponseBody ResponseOfService create(@RequestBody DataOrderDto request) throws Exception {		
		try {
			return orderService.createOrder(request);
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}		
	}

}
