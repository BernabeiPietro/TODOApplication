package com.examples.todoapp.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ToDoRepositoryTest {
	
	
	@Autowired
	 private ToDoRepository ToDoRepository;
	
	@Test
	public void test_findAll_nothing() {
		fail("Not yet implemented");
	}

}
