package com.suivimarche.suivimarche.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.suivimarche.suivimarche.models.chargemachine;


public interface ChargeMachineRepo extends JpaRepository<chargemachine, Integer> {
	
	
}
