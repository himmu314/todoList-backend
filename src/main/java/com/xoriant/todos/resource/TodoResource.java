package com.xoriant.todos.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.todos.model.Todos;
import com.xoriant.todos.service.TodoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/todos")
public class TodoResource {
	
	@Autowired
	private TodoService service; 
	
	@GetMapping("/")
	public List<Todos> getTodos(){
		return service.getTodos();
	}
	
	@PostMapping(value="/", consumes = "application/json")
	public Todos addTodo(@RequestBody Todos todo) {
		return service.addTodo(todo);
	}
	
	@GetMapping("/user/{uid}")
	public List<Todos> getTodosByUserId(@PathVariable int uid){
		return service.getTodosByUserId(uid);
	}
	
	@DeleteMapping("/{tid}")
	public boolean deleteTodoById(@PathVariable int tid) {
		return service.deleteTodoById(tid);
	}
	
	@PutMapping("/")
	public boolean updateTodo(@RequestBody Todos todo){
		return service.upadteTodo(todo);
	}
	

}
