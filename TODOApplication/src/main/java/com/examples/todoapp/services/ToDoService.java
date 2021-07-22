package com.examples.todoapp.services;

import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.stereotype.Service;

import com.examples.todoapp.model.ToDo;
import com.examples.todoapp.repository.ToDoRepository;

@Service
public class ToDoService {

	ToDoRepository toDoRepository;
	public List<ToDo> findAll() {
		// TODO Auto-generated method stub
		return toDoRepository.findAll();
	}
	public ToDo findById(Long Id) {
		// TODO Auto-generated method stub
		return toDoRepository.findById(Id);
	}
	public ToDo save(ToDo toSave) {
		// TODO Auto-generated method stub
		return toDoRepository.save(toSave);
	}
	public ToDo updateById(long id, ToDo toUpdate) {
		// TODO Auto-generated method stub
		toUpdate.setId(id);
		return toDoRepository.update(toUpdate);
	}

}
