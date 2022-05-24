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

import com.suivimarche.suivimarche.Repo.FournisseurRepo;
import com.suivimarche.suivimarche.models.decompte;
import com.suivimarche.suivimarche.models.fournisseur;

@RestController
@RequestMapping("api/fournisseur")
public class fournisseurController {

	@Autowired
	private FournisseurRepo fournisseurRepo;
	@GetMapping("/")
	public ResponseEntity<List<fournisseur>> fournisseur() {
	List<fournisseur>listefournisseur=fournisseurRepo.findAll();
	return new ResponseEntity<>(listefournisseur, HttpStatus.OK);
	}
	
	@PostMapping("/add") 
	public ResponseEntity<fournisseur> ajouter(@RequestBody fournisseur fournisseur) {
		try {
	
		 fournisseurRepo.save(fournisseur);
		 
		 return new ResponseEntity<>(fournisseur, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<fournisseur> detail(@PathVariable("id") int id) {
	    
	    Optional<fournisseur>ff=fournisseurRepo.findById(id);
	    if(ff.isPresent())
	      {
	    	fournisseur f=ff.get();
	    return new ResponseEntity<>(f, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 fournisseurRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<fournisseur> modifier(@PathVariable("id") int id,
	     @RequestBody fournisseur fournisseur) {
	 
	   if(fournisseurRepo.save(fournisseur)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
}
