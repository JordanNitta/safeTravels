package com.jordan.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordan.safetravels.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{
	 // this method retrieves all the Travel Expenses from the database
    List<Travel>findAll();
    
}
