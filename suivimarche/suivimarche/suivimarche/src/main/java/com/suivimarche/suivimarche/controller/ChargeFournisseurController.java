package com.suivimarche.suivimarche.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivimarche.suivimarche.Repo.ChargeFournisseurRepo;

import com.suivimarche.suivimarche.models.chargefournisseur;
import com.suivimarche.suivimarche.models.marche;

@RestController
@RequestMapping("api/chargefournisseur")
public class ChargeFournisseurController {
	
	@Autowired
	private ChargeFournisseurRepo chargefournisseurRepo;

	@GetMapping("/")
	public ResponseEntity<List<chargefournisseur>> chargefournisseur() {
		List<chargefournisseur>listeChargeFournisseur=chargefournisseurRepo.findAll();
		return new ResponseEntity<>(listeChargeFournisseur, HttpStatus.OK);
		}
	
	@PostMapping("/add") 
	public ResponseEntity<chargefournisseur> ajouter(@RequestBody chargefournisseur ChargeFournisseur) {
		try {
	
		 chargefournisseurRepo.save(ChargeFournisseur);
		 
		 return new ResponseEntity<>(ChargeFournisseur, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	@GetMapping("/{id}")
	
	   public ResponseEntity<chargefournisseur> detail(@PathVariable("id") int id) {
	    
	    Optional<chargefournisseur>cf=chargefournisseurRepo.findById(id);
	    if(cf.isPresent())
	      {
	     chargefournisseur c=cf.get();
	    return new ResponseEntity<>(c, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 chargefournisseurRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<chargefournisseur> modifier(@PathVariable("id") int id,
	     @RequestBody chargefournisseur chargefournisseur) {
	 
	   if(chargefournisseurRepo.save(chargefournisseur)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
}
