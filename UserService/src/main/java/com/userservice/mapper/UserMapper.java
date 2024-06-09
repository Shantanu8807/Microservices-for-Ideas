package com.userservice.mapper;

import java.util.List;

import com.userservice.dto.UserDto;
import com.userservice.model.User;

public class UserMapper {

	public static UserDto convertUserToUserDto(User user, UserDto userDto) {
		userDto.setCreatedDateTime(user.getCreatedDateTime());
		userDto.setEmail(user.getEmail());
		userDto.setTotalIdeas(user.getTotalIdeas());
		userDto.setUserId(user.getUserId());
		userDto.setUsername(user.getUsername());
		return userDto;
	}

	public static User convertUserDtoToUser(User user, UserDto userDto) {
		user.setCreatedDateTime(userDto.getCreatedDateTime());
		user.setEmail(userDto.getEmail());
		user.setTotalIdeas(userDto.getTotalIdeas());
		user.setUserId(userDto.getUserId());
		user.setUsername(userDto.getUsername());
		return user;
	}

	public static List<UserDto> convertUserToUserDto(List<User> user, List<UserDto> userDto) {
		for (User u : user) {
			UserDto udto = new UserDto();
			udto.setCreatedDateTime(u.getCreatedDateTime());
			udto.setEmail(u.getEmail());
			udto.setTotalIdeas(u.getTotalIdeas());
			udto.setUserId(u.getUserId());
			udto.setUsername(u.getUsername());
			userDto.add(udto);
		}

		return userDto;
	}

}
