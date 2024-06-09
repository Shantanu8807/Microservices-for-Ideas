package com.ideasservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideasservice.dto.GlobalResponseDto;
import com.ideasservice.dto.IdeasDto;
import com.ideasservice.dto.ResponseDto;
import com.ideasservice.dto.UserDto;
import com.ideasservice.exception.NoIdeasFound;
import com.ideasservice.exception.NoUserFoundException;
import com.ideasservice.service.IdeaService;

@RestController
@RequestMapping("/api/v1")
public class IdeasController {

	@Autowired
	private IdeaService ideaService;

	@GetMapping("/getAllIdeas")
	public ResponseEntity<ResponseDto> getAllIdeas(@RequestParam("userId") Long userId)
			throws NoIdeasFound, NoUserFoundException {
		List<IdeasDto> ideasDto = ideaService.getAllIdeasForUser(userId);

		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseDto(ideasDto, HttpStatus.OK.toString(), "Records Found", LocalDateTime.now()));
	}

	@PostMapping("/addIdea")
	public ResponseEntity<ResponseDto> createNewIdeaForUser(@RequestBody UserDto userDto,
			@RequestBody IdeasDto ideasDto) throws NoUserFoundException {
		IdeasDto idDto = ideaService.createNewIdeaForUser(userDto, ideasDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(List.of(idDto),
				HttpStatus.CREATED.toString(), "SuccessFully Saved", LocalDateTime.now()));

	}

	@PutMapping("/updateIdea")
	public ResponseEntity<ResponseDto> updateIdeaForUser(Long IdeaId, UserDto userDto, IdeasDto ideaDto)
			throws NoIdeasFound, NoUserFoundException {
		IdeasDto savedIdea = ideaService.updateIdeaForUser(IdeaId, userDto, ideaDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(List.of(savedIdea),
				HttpStatus.ACCEPTED.toString(), "SuccessFully Updated", LocalDateTime.now()));

	}

	@DeleteMapping("/deleteIdea")
	public ResponseEntity<ResponseDto> deleteIdea(Long ideaId, UserDto userDto)
			throws NoIdeasFound, NoUserFoundException {
		String response = ideaService.deleteIdea(ideaId, userDto);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseDto(null, HttpStatus.ACCEPTED.toString(), response, LocalDateTime.now()));
	}
	
	@DeleteMapping("/deleteAllIdeasOfUser")
	public ResponseEntity<GlobalResponseDto> deleteAllIdeaOfUser(Long userId) throws NoIdeasFound
			{
		String response = ideaService.deleteAllIdeaOfUser(userId);
		return ResponseEntity.status(HttpStatus.OK)
				.body(new GlobalResponseDto(HttpStatus.ACCEPTED.toString(), response, LocalDateTime.now()));
	}

}
