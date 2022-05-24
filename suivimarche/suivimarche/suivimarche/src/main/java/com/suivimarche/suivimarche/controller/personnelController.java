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

import com.suivimarche.suivimarche.Repo.PersonnelRepo;

import com.suivimarche.suivimarche.models.personnel;

@RestController
@RequestMapping("api/personnel")
public class personnelController {

	@Autowired
	private PersonnelRepo personnelRepo;
	@GetMapping("/")
	public ResponseEntity<List<personnel>> personnel() {
	List<personnel>listepersonnel=personnelRepo.findAll();
	return new ResponseEntity<>(listepersonnel, HttpStatus.OK);
	}
	
	@PostMapping("/add") 
	public ResponseEntity<personnel> ajouter(@RequestBody personnel personnel) {
		try {
	
		 personnelRepo.save(personnel);
		 
		 return new ResponseEntity<>(personnel, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<personnel> detail(@PathVariable("id") int id) {
	    
	    Optional<personnel>pp=personnelRepo.findById(id);
	    if(pp.isPresent())
	      {
	    	personnel p=pp.get();
	    return new ResponseEntity<>(p, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 personnelRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<personnel> modifier(@PathVariable("id") int id,
	     @RequestBody personnel personnel) {
	 
	   if(personnelRepo.save(personnel)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	

}
