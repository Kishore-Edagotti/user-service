package com.pst.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pst.user_service.entity.UserEntity;
import com.pst.user_service.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService service;
//	@GetMapping("hello")
//	public String hello() {
//		System.out.println("hello executed");
//		return "Hii welcome to spring boot 1st project";
//		
//	}
	
	@GetMapping
	public List<UserEntity> getAll(){
		return service.getAllUsers();
		
	}
	@PostMapping
	public UserEntity add(@RequestBody UserEntity user) {
		return service.addUser(user);
	}
	
	@PutMapping("/{id}")
	public UserEntity update(@PathVariable Long id,@RequestBody UserEntity user) {
		return service.updateUser(id, user);
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		
		service.deleteUser(id);
		return "deleted";
	}
	
	@GetMapping("/role/{email}")
	public String getRole(@PathVariable String email) {
		return service.getRoleByEmail(email);
		
	}
	
	

}
