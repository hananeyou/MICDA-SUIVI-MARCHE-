package com.suivimarche.suivimarche.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivimarche.suivimarche.models.machine;



public interface MachineRepo extends JpaRepository<machine, Integer> {

}
