package com.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class UserController {

	@Autowired // to initialise service implicitly
	private UserService service;
	
	
	//All methods are RESTfull API methods for postman
	
	
	//Insert method
	@PostMapping("/insertUser")
	public void insert(@RequestBody Userapp user) {
		service.Insert(user);
	}
	
	//delete user
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Userapp> deleteduser = service.Delete(id);
		if (deleteduser.isPresent()) {
			return ResponseEntity.ok(deleteduser.get());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found ");
		}
		
		}
	
	
	// retrieve single user
	@GetMapping("/retrieveUser/{id}")
	public Optional<Userapp> retrieve(@PathVariable Long id) {
		return service.Retrieve(id);
	}
	
	//retrieve all users
	@GetMapping("/readUser")
	public List<Userapp> retrieveAll(){
		
		return service.RetrieveAll();
		
	}
	
	
	//Update user data
	@PutMapping("/updateUser")
    public Userapp updateUser(@RequestBody Userapp user) {
        Userapp updatedUser = service.updateUser(user);
        if(updatedUser == null) {
            System.err.println("Update failed: User not found with name " + user.getName());
        }
        return updatedUser;
    }
	
	
	//Login user method
	 @PostMapping("/login")
	    public ResponseEntity<Userapp> login(@RequestBody Userapp user) {
	        try {
	            Userapp loggedInUser = service.Login(user.getName(), user.getPassword());
	            return ResponseEntity.ok(loggedInUser); // Return user details on successful login
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Handle login failure
	        }
	    }
	 
	 
	//Logout user method
	 @PostMapping("/logout")
	 public ResponseEntity<Boolean> Logout()
	 {
		 boolean success = service.Logout();
		 if(success) {
			 return ResponseEntity.ok(true); // Return true if logout succeed
		 }else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false); // Return false if there's an error
		 }
		 
	 }
	 
	
	
	
	
	
	
}
