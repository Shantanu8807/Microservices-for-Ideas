package com.ideasservice.model;

import java.time.LocalDateTime;

import com.ideasservice.dto.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Idea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long userId;

	private UserDto userDto;

	private String ideaTitle;

	private String decription;

	private String sources;

	private String topicsIcluded;

	private String status;

	private LocalDateTime createdDateTime;

}
