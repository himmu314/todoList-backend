package com.xoriant.todos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.todos.dto.LoginDTO;
import com.xoriant.todos.model.User;
import com.xoriant.todos.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public List<User> getUsers(){
		return service.getUsers();
	}
	
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/{userId}-{password}")
	public LoginDTO getLoginDetails(@PathVariable String userId, @PathVariable String password) {
		return service.getLoginDetails(userId,password);
	}
	
	

}
