package com.kimberly.apirest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kimberly.apirest.infraestructure.model.Fruit;
import com.kimberly.apirest.infraestructure.model.Order;
import com.kimberly.apirest.infraestructure.repository.FruitRepository;
import com.kimberly.apirest.infraestructure.repository.OrderRepository;
import com.kimberly.apirest.model.DataOrderDto;
import com.kimberly.apirest.model.ResponseOfService;
import com.kimberly.apirest.service.IOrderService;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private FruitRepository fruitRepository;

	@Override
	public ResponseOfService createOrder(DataOrderDto request) throws Exception {
		
		List<Fruit> fruitList = fruitRepository.findAllFruits();

		if (fruitList == null) {
			return new ResponseOfService("400", "table Fruit Empty!!", null);
		}
		
        double totalValue = 0;
        int totalOrderFruits = 0;
        int sizeListOrder = request.getDataOrder().size();
        
        
        for (int i= 0; i < sizeListOrder; i++) {
            int countInt = 0;
            
            String fruitOrder = request.getDataOrder().get(i).getType();
            int quantityOrder = request.getDataOrder().get(i).getQuantity();
            for (Fruit fruit : fruitList) {
            	String fruitItem = fruit.getType();
                int quantityFruit = fruit.getQuantity();
                double priceFruit = fruit.getPrice();
                double semiTotal = 0;
                

                if (fruitOrder.equals(fruitItem))
                {
                    countInt++;
                }

                if (fruitOrder.equals(fruitItem) && quantityOrder <= quantityFruit)
                {
                    totalOrderFruits = quantityOrder + totalOrderFruits;
                    if (quantityOrder >= 10)
                    {
                        double percentage = 10 * 0.05;
                        semiTotal = (priceFruit*10) - priceFruit * percentage;
                    }
                    else
                    {
                        semiTotal = priceFruit * quantityOrder;
                    }

                    totalValue = semiTotal + totalValue;

                }
                else if (fruitOrder.equals(fruitItem) && quantityOrder > quantityFruit)
                {
                    return new ResponseOfService("ER01","Your quantity: " + quantityOrder +
                        "request fruit is exceed the quantity we have: " + quantityFruit + ":( !!",
                        null);
                }
			}
            
            if (countInt == 0)
            {
                throw new Exception("We don`t have: " + fruitOrder); 
            }
		}
        
        if (sizeListOrder >= 5)
        {
            totalValue = totalValue - (totalValue * 0.1);
        }

        String listOrder = request.toString();
        
        Order order = new Order();
        
        order.setFruit_list(listOrder);
        order.setTotal_value(totalValue);
        order.setCreated_date(new Date());
        order.setUpdated_date(new Date());
        
        order = orderRepository.save(order);
        
		return new ResponseOfService("200", "succesful!!", order);
	}
	
	
	

}
