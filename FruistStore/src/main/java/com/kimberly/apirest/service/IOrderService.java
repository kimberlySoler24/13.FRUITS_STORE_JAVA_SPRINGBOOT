package com.kimberly.apirest.service;


import com.kimberly.apirest.model.DataOrderDto;
import com.kimberly.apirest.model.ResponseOfService;

public interface IOrderService {
	
	public ResponseOfService createOrder(DataOrderDto request) throws Exception;

}
