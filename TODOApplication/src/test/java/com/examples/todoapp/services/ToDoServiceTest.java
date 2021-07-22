package com.examples.todoapp.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.examples.todoapp.model.ToDo;
import com.examples.todoapp.repository.ToDoRepository;

import ch.qos.logback.core.status.StatusListenerAsList;

@RunWith(MockitoJUnitRunner.class)
public class ToDoServiceTest {

	@Mock
	ToDoRepository toDoRepository;
	@InjectMocks
	ToDoService toDoService;

	@Test
	public void test_findAll_empty() {
		when(toDoRepository.findAll()).thenReturn(Collections.emptyList());
		assertThat(toDoService.findAll()).isEmpty();
	}

	@Test
	public void test_findAll() {
		ToDo todo1 = new ToDo(1L, 1L, new HashMap<String, Boolean>(), new Date());
		ToDo todo2 = new ToDo(2L, 2L, new HashMap<String, Boolean>(), new Date());
		when(toDoRepository.findAll()).thenReturn(asList(todo1, todo2));
		assertThat(toDoService.findAll()).containsExactly(todo1,todo2);
	}
	
	@Test
	public void test_findById_found() {
		ToDo todo1 = new ToDo(1L, 1L, new HashMap<String, Boolean>(), new Date());
		when(toDoRepository.findById(1L)).thenReturn(todo1);
		assertThat(toDoService.findById(1L)).isEqualTo(todo1);
	}
	@Test
	public void test_findById_notfound() {
		when(toDoRepository.findById(1L)).thenReturn(null);
		assertThat(toDoService.findById(1L)).isEqualTo(null);
	}
	
	@Test
	public void test_save() {
		ToDo toSave =spy(new ToDo(null,1l,new HashMap<String, Boolean>(),new Date()));
		ToDo saved=new ToDo(1L,1L,new HashMap<String, Boolean>(),new Date());
		when(toDoRepository.save(any(ToDo.class))).thenReturn(saved);
		ToDo result=toDoService.save(toSave);
		assertThat(result).isSameAs(saved);
		InOrder inOrder=inOrder(toSave,toDoRepository);
		inOrder.verify(toDoRepository).save(toSave);
	}
	@Test
	public void test_updateById() {
		ToDo toUpdate =spy(new ToDo(99L,1L,new HashMap<String, Boolean>(),new Date()));
		ToDo update=new ToDo(1L,1L,new HashMap<String, Boolean>(),new Date());
		when(toDoRepository.update(any(ToDo.class))).thenReturn(update);
		ToDo result=toDoService.updateById(1L,toUpdate);
		assertThat(result).isSameAs(update);
		InOrder inOrder=inOrder(toUpdate,toDoRepository);
		inOrder.verify(toUpdate).setId(1L);
		inOrder.verify(toDoRepository).update(toUpdate);
	}
}
