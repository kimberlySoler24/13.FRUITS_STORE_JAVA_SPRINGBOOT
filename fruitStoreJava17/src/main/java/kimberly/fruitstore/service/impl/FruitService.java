package kimberly.fruitstore.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kimberly.fruitstore.infraestructure.FruitRepository;
import kimberly.fruitstore.infraestructure.model.Fruit;
import kimberly.fruitstore.model.FruitDto;
import kimberly.fruitstore.model.ResponseOfService;
import kimberly.fruitstore.service.IFruitService;

@Service
public class FruitService implements IFruitService{
	
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
		fruit.setPrice(request.getPrice());
		fruit.setCreated_date(new Date());
		fruit.setUpdated_date(new Date());

		fruit = fruitRepository.save(fruit);

		return new ResponseOfService("200", "successful", fruit);
	}
	
	@Override
	public ResponseOfService findAllFruits() throws Exception {
		List<Fruit> fruitList = fruitRepository.findAll();

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
		
		fruitRepository.deleteById(id);
		
		return new ResponseOfService("200", "Successful", fruitOpt);
	}

	@Override
	public ResponseOfService updateFruit(Long id, FruitDto request) throws Exception {

		Fruit fruitOpt = fruitRepository.findById(id).orElse(null);

		if (fruitOpt == null) {
			return new ResponseOfService("400", "It doesn't exist this fruit!", null);
		}

		
		if (request.getType() != null && !request.getType().isBlank() && !request.getType().equals("string")) {
			fruitOpt.setType(request.getType());
		}
		
		if (request.getQuantity() >= 0) {
			fruitOpt.setQuantity(request.getQuantity());
		}
		
		if(request.getPrice() >= 0) {
			fruitOpt.setPrice(request.getPrice());
		}

		fruitOpt.setUpdated_date(new Date());
	
		
		fruitOpt = fruitRepository.save(fruitOpt);
		
		return new ResponseOfService("0000", "Successful", fruitOpt);
	}

}
