package com.ergela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ergela.model.Breed;
import com.ergela.model.Horse;
import com.ergela.repository.BreedRepository;
import com.ergela.repository.HorseRepository;

@Service
public class HorseService {
	
	@Autowired
	private HorseRepository horseRepo;
	
	@Autowired
	private BreedRepository breedRepo;
	
	public List<Horse> getAllHorses() {
		return horseRepo.findAll();
	}
	
	public List<Breed> getAllBreeds() {
		return breedRepo.findAll();
	}
	
	public Horse findHorse(Integer id) {
		return horseRepo.findById(id).orElse(null);
	}

	public Breed findBreed(Integer id) {
		return breedRepo.findById(id).orElse(null);
	}
	
	public Horse saveHorse(Horse horse, int breedId) {
		horse.setBreed(breedRepo.findById(breedId).get());
		return horseRepo.save(horse);
	}
}
