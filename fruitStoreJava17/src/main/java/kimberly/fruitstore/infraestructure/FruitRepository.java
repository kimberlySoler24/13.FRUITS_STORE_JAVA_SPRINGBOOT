package kimberly.fruitstore.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kimberly.fruitstore.infraestructure.model.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long>{

}
