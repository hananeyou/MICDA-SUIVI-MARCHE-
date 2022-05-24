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

import com.suivimarche.suivimarche.Repo.DecompteRepo;
import com.suivimarche.suivimarche.models.decompte;


@RestController
@RequestMapping("api/decompte")
public class DecompteController {
	
	@Autowired
	private DecompteRepo decompteRepo;

	@GetMapping("/")
	public ResponseEntity<List<decompte>> decompte() {
	List<decompte>listeDecompte=decompteRepo.findAll();
	return new ResponseEntity<>(listeDecompte, HttpStatus.OK);
	}
	@PostMapping("/add") 
	public ResponseEntity<decompte> ajouter(@RequestBody decompte decompte) {
		try {
	
		 decompteRepo.save(decompte);
		 
		 return new ResponseEntity<>(decompte, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	
	 @GetMapping("/{id}")
		
	   public ResponseEntity<decompte> detail(@PathVariable("id") int id) {
	    
	    Optional<decompte>dd=decompteRepo.findById(id);
	    if(dd.isPresent())
	      {
	    decompte d=dd.get();
	    return new ResponseEntity<>(d, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
	 try {

		 decompteRepo.deleteById(id);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<decompte> modifier(@PathVariable("id") int id,
	     @RequestBody decompte decompte) {
	 
	   if(decompteRepo.save(decompte)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }
	
	
}
