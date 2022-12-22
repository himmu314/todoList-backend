package com.xoriant.todos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.todos.model.Todos;
import com.xoriant.todos.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepository repository;

	@Override
	public List<Todos> getTodos() {
		
		return repository.findAll();
	}

	@Override
	public Todos addTodo(Todos todo) {
		todo.setDate(LocalDate.now());
		return repository.save(todo);
	}

	@Override
	public List<Todos> getTodosByUserId(int uid) {
		return repository.findByUserUidOrderByTidDesc(uid);
	}

	@Override
	public boolean deleteTodoById(int tid) {
		
		Todos todo = repository.findByTid(tid);
		if(todo==null)
			return false;
		else
			repository.delete(todo);
		
		return true;
	}

	@Override
	public boolean upadteTodo(Todos todo) {
		Todos updatedTodo = repository.save(todo);
		
		if(updatedTodo==null)
			return false;
		else
			return true;
	}
	
	
}
