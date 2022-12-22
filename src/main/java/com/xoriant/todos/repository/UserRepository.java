package com.xoriant.todos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.todos.dto.LoginDTO;
import com.xoriant.todos.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserIdAndPassword(String userId, String password);

}
