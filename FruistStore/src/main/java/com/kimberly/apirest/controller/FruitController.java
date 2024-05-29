package com.kimberly.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kimberly.apirest.model.FruitDto;
import com.kimberly.apirest.model.ResponseOfService;
import com.kimberly.apirest.service.IFruitService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotNull;

@Controller
@RequestMapping("/api/fruit")
public class FruitController {

	@Autowired
	private IFruitService fruitService;
	
	
	@PostMapping("/create/{type}/{quantity}/{price}")
	public @ResponseBody ResponseOfService create(@PathVariable String type,@PathVariable int quantity, 
			@PathVariable double price) throws Exception {		
		try {
						
			FruitDto fruit = new FruitDto();
			fruit.setType(type);
			fruit.setQuantity(quantity);
			fruit.setPrice(price);
			
			return fruitService.createFruit(fruit);
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}		
	}
	
	
	@GetMapping("/findAll")
	public @ResponseBody ResponseOfService findAll() throws Exception{
		try {
			return fruitService.findAllFruits();
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}
	}
	
	@PutMapping("/update/{id}")
	public @ResponseBody ResponseOfService update(@PathVariable Long id, @PathVariable String type,@PathVariable int quantity, 
			@PathVariable double price) throws Exception{
		try {
			
			FruitDto fruit = new FruitDto();
			fruit.setType(type);
			fruit.setQuantity(quantity);
			fruit.setPrice(price);
			
			return fruitService.updateFruit(id, fruit);
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}
	}
	
	
	@GetMapping("/findById/{id}")
	public @ResponseBody ResponseOfService findByUsername(@PathVariable Long id) throws Exception{
		try {
			return fruitService.findFruitById(id);
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseOfService delete(@PathVariable Long id) throws Exception{
		try {
			return fruitService.deleteFruit(id);
		} catch (Exception e) {
			return new ResponseOfService("500", "It is service present mistakes; " + e, null);
		}
	}
	
	
}
