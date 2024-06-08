package com.userservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.userservice.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
       
	
	private List<User> list;
	private String status;
	private String message;
	private LocalDateTime time;
}
