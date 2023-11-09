package com.amitsoft.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amitsoft.dto.UserDto;
import com.amitsoft.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
  private UserService userService;
  @PostMapping
  public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto ){
	  return new ResponseEntity<UserDto>(userService.saveUser(userDto),HttpStatus.CREATED);
  }
  @PutMapping("{id}")
  public ResponseEntity<UserDto> updateUser(@PathVariable Integer id,@Valid @RequestBody UserDto userDto){
	  return new ResponseEntity<UserDto>(userService.updateUser(id, userDto),HttpStatus.ACCEPTED);
  }
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Integer id){
	  return new ResponseEntity<String>(userService.deleteUser(id),HttpStatus.OK);
  }
  @GetMapping("{id}")
  public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
	  return new ResponseEntity<UserDto>(userService.getUserById(id),HttpStatus.OK);
  }
  @GetMapping
  public ResponseEntity<List<UserDto>> getAllUser(){
	  return new ResponseEntity<List<UserDto>>(this.userService.getAllUsers(),HttpStatus.OK);
  }
}
