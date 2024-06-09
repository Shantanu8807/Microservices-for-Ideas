package com.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.userservice.dto.GlobalResponseDto;
import com.userservice.dto.UserDto;
import com.userservice.exception.NoUserFoundException;
import com.userservice.exception.NoUsersPresentCurrently;
import com.userservice.exception.UserAlreadyExistsWithEmail;
import com.userservice.feignclient.IdeaClient;
import com.userservice.mapper.UserMapper;
import com.userservice.model.User;
import com.userservice.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private IdeaClient ideaClient;
	
	public List<UserDto> getAllUsers() throws NoUsersPresentCurrently
	{
		List<User> users=userRepo.findAll();
		if(users==null)
		{
			throw new NoUsersPresentCurrently("No Users Found");
		}
		else
		{
			List<UserDto> list= new ArrayList<>();
			list=UserMapper.convertUserToUserDto(users, list);
			return list;
		}
		
	}
	
	public UserDto findUserByUserId(Long id) throws NoUserFoundException
	{
		User user=userRepo.findByUserId(id);
		if(user==null)
		{
			throw new NoUserFoundException("No User Found with id");
		}
		else
		{   
			UserDto userDto= new UserDto();
			userDto=UserMapper.convertUserToUserDto(user, userDto);
			return userDto;
		}
		
	}
	
	public UserDto findUserByEmail(String email)
	{
		User user=userRepo.findByEmail(email);
		UserDto userDto=new UserDto();
		if(user==null)
		{
			throw new NoUserFoundException("No User found with email");
		}
		else
		{
			userDto=UserMapper.convertUserToUserDto(user, userDto);
			
			return userDto;
		}
		
	}
	
	public boolean checkUserExistsWithEmail(String email)
	{
		User user=userRepo.findByEmail(email);
		if(user==null)
		{
			return false;
		}
		else
		{
			
			return true;
		}
	}
	
	public User createNewUser(User user)
	{
		userRepo.save(user);
		return user;
	}
	
	public int increaseIdeaTotalCount(Long userId)
	{
		userRepo.incrementValueColumnById(userId);
		int totalCount=userRepo.findTotalIdeasOfUser(userId);
		return totalCount;
		
	}
	
	public int decrementIdeaTotalCount(Long userId)
	{
		userRepo.decrementIdeaTotalCount(userId);
		int totalCount=userRepo.findTotalIdeasOfUser(userId);
		return totalCount;
		
	}
	
	public UserDto updateUserEmail(String email,Long id) throws UserAlreadyExistsWithEmail
	{
		User user=userRepo.findByEmail(email);
		if(user.getUserId()!=id)
		{
			throw new UserAlreadyExistsWithEmail("Email Already Registered With A User");
		}
		userRepo.updateEmail(email,id);
		user=userRepo.findByUserId(id);
		UserDto userDto= new UserDto();
		userDto=UserMapper.convertUserToUserDto(user, userDto);
		return userDto;
		
	}
	public String updateUserPassword(String password,Long id) throws NoUserFoundException
	{
		User user=userRepo.findByUserId(id);
		if(user==null)
		{
			throw new NoUserFoundException("No User Found");
		}
		userRepo.updatePassword(password,id);
		return "Updated";
		
	}
	
	public String deleteUser(Long id)
	{
		userRepo.deleteByUserId(id);
		ResponseEntity<GlobalResponseDto> ideaResponse=ideaClient.deleteAllIdeaOfUser(id);
		System.out.println(ideaResponse.getBody().getMessage());
		return "Deleted User and Ideas";
	}
	
	

}
