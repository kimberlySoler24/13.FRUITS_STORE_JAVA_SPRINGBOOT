package kimberly.fruitstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kimberly.fruitstore.model.FruitDto;
import kimberly.fruitstore.model.ResponseOfService;
import kimberly.fruitstore.service.IFruitService;

@RestController
@RequestMapping("api/fruit")
public class FruitController {
	
	@Autowired
	private IFruitService fruitService;
	
	@PostMapping("/create")
	public @ResponseBody ResponseOfService create(@RequestBody FruitDto request) throws Exception {
		try {
					
			return fruitService.createFruit(request);
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
	public @ResponseBody ResponseOfService update(@PathVariable Long id, @RequestBody FruitDto request) throws Exception{
		try {
					
			return fruitService.updateFruit(id, request);
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
