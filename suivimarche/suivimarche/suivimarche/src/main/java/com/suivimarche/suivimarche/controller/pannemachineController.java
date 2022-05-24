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

import com.suivimarche.suivimarche.Repo.PanneMachineRepo;
import com.suivimarche.suivimarche.models.machine;
import com.suivimarche.suivimarche.models.pannemachine;

@RestController
@RequestMapping("api/pannemachine")
public class pannemachineController {

	@Autowired
	private PanneMachineRepo pannemachineRepo;
	@GetMapping("/")
	public ResponseEntity<List<pannemachine>> pannemachine() {
	List<pannemachine>listepannemachine=pannemachineRepo.findAll();
	return new ResponseEntity<>(listepannemachine, HttpStatus.OK);
	}
	
	@PostMapping("/add") 
	public ResponseEntity<pannemachine> ajouter(@RequestBody pannemachine pannemachine) {
		try {
	
		 pannemachineRepo.save(pannemachine);
		 
		 return new ResponseEntity<>(pannemachine, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<pannemachine> detail(@PathVariable("id") int id) {
	    
	    Optional<pannemachine>pm=pannemachineRepo.findById(id);
	    if(pm.isPresent())
	      {
	    	pannemachine p=pm.get();
	    return new ResponseEntity<>(p, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 pannemachineRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<pannemachine> modifier(@PathVariable("id") int id,
	     @RequestBody pannemachine pannemachine) {
	 
	   if(pannemachineRepo.save(pannemachine)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	

} 
