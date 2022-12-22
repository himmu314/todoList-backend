package com.xoriant.todos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.todos.dto.LoginDTO;
import com.xoriant.todos.model.User;
import com.xoriant.todos.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public User addUser(User user) {
		return repository.save(user);
	}

	@Override
	public LoginDTO getLoginDetails(String userId, String password) {
		User user = repository.findByUserIdAndPassword(userId,password);
		
		if(user==null)
			return null;
		else {
			
			if(user.getPassword().equals(password)) {				
				LoginDTO loginDto = new LoginDTO();
				loginDto.setUid(user.getUid());
				loginDto.setUserName(user.getUserName());
				return loginDto;
			}
			else
				return null;
		}
	}

}
