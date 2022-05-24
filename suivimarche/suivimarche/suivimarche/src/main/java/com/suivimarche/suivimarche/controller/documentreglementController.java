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

import com.suivimarche.suivimarche.Repo.DocumentReglementRepo;
import com.suivimarche.suivimarche.models.documentreglement;
import com.suivimarche.suivimarche.models.marche;

@RestController
@RequestMapping("api/reglement")
public class documentreglementController {

	
	@Autowired
	
	private DocumentReglementRepo documentreglementRepo;
	
	@PostMapping("/add")
	 
	public ResponseEntity<documentreglement> ajouter(@RequestBody documentreglement  documentreglement) {
	try {
	 
		documentreglementRepo.save(documentreglement);
	
	 return new ResponseEntity<>(documentreglement, HttpStatus.CREATED);
	 } catch (Exception e) {
	 
	 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	}
	

	@GetMapping("/")
	public ResponseEntity<List<documentreglement>> documentreglement() {
	List<documentreglement>listedocumenetreglement=documentreglementRepo.findAll();
	return new ResponseEntity<>(listedocumenetreglement, HttpStatus.OK);
	}
	 @GetMapping("/{id}")
		
	   public ResponseEntity<documentreglement> detail(@PathVariable("id") int id) {
	    
	    Optional<documentreglement>dr=documentreglementRepo.findById(id);
	    if(dr.isPresent())
	      {
	     documentreglement d=dr.get();
	    return new ResponseEntity<>(d, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 documentreglementRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<documentreglement> modifier(@PathVariable("id") int id,
	     @RequestBody documentreglement documentreglement) {
	 
	   if(documentreglementRepo.save(documentreglement)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
}
