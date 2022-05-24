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

import com.suivimarche.suivimarche.Repo.MarcheRepo;
import com.suivimarche.suivimarche.models.marche;
@RequestMapping("api/marche") 
@RestController
public class marcheController {
	@Autowired
	 private MarcheRepo marcheRepo;
	
	
	@GetMapping("/")
	public ResponseEntity<List<marche>> marche() {
	List<marche>listeMarche=marcheRepo.findAll();
	return new ResponseEntity<>(listeMarche, HttpStatus.OK);
	}
	
	
	@PostMapping("/add") 
	public ResponseEntity<marche> ajouter(@RequestBody marche marche) {
		try {
	
		 marcheRepo.save(marche);
		 
		 return new ResponseEntity<>(marche, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
	
	   public ResponseEntity<marche> detail(@PathVariable("id") int id) {
	    
	    Optional<marche>mm=marcheRepo.findById(id);
	    if(mm.isPresent())
	      {
	     marche m=mm.get();
	    return new ResponseEntity<>(m, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 marcheRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<marche> modifier(@PathVariable("id") int id,
	     @RequestBody marche marche) {
	 
	   if(marcheRepo.save(marche)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
	
}


