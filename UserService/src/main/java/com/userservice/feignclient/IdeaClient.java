package com.userservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.userservice.dto.GlobalResponseDto;

@FeignClient(value="idea")
public interface IdeaClient {
	
	
	@DeleteMapping("/deleteAllIdeasOfUser")
	public ResponseEntity<GlobalResponseDto> deleteAllIdeaOfUser(Long userId);

}
