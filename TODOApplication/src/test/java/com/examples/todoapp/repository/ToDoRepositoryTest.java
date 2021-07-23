package com.examples.todoapp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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

	@Autowired
	private ToDoRepository toDoRepository;

	private ToDo todo1;
	private ToDo todo2;
	@Before
	public void setup() {
		Map m1 = new HashMap<String, Boolean>();
		m1.put("todo1", false);
		Map m2 = new HashMap<String, Boolean>();
		m2.put("todo2", true);
		todo1 = new ToDo(null, 1L, m1, LocalDateTime.of(2012, Month.DECEMBER, 12, 0, 0));
		todo2 = new ToDo(null, 1L, m2, LocalDateTime.of(2014, Month.NOVEMBER, 15, 0, 0));

	}

	@Test
	public void test_findAll_nothing() {
		assertThat(toDoRepository.findAll()).isEmpty();
	}

	@Test
	public void test_findAll() {
		ToDo result1 = entityManager.persistAndFlush(todo1);
		ToDo result2 = entityManager.persistAndFlush(todo2);
		assertThat(toDoRepository.findAll()).containsExactly(result1, result2);
	}

	@Test
	public void test_findAllToDoWithExactlyDate() {
		ToDo result1 = entityManager.persistAndFlush(todo1);
		ToDo result2 = entityManager.persistAndFlush(todo2);
		assertThat(toDoRepository.findAllToDoWithDate(LocalDateTime.of(2012, Month.DECEMBER, 12, 0, 0)))
				.containsExactly(result1);
	}

	@Test
	public void test_save() {
		Map mapToSave = new HashMap<String, Boolean>();
		mapToSave.put("todo1", false);
		ToDo todoToSave = new ToDo(null, 1L, mapToSave, LocalDateTime.of(2012, Month.DECEMBER, 12, 0, 0));
		ToDo result=toDoRepository.save(todoToSave);
		assertThat(result).hasNoNullFieldsOrProperties();
		assertThat(result).hasFieldOrPropertyWithValue("toDo",mapToSave );
		assertThat(result).hasFieldOrPropertyWithValue("idOfUser",1L );
		assertThat(result).hasFieldOrPropertyWithValue("date",LocalDateTime.of(2012, Month.DECEMBER, 12, 0, 0) );
	}

}
