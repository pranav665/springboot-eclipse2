package com.example.demo.todo;

import java.time.LocalDate;
import java.util.List;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {


	/*
	private TodoService todoService;

	
	public TodoController(TodoService todoService) {
	
		this.todoService = todoService;
	}
	
	@RequestMapping("todo")
	public String ListOftodo(ModelMap model) {
		String userName= getLoggedInUsername(model);
		List<Todo> todos= todoService.findByUserName(userName);
		
		model.addAttribute("todos",todos);
		return "list_todo";
	}

	
	//get,post,update,delete
	@RequestMapping(value="add"  , method = RequestMethod.GET)
	public String showAddPage(ModelMap model) {
		String userName= getLoggedInUsername(model);
		Todo todo=new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
		model.put("todo",todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add", method= RequestMethod.POST)	
	public String addTodo(ModelMap model, Todo todo ) {
		
	
		
		String userName= getLoggedInUsername(model);
		
		todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:todo";
	}
	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById(id);
		return "redirect:todo";
	}
	
	@RequestMapping(value="update-todo", method= RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		Todo todo = todoService.findById(id) ; 
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="update-todo", method= RequestMethod.POST)	
	public String addTodo(ModelMap model, Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String userName= getLoggedInUsername(model);
		todo.setNameString(userName);
		todoService.updateTodo(todo);
		return "redirect:todo";
	}
	

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication=
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	*/
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;
		
	
	@RequestMapping("todo")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoService.findByUserName(username);
		model.addAttribute("todos", todos);
		
		return "list_todo";
	}

	//GET, POST
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}

	@RequestMapping(value="add", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model,  Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:todo";
		}
		
		String username = getLoggedInUsername(model);
		todoService.addTodo(username, todo.getDescription(), 
				LocalDate.now().plusYears(1), false);
		return "redirect:todo";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		//Delete todo
		
		todoService.deleteById(id);
		return "redirect:todo";
		
	}

	@RequestMapping(value="update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model,  Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setNameString(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
