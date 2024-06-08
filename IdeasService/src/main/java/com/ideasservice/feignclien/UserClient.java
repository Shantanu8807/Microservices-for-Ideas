package com.ideasservice.feignclien;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ideasservice.dto.UserDto;

@FeignClient(name="user")
public interface UserClient {
	
	
	@GetMapping("/getUser")
	public ResponseEntity<UserDto> getUserByEmail(String email);
	
	@PostMapping("/incrementUserIdeasCount")
	public ResponseEntity<String> increaseIdeaTotalCount(Long userId);
	
	@PostMapping("/decrementUserIdeasCount")
	public ResponseEntity<String> decrementIdeaTotalCount(Long userId);

}
