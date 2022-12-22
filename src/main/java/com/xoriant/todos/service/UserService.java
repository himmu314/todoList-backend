package com.xoriant.todos.service;

import java.util.List;

import com.xoriant.todos.dto.LoginDTO;
import com.xoriant.todos.model.User;

public interface UserService {

	List<User> getUsers();

	User addUser(User user);

	LoginDTO getLoginDetails(String userId, String password);

}
