package com.ergela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ergela.model.Breed;
import com.ergela.model.Horse;
import com.ergela.service.HorseService;

@RestController
public class HorseController {
	
	@Autowired
	private HorseService horseService;
	
	@GetMapping("/horses")
	public List<Horse> getAllHorses() {
		return horseService.getAllHorses();
	}
	
	@GetMapping("/breeds")
	public List<Breed> getAllBreeds() {
		return horseService.getAllBreeds();
	}
	
	@GetMapping("/horses/{idHorse}")
	public ResponseEntity<Horse> getHorse(@PathVariable Integer idHorse) {
		Horse foundHorse = horseService.findHorse(idHorse);
		if (foundHorse != null)
			return ResponseEntity.ok(foundHorse);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/breeds/{idBreed}")
	public ResponseEntity<Breed> getBreed(@PathVariable Integer idBreed) {
		Breed foundBreed = horseService.findBreed(idBreed);
		if (foundBreed != null)
			return ResponseEntity.ok(foundBreed);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/breeds/{idBreed}/add-horse")
	public ResponseEntity<Horse> createHorse(@RequestBody Horse horse, @PathVariable Integer idBreed) {
		Horse newHorse = horseService.saveHorse(horse, idBreed);
		return new ResponseEntity<Horse>(newHorse, HttpStatus.CREATED);
	}

}
