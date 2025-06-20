package com.pst.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pst.user_service.entity.UserEntity;
import com.pst.user_service.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<UserEntity> getAllUsers(){
		return repository.findAll();
		
	}
	
	public UserEntity getUserById(Long id) {
		return repository.findById(id).orElse(null);
		
	}
	
	public UserEntity addUser(UserEntity user) {
		return repository.save(user);	
	}
	
	public UserEntity updateUser(Long id,UserEntity user) {
		user.setId(id);
		return repository.save(user);
		
	}
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	public String getRoleByEmail(String email) {
		return repository.findByEmail(email).map(UserEntity::getRole).orElse("Not Found");
		
	}

}
