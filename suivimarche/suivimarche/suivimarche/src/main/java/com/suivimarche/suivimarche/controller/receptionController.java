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

import com.suivimarche.suivimarche.Repo.ReceptionRepo;

import com.suivimarche.suivimarche.models.reception;

@RestController
@RequestMapping("api/reception")
public class receptionController {
 @Autowired
 private ReceptionRepo receptionRepo;
 
 @GetMapping("/")
	public ResponseEntity<List<reception>> reception() {
	List<reception>listereception=receptionRepo.findAll();
	return new ResponseEntity<>(listereception, HttpStatus.OK);
	}
	@PostMapping("/add") 
	public ResponseEntity<reception> ajouter(@RequestBody reception reception ) {
		try {
	
		 receptionRepo.save(reception);
		 
		 return new ResponseEntity<>(reception, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<reception> detail(@PathVariable("id") int id) {
	    
	    Optional<reception>rr=receptionRepo.findById(id);
	    if(rr.isPresent())
	      {
	    	reception r=rr.get();
	    return new ResponseEntity<>(r, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 receptionRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<reception> modifier(@PathVariable("id") int id,
	     @RequestBody reception reception) {
	 
	   if(receptionRepo.save(reception)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	

}
