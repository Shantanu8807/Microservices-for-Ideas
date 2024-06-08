package com.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.exception.NoUsersPresentCurrently;
import com.userservice.model.User;
import com.userservice.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers() throws NoUsersPresentCurrently
	{
		List<User> users=userRepo.findAll();
		if(users==null)
		{
			throw new NoUsersPresentCurrently("No Users Found");
		}
		else
		{
			return users;
		}
		
	}

}
