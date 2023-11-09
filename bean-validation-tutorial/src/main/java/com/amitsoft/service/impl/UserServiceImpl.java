package com.amitsoft.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.amitsoft.dto.UserDto;
import com.amitsoft.entity.User;
import com.amitsoft.exception.UserNotFoundException;
import com.amitsoft.repository.UserRepository;
import com.amitsoft.service.UserService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private UserRepository userRepository;
	private ModelMapper modelMapper;
	@Override
	public UserDto saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = modelMapper.map(userDto, User.class);
		User saved = userRepository.save(user);
		return modelMapper.map(saved, UserDto.class);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		// TODO Auto-generated method stub
		UserDto dto = getUserById(userId);
		dto.setUserName(userDto.getUserName());
		dto.setPassword(userDto.getPassword());
		dto.setGender(userDto.getGender());
		dto.setAbout(userDto.getAbout());
		dto.setAge(userDto.getAge());
		dto.setMobile(userDto.getMobile());
		
		User user = modelMapper.map(dto, User.class);
		User updated = userRepository.save(user);
		return modelMapper.map(updated, UserDto.class);
	}

	@Override
	public String deleteUser(Integer userId) {
		UserDto userDto = getUserById(userId);
		User user = modelMapper.map(userDto, User.class);
		userRepository.delete(user);
		return "User Record Deleted Successfully";
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		List<UserDto> userDtos = allUsers.stream().map(user->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}

}
