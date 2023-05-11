package com.jordan.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordan.safetravels.models.Travel;
import com.jordan.safetravels.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
	
	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
//Return all Travel expenses
	public List<Travel> allTravel(){
		return travelRepository.findAll();
	}

//	Create Travel expenses
	public Travel createTravel(Travel travel) {
		return travelRepository.save(travel);
	}
	
//	Retrieves expenses by id
	public Travel findOne(long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		} else {
			return null;
		}
	}
	
//	Update
	public Travel updateTravel(Travel travel) {
		return travelRepository.save(travel);
	}
//	Delete
	public void delete(Long id) {
		travelRepository.deleteById(id);;
	}
	
}
