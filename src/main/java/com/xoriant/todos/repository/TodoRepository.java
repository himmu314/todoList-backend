package com.xoriant.todos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.todos.model.Todos;

@Repository
public interface TodoRepository extends JpaRepository<Todos, Integer> {


	Todos findByTid(int tid);

	List<Todos> findByUserUidOrderByTidDesc(int uid);

}
