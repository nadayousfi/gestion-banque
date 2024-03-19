package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdresseDTO {
 Long id;
 String street;
 Integer housenumber;
 String city;
 String country;
 Long userid;

}
