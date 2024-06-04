package kimberly.fruitstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Fruits Store", version = "v0.0.3"))
@SpringBootApplication
public class FruitStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitStoreApplication.class, args);
	}

}
