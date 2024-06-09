package com.userservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.dto.GlobalResponseDto;
import com.userservice.dto.ResponseDto;
import com.userservice.dto.UserDto;
import com.userservice.exception.UserAlreadyExistsWithEmail;
import com.userservice.model.User;
import com.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public ResponseEntity<ResponseDto> getAllUsers() {
		List<UserDto> list = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(new ResponseDto(list, HttpStatus.ACCEPTED.toString(), "Success", LocalDateTime.now()));
	}

	@GetMapping("/getUserById")
	public ResponseEntity<ResponseDto> getUserById(@RequestParam Long userId) {
		UserDto userDto = userService.findUserByUserId(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				new ResponseDto(List.of(userDto), HttpStatus.ACCEPTED.toString(), "Success", LocalDateTime.now()));
	}

	@PostMapping("/createUser")
	public ResponseEntity<GlobalResponseDto> createNewUser(@Valid @RequestBody User user)
			throws UserAlreadyExistsWithEmail {
		String email = user.getEmail();
		boolean check = userService.checkUserExistsWithEmail(email);
		if (!check) {
			user = userService.createNewUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(new GlobalResponseDto(HttpStatus.CREATED.toString(),
					"User Created Successfully", LocalDateTime.now()));
		} else {
			throw new UserAlreadyExistsWithEmail("User Already Exists With Email");
		}
	}

	@GetMapping("/getUserByEmail")
	public ResponseEntity<UserDto> getUserByEmail(String email) {
		UserDto userDto = userService.findUserByEmail(email);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDto);
	}

	@PostMapping("/incrementUserIdeasCount")
	public ResponseEntity<GlobalResponseDto> increaseIdeaTotalCount(Long userId) {
		int totalIdeas = userService.increaseIdeaTotalCount(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GlobalResponseDto(HttpStatus.ACCEPTED.toString(),
				"Total Ideas Now: " + totalIdeas, LocalDateTime.now()));
	}

	@PostMapping("/decrementUserIdeasCount")
	public ResponseEntity<GlobalResponseDto> decrementIdeaTotalCount(Long userId) {
		int totalIdeas = userService.decrementIdeaTotalCount(userId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GlobalResponseDto(HttpStatus.ACCEPTED.toString(),
				"Total Ideas Now: " + totalIdeas, LocalDateTime.now()));

	}

	@PutMapping("/updateEmail")
	public ResponseEntity<GlobalResponseDto> updateUserEmail(@RequestParam String email, @RequestParam Long id) {
		UserDto userDto = userService.updateUserEmail(email, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(
				new GlobalResponseDto(HttpStatus.ACCEPTED.toString(), "Updated Email " + email, LocalDateTime.now()));
	}

	@PutMapping("/updatePassword")
	public ResponseEntity<GlobalResponseDto> updateUserPassword(@RequestParam String password, @RequestParam Long id) {
		String response = userService.updateUserPassword(password, id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GlobalResponseDto(HttpStatus.ACCEPTED.toString(),
				"Updated Password Successfully", LocalDateTime.now()));
	}
	
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<GlobalResponseDto> deleteUser(@RequestParam Long id) {
		String response = userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new GlobalResponseDto(HttpStatus.ACCEPTED.toString(),
				"Updated Password Successfully", LocalDateTime.now()));
	}
	

}
