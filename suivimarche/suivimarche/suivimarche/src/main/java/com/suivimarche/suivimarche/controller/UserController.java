package com.suivimarche.suivimarche.controller;



import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivimarche.suivimarche.Repo.UserDao;
import com.suivimarche.suivimarche.models.User;
import com.suivimarche.suivimarche.models.marche;
import com.suivimarche.suivimarche.service.UserService;

@RestController
@RequestMapping("api/user") 
public class UserController {

	  @Autowired
	    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    
	@GetMapping("/")
	public ResponseEntity<List<User>> users() {
	List<User>listeUsers=userDao.findAll();
	return new ResponseEntity<>(listeUsers, HttpStatus.OK);
	}
    
    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    } 
    
    @PostMapping("/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('admin')")
     public String forAdmin(){
    	
        return "This URL is only accessible to the admin";
    }

    @GetMapping({"/forUser"})
  @PreAuthorize("hasRole('user')")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
    @GetMapping("/{id}")
	
	   public ResponseEntity<User> detail(@PathVariable("id") String userName) {
	    Optional<User>u=userDao.findById(userName);
	    if(u.isPresent())
	      {
	     User uu=u.get();
	    return new ResponseEntity<>(uu, HttpStatus.OK);
	     }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	
	
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<HttpStatus> supprimer(@PathVariable("id") String userName) {
	 try {

		 userDao.deleteById(userName);
	
	 return new ResponseEntity<>(HttpStatus.OK);
	 } catch (Exception e) {

	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	 }
	 @PutMapping("/{id}")
	 public ResponseEntity<User> modifier(@PathVariable("id") String userName,
	     @RequestBody User user) {
		 user.setUserPassword(getEncodedPassword(user.getUserPassword()));
	   if(userDao.save(user)!=null)
	   {
	    
	     return new ResponseEntity<>(HttpStatus.OK);
	   } else {
	   
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	   }
	 }

	 public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
	
	
}


