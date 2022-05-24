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

import com.suivimarche.suivimarche.Repo.MachineRepo;
import com.suivimarche.suivimarche.models.decompte;
import com.suivimarche.suivimarche.models.machine;

@RestController
@RequestMapping("api/machine")
public class machineController {

	@Autowired
	private MachineRepo machineRepo;

	@GetMapping("/")
	public ResponseEntity<List<machine>> machine() {
	List<machine>listemachine=machineRepo.findAll();
	return new ResponseEntity<>(listemachine, HttpStatus.OK);
	}
	@PostMapping("/add") 
	public ResponseEntity<machine> ajouter(@RequestBody machine machine) {
		try {
	
		 machineRepo.save(machine);
		 
		 return new ResponseEntity<>(machine, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<machine> detail(@PathVariable("id") int id) {
	    
	    Optional<machine>mm=machineRepo.findById(id);
	    if(mm.isPresent())
	      {
	    	machine m=mm.get();
	    return new ResponseEntity<>(m, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 machineRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<machine> modifier(@PathVariable("id") int id,
	     @RequestBody machine machine) {
	 
	   if(machineRepo.save(machine)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	

}
