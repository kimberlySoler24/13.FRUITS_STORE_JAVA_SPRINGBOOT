package com.kimberly.apirest.model;


import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FruitDto implements Serializable {

	private static final long serialVersionUID = -7978190690104719328L;

	private String type;

	private int quantity;

	private Double price;

	
}
