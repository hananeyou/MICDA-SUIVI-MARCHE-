package com.suivimarche.suivimarche.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivimarche.suivimarche.models.facture;

public interface FactureRepo extends JpaRepository<facture, Integer> {

}
