package com.ergela.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ergela.model.Horse;

public interface HorseRepository extends JpaRepository<Horse, Integer> {
	

}
