package com.examples.todoapp.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
	@Override
	public int hashCode() {
		return Objects.hash(id, toDo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ToDo))
			return false;
		ToDo other = (ToDo) obj;
		return Objects.equals(id, other.id) && Objects.equals(toDo, other.toDo);
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Map<String,Boolean> toDo;
	public Map<String,Boolean> getToDo() {
		return toDo;
	}
	public void setToDo(Map<String,Boolean> toDo) {
		this.toDo = toDo;
	}
	
}
