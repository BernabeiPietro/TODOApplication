package com.examples.todoapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

 // This tells Hibernate to make a table out of this class
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(mappedBy="idOfUser")
	private List<ToDo> todo;

	public User() {
		super();
	}

	private String name;

	private String email;

	public User(Long id, String name, String email) {
		// TODO Auto-generated constructor stub

		this.id = id;
		this.name = name;
		this.email = email;
		this.todo=new ArrayList<ToDo>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public List<ToDo> getToDo()
	{
		return todo;
	}
	public void addToDo(ToDo td) {
		todo.add(td);
	}

	public void setTodo(List<ToDo> todo) {
		this.todo = todo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, todo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(todo, other.todo);
	}


}