package com.ideasservice.dto;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GlobalResponseDto {

	String statusCode;

	String message;

	LocalDateTime time;

}
