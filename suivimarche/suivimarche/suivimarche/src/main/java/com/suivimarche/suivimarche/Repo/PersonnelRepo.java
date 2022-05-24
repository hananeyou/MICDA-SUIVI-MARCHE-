package com.suivimarche.suivimarche.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivimarche.suivimarche.models.personnel;



public interface PersonnelRepo extends JpaRepository<personnel, Integer> {

}
