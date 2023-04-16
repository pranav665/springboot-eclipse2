package com.example.demo.todo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//jpa 
//bean->database

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="userName")
	private String name;
	

	private String description;
	private LocalDate targetDate;
	private boolean done;
	public Todo(int id, String nameString, String description, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.name = nameString;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return name;
	}
	public void setNameString(String nameString) {
		this.name = nameString;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", nameString=" + name+ ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
	
	
}
