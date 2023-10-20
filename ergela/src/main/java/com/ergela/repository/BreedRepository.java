package com.ergela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ergela.model.Breed;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

}
