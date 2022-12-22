package com.xoriant.todos.service;

import java.util.List;

import com.xoriant.todos.model.Todos;

public interface TodoService {

	List<Todos> getTodos();

	Todos addTodo(Todos todo);

	List<Todos> getTodosByUserId(int uid);

	boolean deleteTodoById(int tid);

	boolean upadteTodo(Todos todo);

}
