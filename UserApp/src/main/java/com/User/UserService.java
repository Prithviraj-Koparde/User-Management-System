package com.User;

import java.util.List;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired // to initialise repo implicitly
	private UserRepository repo;
	
	//Insert method
	public Userapp Insert(Userapp user) {
		return repo.save(user);
	}
	
	//delete user method
	public Optional<Userapp> Delete(Long id){
		
		Optional<Userapp> user = repo.findById(id);
		if(user.isPresent()) {
			repo.deleteById(id);
		}
		return user;
	}
	
	
	//retrieve single user method
	public Optional<Userapp> Retrieve(Long id) {
		
		return repo.findById(id);
	}
	
	//retrieve all users method
	public List<Userapp> RetrieveAll(){
		
		return repo.findAll();
		
	}
	
	
	//Update user data method
	public Userapp updateUser(Userapp user) {
	    // Ensure the user has a valid id before proceeding.
	    if (user.getId() == null) {
	        System.err.println("User ID must not be null for update");
	        return null;
	    }
	    
	    // Locate the existing record by id.
	    Optional<Userapp> optionalUser = repo.findById(user.getId());

	    if (optionalUser.isPresent()) {
	        Userapp existingUser = optionalUser.get();
	        
	        // Update the fields.
	        existingUser.setName(user.getName());
	        existingUser.setType(user.getType());
	        existingUser.setPassword(user.getPassword());
	        
	        // Save the updated record and return it.
	        Userapp savedUser = repo.save(existingUser);
	        return savedUser;
	    } else {
	        System.err.println("User not found with id: " + user.getId());
	        return null;
	    }
	}

	
	
	//Login user method
	public Userapp Login(String name, String password) {
        // Query the database to find the user by name and password
        Optional<Userapp> user = repo.findByNameAndPassword(name, password);
        if (user.isPresent()) {
            return user.get(); // Return the user object if credentials match
        } else {
            throw new RuntimeException("Invalid credentials"); // Handle invalid login
        }
    }
	
	
	//logout method for user
	public boolean Logout() {
		try {
			System.out.print("User LogOut was successful");
			return true;
		}catch (Exception e) {
			System.err.print("Error whhile logging Out" + e.getMessage());
			return false;
			
		}
	}

	
	
	
	
	
	
	



	
}
