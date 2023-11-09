package com.amitsoft.service;

import java.util.List;

import com.amitsoft.dto.UserDto;

public interface UserService {
	UserDto saveUser(UserDto userDto);

	UserDto updateUser(Integer userId, UserDto userDto);

	String deleteUser(Integer userId);

	UserDto getUserById(Integer id);

	List<UserDto> getAllUsers();
}
