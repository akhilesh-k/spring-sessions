package com.example.springboot.service.impl;

import com.example.springboot.dto.MyControllerDTO;
import com.example.springboot.dto.MyResponseDTO;
import com.example.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {
	public UserServiceImpl(){
		System.out.println("Inside User Service Constructor");
	}
	@PostConstruct
	public void init(){
		System.out.println("Inside the UserService PostConstruct..");
	}
	@Override
	public boolean updateEmployee(MyControllerDTO request, String id) {
		System.out.println("Inside the User Service "+request+" "+id);
		return false;
	}
}
