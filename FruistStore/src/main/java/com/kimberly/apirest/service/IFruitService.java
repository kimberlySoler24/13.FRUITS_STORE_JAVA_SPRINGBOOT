package com.kimberly.apirest.service;

import com.kimberly.apirest.infraestructure.model.Fruit;
import com.kimberly.apirest.model.FruitDto;
import com.kimberly.apirest.model.ResponseOfService;

public interface IFruitService {

	public ResponseOfService createFruit(FruitDto request) throws Exception;
	
	public ResponseOfService findAllFruits() throws Exception;
	
	public ResponseOfService findFruitById(Long id) throws Exception;
	
	public ResponseOfService updateFruit(Long id, FruitDto request) throws Exception;
	
	public ResponseOfService deleteFruit(Long id) throws Exception;
	
}
