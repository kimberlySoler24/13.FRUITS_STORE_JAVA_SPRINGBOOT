package com.kimberly.apirest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimberly.apirest.infraestructure.model.Fruit;
import com.kimberly.apirest.infraestructure.repository.FruitRepository;
import com.kimberly.apirest.model.FruitDto;
import com.kimberly.apirest.model.ResponseOfService;
import com.kimberly.apirest.service.IFruitService;

@Service
public class FruitService implements IFruitService {

	@Autowired
	private FruitRepository fruitRepository;

	@Override
	public ResponseOfService createFruit(FruitDto request) throws Exception {

		if (request.getType() == null || request.getType().isBlank() || request.getPrice() == null
				|| request.getPrice() == null) {
			return new ResponseOfService("200", "Error, values empty!!", null);
		}

		Fruit fruit = new Fruit();

		fruit.setType(request.getType());
		fruit.setQuantity(request.getQuantity());
		fruit.setCreated_date(new Date());
		fruit.setUpdated_date(new Date());

		fruit = fruitRepository.save(fruit);

		return new ResponseOfService("200", "successful", fruit);
	}

	@Override
	public ResponseOfService findAllFruits() throws Exception {
		List<Fruit> fruitList = fruitRepository.findAllFruits();

		if (fruitList == null) {
			return new ResponseOfService("400", "table Empty!!", null);
		}

		return new ResponseOfService("200", "Successful", fruitList);
	}

	@Override
	public ResponseOfService findFruitById(Long id) throws Exception {

		Optional<Fruit> fruitOpt = fruitRepository.findById(id);

		if (!fruitOpt.isPresent()) {
			return new ResponseOfService("400", "It doesn't exist this fruit!", null);
		}

		Fruit fruit = fruitOpt.get();

		return new ResponseOfService("200", "successful!!", fruit);
	}

	@Override
	public ResponseOfService deleteFruit(Long id) throws Exception {
		
		Optional<Fruit> fruitOpt = fruitRepository.findById(id);
		
		if (!fruitOpt.isPresent()) {
			return new ResponseOfService("400", "It doesn't exist this fruit!", null);
		}
		
		fruitRepository.deleteFruit(id);
		
		return new ResponseOfService("200", "Successful", fruitOpt);
	}

	@Override
	public ResponseOfService updateFruit(Long id, FruitDto request) throws Exception {

		Optional<Fruit> fruitOpt = fruitRepository.findById(id);

		if (!fruitOpt.isPresent()) {
			return new ResponseOfService("400", "It doesn't exist this fruit!", null);
		}

		Fruit fruit = new Fruit();
		
		if (request.getType() != null && !request.getType().isBlank() && !request.getType().equals("string")) {
			fruit.setType(request.getType());
		}
		
		if (request.getQuantity() >= 0) {
			fruit.setQuantity(request.getQuantity());
		}
		
		if(request.getPrice() >= 0) {
			fruit.setPrice(request.getPrice());
		}

		fruit.setUpdated_date(new Date());
		
		return new ResponseOfService("0000", "Successful", fruit);
	}

}
