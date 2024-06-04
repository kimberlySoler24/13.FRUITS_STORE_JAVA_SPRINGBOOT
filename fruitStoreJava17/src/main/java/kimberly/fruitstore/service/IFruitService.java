package kimberly.fruitstore.service;

import kimberly.fruitstore.model.FruitDto;
import kimberly.fruitstore.model.ResponseOfService;

public interface IFruitService {
	
	public ResponseOfService createFruit(FruitDto request) throws Exception;
	
	public ResponseOfService findAllFruits() throws Exception;
	
	public ResponseOfService findFruitById(Long id) throws Exception;
	
	public ResponseOfService updateFruit(Long id, FruitDto request) throws Exception;
	
	public ResponseOfService deleteFruit(Long id) throws Exception;

}
