package kimberly.fruitstore.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FruitDto implements Serializable {

	private static final long serialVersionUID = 8312532575658378456L;

	private String type;

	private int quantity;

	private Double price;

	
}
