package com.suivimarche.suivimarche.controller;

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

import com.suivimarche.suivimarche.Repo.ChargePersonnelRepo;
import com.suivimarche.suivimarche.models.chargepersonnel;
import com.suivimarche.suivimarche.models.marche;


@RestController
@RequestMapping("api/chargepersonnel")
public class ChargePersonnelController {

	@Autowired
	
	private ChargePersonnelRepo chargepersonnelRepo;
	
	
	@PostMapping("/add") 
	public ResponseEntity<chargepersonnel> ajouter(@RequestBody chargepersonnel chargepersonnel) {
		try {
	
		 chargepersonnelRepo.save(chargepersonnel);
		 
		 return new ResponseEntity<>(chargepersonnel, HttpStatus.CREATED);
		 } catch (Exception e) {
		
		 return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		}
	@GetMapping("/{id}")
	
	   public ResponseEntity<chargepersonnel> detail(@PathVariable("id") int id) {
	    
	    Optional<chargepersonnel>cp=chargepersonnelRepo.findById(id);
	    if(cp.isPresent())
	      {
	     chargepersonnel c=cp.get();
	    return new ResponseEntity<>(c, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	

@DeleteMapping("/{id}")
public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") int id) {
try {

	 chargepersonnelRepo.deleteById(id);

return new ResponseEntity<>(HttpStatus.OK);
} catch (Exception e) {

return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
@PutMapping("/{id}")
public ResponseEntity<marche> modifier(@PathVariable("id") int id,
    @RequestBody chargepersonnel chargepersonnel) {

  if(chargepersonnelRepo.save(chargepersonnel)!=null)
  {
   
    return new ResponseEntity<>(HttpStatus.OK);
  } else {
  
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}

}
