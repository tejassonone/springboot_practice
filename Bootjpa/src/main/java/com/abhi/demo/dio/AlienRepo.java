package com.abhi.demo.dio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.abhi.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	List<Alien> findByTech(String tech);
}
