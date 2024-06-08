package com.ideasservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ideasservice.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(NoIdeasFound.class)
	public ResponseEntity<ErrorResponseDto> noIdeasFoundExceptionHandler(WebRequest webRequest,Exception ex)
	{
		ErrorResponseDto errResponseDto= new ErrorResponseDto();
		errResponseDto.setErrorCode(HttpStatus.NOT_FOUND.toString());
		errResponseDto.setErrorMessage(webRequest.getDescription(true)+" ,  "+ex.getMessage());
		errResponseDto.setDatetime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errResponseDto);
		
	}
	
	
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<ErrorResponseDto> noUserFoundExceptionHandler(WebRequest webRequest,Exception ex)
	{
		ErrorResponseDto errResponseDto= new ErrorResponseDto();
		errResponseDto.setErrorCode(HttpStatus.NOT_FOUND.toString());
		errResponseDto.setErrorMessage(webRequest.getDescription(true)+" ,  "+ex.getMessage());
		errResponseDto.setDatetime(LocalDateTime.now());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errResponseDto);
	}

}