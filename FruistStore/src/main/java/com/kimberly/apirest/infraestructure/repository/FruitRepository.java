package com.kimberly.apirest.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kimberly.apirest.infraestructure.model.Fruit;

import jakarta.transaction.Transactional;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long>{
	
	@Query(nativeQuery = true, value = "select * from \"fruitsStore\".fruits")
	List<Fruit> findAllFruits();
	
	
	@Query(nativeQuery = true, value = "select f.* from \"fruitsStore\".fruits  f where f.id = ?1;")
	Optional<Fruit> findById(Long id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from \"fruitsStore\".fruits where id=?1;")
	void deleteFruit(Long id);
	
}
