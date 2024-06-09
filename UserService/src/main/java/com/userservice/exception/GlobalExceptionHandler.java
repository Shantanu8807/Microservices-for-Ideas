package com.userservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.userservice.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(NoUsersPresentCurrently.class)
	public ResponseEntity<ErrorResponseDto> noUsersPresentCurrentlyHandler(WebRequest webrequest,Exception ex)
	{
		ErrorResponseDto   errorResponseDto= new ErrorResponseDto();
		errorResponseDto.setErrorMessage(ex.getLocalizedMessage());
		errorResponseDto.setStatus(HttpStatus.NOT_FOUND.toString());
		errorResponseDto.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
		
	}
	
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<ErrorResponseDto> NoUserFoundExceptionHandler(WebRequest webrequest,Exception ex)
	{
		ErrorResponseDto   errorResponseDto= new ErrorResponseDto();
		errorResponseDto.setErrorMessage(ex.getLocalizedMessage());
		errorResponseDto.setStatus(HttpStatus.NOT_FOUND.toString());
		errorResponseDto.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
		
	}
	
	@ExceptionHandler(UserAlreadyExistsWithEmail.class)
	public ResponseEntity<ErrorResponseDto> UserAlreadyExistsWithEmailHandler(WebRequest webrequest,Exception ex)
	{
		ErrorResponseDto   errorResponseDto= new ErrorResponseDto();
		errorResponseDto.setErrorMessage(ex.getLocalizedMessage());
		errorResponseDto.setStatus(HttpStatus.NOT_FOUND.toString());
		errorResponseDto.setTime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDto);
		
	}


}
