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

import com.suivimarche.suivimarche.Repo.CautionGrantieRepo;
import com.suivimarche.suivimarche.models.cautiongarantie;
import com.suivimarche.suivimarche.models.marche;


@RestController
@RequestMapping("api/caution")
public class CautionGarantieController {
	
	@Autowired
	
	private CautionGrantieRepo cautiongrantieRepo;
	
	@GetMapping("/")
	public ResponseEntity<List<cautiongarantie>> cautiongrantie() {
		List<cautiongarantie>listeCautionGrantie=cautiongrantieRepo.findAll();
		return new ResponseEntity<>(listeCautionGrantie, HttpStatus.OK);
		}
	
	@PostMapping("/add") 
	public ResponseEntity<cautiongarantie> ajouter(@RequestBody cautiongarantie cautiongrantie) {
		try {
	
		 cautiongrantieRepo.save(cautiongrantie);
		 
		 return new ResponseEntity<>(cautiongrantie, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}

	 @GetMapping("/{id}")
		
	   public ResponseEntity<cautiongarantie> detail(@PathVariable("id") int id) {
	    
	    Optional<cautiongarantie>cg=cautiongrantieRepo.findById(id);
	    if(cg.isPresent())
	      {
	     cautiongarantie c=cg.get();
	    return new ResponseEntity<>(c, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 cautiongrantieRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<cautiongarantie> modifier(@PathVariable("id") int id,
	     @RequestBody cautiongarantie cautiongrantie) {
	 
	   if(cautiongrantieRepo.save(cautiongrantie)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
}
