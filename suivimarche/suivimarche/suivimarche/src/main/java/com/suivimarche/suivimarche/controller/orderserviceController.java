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

import com.suivimarche.suivimarche.Repo.OrdreServiceRepo;

import com.suivimarche.suivimarche.models.ordreservice;

@RestController
@RequestMapping("api/ordreservice")
public class orderserviceController {

@Autowired
private OrdreServiceRepo ordreserviceRepo;

@GetMapping("/")
public ResponseEntity<List<ordreservice>> ordreservice() {
List<ordreservice>listeordreservice=ordreserviceRepo.findAll();
return new ResponseEntity<>(listeordreservice, HttpStatus.OK);
}

@PostMapping("/add") 
public ResponseEntity<ordreservice> ajouter(@RequestBody ordreservice ordreservice) {
	try {

	 ordreserviceRepo.save(ordreservice);
	 
	 return new ResponseEntity<>(ordreservice, HttpStatus.CREATED);
	 } catch (Exception e) {
	
	 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	}

 @GetMapping("/{id}")
	
   public ResponseEntity<ordreservice> detail(@PathVariable("id") int id) {
    
    Optional<ordreservice>os=ordreserviceRepo.findById(id);
    if(os.isPresent())
      {
    	ordreservice o=os.get();
    return new ResponseEntity<>(o, HttpStatus.OK);
     }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }



 @DeleteMapping("/{id}")
 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
 try {

	 ordreserviceRepo.deleteById(id);

 return new ResponseEntity<>(HttpStatus.OK);
 } catch (Exception e) {

 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }
 }
 @PutMapping("/{id}")
 public ResponseEntity<ordreservice> modifier(@PathVariable("id") int id,
     @RequestBody ordreservice ordreservice) {
 
   if(ordreserviceRepo.save(ordreservice)!=null)
   {
    
     return new ResponseEntity<>(HttpStatus.OK);
   } else {
   
     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
 }


}
