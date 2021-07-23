package com.examples.todoapp.repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.function.IntPredicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.examples.todoapp.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {

	@Query("Select td from ToDo td where td.date = :data")
	List<ToDo> findAllToDoWithDate(@Param("data") LocalDateTime date);
}
	
