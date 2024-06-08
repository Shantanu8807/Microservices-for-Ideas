package com.userservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dto.ResponseDto;
import com.userservice.exception.NoUsersPresentCurrently;
import com.userservice.model.User;
import com.userservice.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
     
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<ResponseDto> getAllUsers() throws NoUsersPresentCurrently
	{
	       	List<User> list=userService.getAllUsers();
	       	if(list==null)
	       	{
	       		throw new NoUsersPresentCurrently("No User Found");
	       	}
	       	else
	       	{
	       		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseDto(list,HttpStatus.ACCEPTED.toString(),"Success",LocalDateTime.now()));
	       	}
	}
	
}
