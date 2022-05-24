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

import com.suivimarche.suivimarche.Repo.ChargeMachineRepo;
import com.suivimarche.suivimarche.models.chargemachine;


@RestController
@RequestMapping("api/chargemachine")
public class ChargeMachineController {
@Autowired

	private ChargeMachineRepo chargemachineRepo;
	
	@PostMapping("/add")
	
	public ResponseEntity<chargemachine> ajouter(@RequestBody chargemachine chargemachine) {
		try {
	
		 chargemachineRepo.save(chargemachine);
		 
		 return new ResponseEntity<>(chargemachine, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	@GetMapping("/")
	public ResponseEntity<List<chargemachine>> chargemachine() {
	List<chargemachine>listeChargeMachine=chargemachineRepo.findAll();
	return new ResponseEntity<>(listeChargeMachine, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	
	   public ResponseEntity<chargemachine> detail(@PathVariable("id") int id) {
	    
	    Optional<chargemachine>cm=chargemachineRepo.findById(id);
	    if(cm.isPresent())
	      {
	     chargemachine c=cm.get();
	    return new ResponseEntity<>(c, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		chargemachineRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<chargemachine> modifier(@PathVariable("id") int id,
	     @RequestBody chargemachine chargemachine) {
	 
	   if(chargemachineRepo.save(chargemachine)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
}
