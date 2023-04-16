package com.example.demo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int idCount = 1;

	static {

		todos.add(new Todo(++idCount, "pranav", "learn java", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++idCount, "umesh", "learn c#", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++idCount, "lukhman", "learn spring", LocalDate.now().plusYears(3), false));

	}

	public List<Todo> findByUserName(String userName) {
		Predicate<? super Todo> predicate = 
				todo -> todo.getNameString().equalsIgnoreCase(userName);
		return  todos.stream().filter(predicate).collect(Collectors.toList());
	}

	public void addTodo(String userName, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++idCount, userName, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate =  todo -> todo.getId()==id  ;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
	
		Predicate<? super Todo> predicate =  todo -> todo.getId()==id  ;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
		
		
	}
}
