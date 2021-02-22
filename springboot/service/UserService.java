package com.example.springboot.service;

import com.example.springboot.dto.MyControllerDTO;
import com.example.springboot.dto.MyResponseDTO;


public interface UserService {
	boolean updateEmployee(MyControllerDTO request, String id);
}

