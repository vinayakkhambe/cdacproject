package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserService userservice;
	
	public UserController() {
		System.out.println("UserControllerCalled");
	}
	
	@GetMapping
	public List<UserDto> listAllUsers(){
		System.out.println("in listUsers");
		return userservice.getAllusers();
	}
	
	@GetMapping("/{id}")
	public UserDto getById(@PathVariable Long id){
		System.out.println("in listUsers");
		return userservice.getById(id);
	}
	
	@PostMapping
	public User addUser(@RequestBody UserDto User) {
	
		return userservice.addUser(User);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userservice.deleteUser(id);
	}
    
	@PutMapping
	public User updateUser(@RequestBody UserDto User)
	{
		return userservice.updateUser(User);
		
	}
	
}
