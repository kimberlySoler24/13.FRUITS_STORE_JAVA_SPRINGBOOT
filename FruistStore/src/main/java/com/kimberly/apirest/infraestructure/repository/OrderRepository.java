package com.kimberly.apirest.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kimberly.apirest.infraestructure.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
