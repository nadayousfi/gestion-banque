package com.example.demo.dto;

import java.time.LocalDateTime;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private long id;
	@NotNull
	@NotBlank
	@NotEmpty
private String name;
	@NotNull
	@NotBlank
	@NotEmpty
private String lastname;
private String email;
@Size(min = 8,max = 16)

private String password;
@Past
private LocalDateTime birthday;

}
