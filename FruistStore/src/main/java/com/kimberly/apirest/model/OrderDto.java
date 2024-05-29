package com.kimberly.apirest.model;

import java.util.Objects;

public class OrderDto {
	
	private String type;
	private int quantity;
	
	
	public OrderDto() {
	}


	public OrderDto(String type, int quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public int hashCode() {
		return Objects.hash(quantity, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		return quantity == other.quantity && Objects.equals(type, other.type);
	}


	@Override
	public String toString() {
		return "OrderDto [type=" + type + ", quantity=" + quantity + "]";
	}
	

	

	
	
	

}
