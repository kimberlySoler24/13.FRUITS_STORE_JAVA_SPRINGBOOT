package kimberly.fruitstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kimberly.fruitstore.model.DataOrderDto;
import kimberly.fruitstore.model.ResponseOfService;
import kimberly.fruitstore.service.IOrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;
	
	
	@PostMapping("/create")
	public @ResponseBody ResponseOfService create(@RequestBody DataOrderDto request) throws Exception {		
		try {
			return orderService.createOrder(request);
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}		
	}
}
