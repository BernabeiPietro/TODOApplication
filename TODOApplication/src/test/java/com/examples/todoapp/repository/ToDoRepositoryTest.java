package com.examples.todoapp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.examples.todoapp.model.ToDo;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ToDoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	private ToDoRepository toDoRepository;

	@Test
	public void test_findAll_nothing() {
		toDoRepository = new ToDoRepository();
		assertThat(toDoRepository.findAll()).isEmpty();
	}

	@Test
	public void test_findAll() {
		ToDo todo1 = new ToDo(null, null, new HashMap<String, Boolean>(), new Date());
		ToDo todo2 = new ToDo(null, null, new HashMap<String, Boolean>(), new Date());
		ToDo result1 = entityManager.persistAndFlush(todo1);
		ToDo result2 = entityManager.persistAndFlush(todo1);
		assertThat(toDoRepository.findAll()).containsExactly(result1,result2);
	}

}
