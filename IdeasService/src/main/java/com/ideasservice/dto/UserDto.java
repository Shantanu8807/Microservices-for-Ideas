package com.ideasservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long userId;

	private String username;

	private String email;

	private String contact;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private int TotalIdeas;

}
