package com.kimberly.apirest.model;

import java.util.List;
import java.util.Objects;

public class DataOrderDto {
	
	private List<OrderDto> dataOrder;

	public DataOrderDto() {

	}

	public DataOrderDto(List<OrderDto> dataOrder) {
		this.dataOrder = dataOrder;
	}

	public List<OrderDto> getDataOrder() {
		return dataOrder;
	}

	public void setDataOrder(List<OrderDto> dataOrder) {
		this.dataOrder = dataOrder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataOrderDto other = (DataOrderDto) obj;
		return Objects.equals(dataOrder, other.dataOrder);
	}

	@Override
	public String toString() {
		return "DataOrderDto [dataOrder=" + dataOrder + "]";
	}
	
	
	

}
