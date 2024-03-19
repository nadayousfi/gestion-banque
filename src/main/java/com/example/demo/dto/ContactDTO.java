package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
	 long id;
	 String name;
	 String lastname;
	 String email;
	 String iban;
	 Long userid;

}