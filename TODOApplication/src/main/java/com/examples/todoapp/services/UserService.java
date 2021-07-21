package com.examples.todoapp.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.examples.todoapp.model.User;
import com.examples.todoapp.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	public User insertNewUser(User userToSave) {
		// TODO Auto-generated method stub
		userToSave.setId(null);
		return userRepository.save(userToSave);
	}

	public User updateUserById(long id, User userToUpdate) {
		// TODO Auto-generated method stub

		userToUpdate.setId(id);
		return userRepository.save(userToUpdate);
	}

}
