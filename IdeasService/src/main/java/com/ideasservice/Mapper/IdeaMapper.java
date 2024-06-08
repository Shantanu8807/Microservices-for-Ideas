package com.ideasservice.Mapper;

import java.util.List;

import com.ideasservice.dto.IdeasDto;
import com.ideasservice.dto.UserDto;
import com.ideasservice.model.Idea;

public class IdeaMapper {

	public static List<IdeasDto> ConvertIdeaToIdeasDto(List<Idea> idea, List<IdeasDto> ideaDto) {
		for (Idea ida : idea) {
			IdeasDto iddto = new IdeasDto();
			iddto.setCreatedDateTime(ida.getCreatedDateTime());
			iddto.setDecription(ida.getDecription());
			iddto.setIdeaTitle(ida.getIdeaTitle());
			iddto.setSources(ida.getSources());
			iddto.setStatus(ida.getStatus());
			iddto.setTopicsIcluded(ida.getTopicsIcluded());
			ideaDto.add(iddto);
		}

		return ideaDto;
	}

	public static Idea ConvertIdeaDtoToIdea(IdeasDto ideaDto, UserDto userDto, Idea idea) {

		idea.setCreatedDateTime(ideaDto.getCreatedDateTime());
		idea.setDecription(ideaDto.getDecription());
		idea.setIdeaTitle(ideaDto.getIdeaTitle());
		idea.setSources(ideaDto.getSources());
		idea.setStatus(ideaDto.getStatus());
		idea.setTopicsIcluded(ideaDto.getTopicsIcluded());
		idea.setUserId(userDto.getUserId());
		idea.setUserDto(userDto);

		return idea;

	}

	public static IdeasDto ConvertIdeaToIdeasDto(Idea idea, IdeasDto ideasDto) {

		ideasDto.setCreatedDateTime(idea.getCreatedDateTime());
		ideasDto.setDecription(idea.getDecription());
		ideasDto.setIdeaTitle(idea.getIdeaTitle());
		ideasDto.setSources(idea.getSources());
		ideasDto.setStatus(idea.getStatus());
		ideasDto.setTopicsIcluded(idea.getTopicsIcluded());
		return ideasDto;
	}

}