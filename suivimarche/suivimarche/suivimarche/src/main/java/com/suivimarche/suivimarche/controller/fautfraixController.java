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

import com.suivimarche.suivimarche.Repo.FauxFraisRepo;
import com.suivimarche.suivimarche.models.decompte;
import com.suivimarche.suivimarche.models.fauxfrais;

@RestController
@RequestMapping("api/fauxfrais")
public class fautfraixController {

	@Autowired
	private FauxFraisRepo fauxfraisRepo;
	
	@GetMapping("/")
	public ResponseEntity<List<fauxfrais>> fauxfrais() {
	List<fauxfrais>listefauxfrais=fauxfraisRepo.findAll();
	return new ResponseEntity<>(listefauxfrais, HttpStatus.OK);
	}
	@PostMapping("/add") 
	public ResponseEntity<fauxfrais> ajouter(@RequestBody fauxfrais fauxfrais) {
		try {
	
			fauxfraisRepo.save(fauxfrais);
		 
		 return new ResponseEntity<>(fauxfrais, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<fauxfrais> detail(@PathVariable("id") int id) {
	    
	    Optional<fauxfrais>ff=fauxfraisRepo.findById(id);
	    if(ff.isPresent())
	      {
	    	fauxfrais f=ff.get();
	    return new ResponseEntity<>(f, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 fauxfraisRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<fauxfrais> modifier(@PathVariable("id") int id,
	     @RequestBody fauxfrais fauxfrais) {
	 
	   if(fauxfraisRepo.save(fauxfrais)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
}
