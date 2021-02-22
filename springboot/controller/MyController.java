package com.example.springboot.controller;

import com.example.springboot.dto.MyControllerDTO;
import com.example.springboot.dto.MyResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MyController {
	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Success!!";
	}

	// @PutMapping
	//

	@PostMapping(path = "/hello-post")
	public String HelloWorldPost(){
		return "Success Post!!!";
	}
	@GetMapping(path = "/hello-query")
	public String helloQuery(@RequestParam String query){
		return "query"+query;
	}
	@PostMapping(path = "/register")
	public String registerValue(@RequestBody MyControllerDTO request){
		return request.toString();
	}

	@GetMapping(path = "/employee/{employeeId}")
	public MyResponseDTO getEmployeeDetails(@PathVariable String employeeId){
		MyResponseDTO response=new MyResponseDTO();
		response.setId(employeeId);
		return response;
	}
}
