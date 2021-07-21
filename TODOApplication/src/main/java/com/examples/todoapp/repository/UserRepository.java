package com.examples.todoapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.examples.todoapp.model.User;

@Repository
public class UserRepository {

	private static final String TEMPORARY_IMPLEMENTATION = "Temporary implementation";

	public List<User> findAll() {
		throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
	}

	public Optional<User> findById(long l) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
	}

	public User save(User user) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(TEMPORARY_IMPLEMENTATION);
	
	}
}