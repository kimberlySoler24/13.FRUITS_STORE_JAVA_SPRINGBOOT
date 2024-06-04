package kimberly.fruitstore.service;

import kimberly.fruitstore.model.DataOrderDto;
import kimberly.fruitstore.model.ResponseOfService;

public interface IOrderService {

	public ResponseOfService createOrder(DataOrderDto request) throws Exception;

}
