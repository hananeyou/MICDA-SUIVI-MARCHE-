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

import com.suivimarche.suivimarche.Repo.ReglementFournisseurRepo;

import com.suivimarche.suivimarche.models.reglementfournisseur;

@RestController
@RequestMapping("api/reglementfournisseur")
public class reglementfournisseurController {

	@Autowired
	private ReglementFournisseurRepo reglementfournisseurRepo;
	
	 @GetMapping("/")
		public ResponseEntity<List<reglementfournisseur>> reglementfournisseur() {
		List<reglementfournisseur>listereglementfournisseur=reglementfournisseurRepo.findAll();
		return new ResponseEntity<>(listereglementfournisseur, HttpStatus.OK);
		}

	
		@PostMapping("/add") 
		public ResponseEntity<reglementfournisseur> ajouter(@RequestBody reglementfournisseur reglementfournisseur ) {
			try {
		
			 reglementfournisseurRepo.save(reglementfournisseur);
			 
			 return new ResponseEntity<>(reglementfournisseur, HttpStatus.CREATED);
			 } catch (Exception e) {
			
			 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			 }
			}
		
		 @GetMapping("/{id}")
			
		   public ResponseEntity<reglementfournisseur> detail(@PathVariable("id") int id) {
		    
		    Optional<reglementfournisseur>rf=reglementfournisseurRepo.findById(id);
		    if(rf.isPresent())
		      {
		    	reglementfournisseur r=rf.get();
		    return new ResponseEntity<>(r, HttpStatus.OK);
		     }
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		
		
		
		 @DeleteMapping("/{id}")
		 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
		 try {

			 reglementfournisseurRepo.deleteById(id);
		
		 return new ResponseEntity<>(HttpStatus.OK);
		 } catch (Exception e) {

		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		 }
		 }
		 @PutMapping("/{id}")
		 public ResponseEntity<reglementfournisseur> modifier(@PathVariable("id") int id,
		     @RequestBody reglementfournisseur reglementfournisseur) {
		 
		   if(reglementfournisseurRepo.save(reglementfournisseur)!=null)
		   {
		    
		     return new ResponseEntity<>(HttpStatus.OK);
		   } else {
		   
		     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		   }
		 }
		

}
