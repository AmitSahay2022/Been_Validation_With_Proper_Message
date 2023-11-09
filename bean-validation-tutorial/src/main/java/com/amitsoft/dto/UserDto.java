package com.amitsoft.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {	
	private Integer userId;
	@NotBlank(message = "User name is mandatory")
	private String userName;
	@NotBlank(message = "Please provide Password")
	private String password;
	@NotEmpty(message = "write something or just empty space")
	private String about;
	@NotBlank(message = "Mobile number is must")
	@Pattern(regexp = "^\\d{10}$",message = "must be 10 character. allowed characters are 0,1,2,3,4,5,6,7,8,9")
	private String mobile;
	@Min(18)
	@Max(80)	
	private int age;
	@NotBlank(message = "Male or Female or Trans")
	private String gender;
}
