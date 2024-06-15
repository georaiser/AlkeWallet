package com.alkewallet.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkewallet.entity.User;
import com.alkewallet.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public Optional<User> getById(Long id) {
		return userRepository.findById(id);
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);	
	}
	
	public boolean deleteByUsername(String username) {
		boolean state = false;
		User user = userRepository.findByUsername(username);
		if (user != null) {
			userRepository.deleteById(user.getId());
			state=true;
		}
		return state;
	}


}
