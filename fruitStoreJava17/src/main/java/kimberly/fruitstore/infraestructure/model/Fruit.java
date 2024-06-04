package kimberly.fruitstore.infraestructure.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fruits")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fruit_id_seq")
	@SequenceGenerator(name = "fruit_id_seq", sequenceName = "fruit_id_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	private String type;
	
	private int quantity;
	
	private Double price;
	
	private Date created_date;
	
	private Date updated_date;
	
	
}
