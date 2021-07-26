package com.examples.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examples.todoapp.model.ToDo;
import com.examples.todoapp.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
