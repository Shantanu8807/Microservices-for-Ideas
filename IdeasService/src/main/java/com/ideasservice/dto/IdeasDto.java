package com.ideasservice.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IdeasDto {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	private String ideaTitle;

	private String decription;

	private String sources;

	private String topicsIcluded;

	private String status;

	private LocalDateTime createdDateTime;

}
