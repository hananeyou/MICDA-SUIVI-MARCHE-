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

import com.suivimarche.suivimarche.Repo.FactureRepo;

import com.suivimarche.suivimarche.models.facture;


@RestController
@RequestMapping("api/facture")
public class factureController {

	@Autowired
	private FactureRepo factureRepo;
	@GetMapping("/")
	public ResponseEntity<List<facture>> facture() {
	List<facture>listefacture=factureRepo.findAll();
	return new ResponseEntity<>(listefacture, HttpStatus.OK);
	}
	
	@PostMapping("/add") 
	public ResponseEntity<facture> ajouter(@RequestBody facture facture) {
		try {
	
		 factureRepo.save(facture);
		 
		 return new ResponseEntity<>(facture, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<facture> detail(@PathVariable("id") int id) {
	    
	    Optional<facture>ff=factureRepo.findById(id);
	    if(ff.isPresent())
	      {
	    	facture f=ff.get();
	    return new ResponseEntity<>(f, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 factureRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<facture> modifier(@PathVariable("id") int id,
	     @RequestBody facture facture) {
	 
	   if(factureRepo.save(facture)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
	
}
