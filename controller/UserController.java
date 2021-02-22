package com.example.springboot.controller;

import com.example.springboot.dto.MyControllerDTO;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
	public UserController(UserService userService){
		this.userService=userService;
		System.out.println("Inside UserController Constructor");
	}
	@Autowired
	private UserService userService;

	//[POST] /update/employee/{id}
	//{"firstName":".."...} MyRequestDTO
	//boolean true/false

	@PostMapping(path = "/update/employee/{employeeId}")
	public boolean updateEmployee(@PathVariable String employeeId, @RequestBody MyControllerDTO request){
		 return userService.updateEmployee(request,employeeId);
	}
}
