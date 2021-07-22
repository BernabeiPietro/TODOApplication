package com.examples.todoapp.model;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Map<String, Boolean> toDo;
	private Date date;
	private Long idOfUser;

	public ToDo(Long id, Long idOfUser, Map<String, Boolean> toDo, Date date) {
		super();
		this.id = id;
		this.toDo = toDo;
		this.date = date;
		this.idOfUser = idOfUser;
	}

	public Map<String, Boolean> getToDo() {
		return toDo;
	}

	public void setToDo(Map<String, Boolean> toDo) {
		this.toDo = toDo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, idOfUser, toDo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ToDo))
			return false;
		ToDo other = (ToDo) obj;
		return Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(idOfUser, other.idOfUser) && Objects.equals(toDo, other.toDo);
	}

}
