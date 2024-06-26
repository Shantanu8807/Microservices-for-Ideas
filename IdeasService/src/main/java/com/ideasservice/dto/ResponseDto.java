package com.ideasservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class ResponseDto{

	List<IdeasDto> list;
	
	String statusCode;

	String message;

	LocalDateTime time;

}
