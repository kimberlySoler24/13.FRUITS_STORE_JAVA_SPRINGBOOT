package kimberly.fruitstore.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kimberly.fruitstore.infraestructure.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
