package com.example.demo.dto;

import java.math.BigDecimal;


import com.example.demo.modele.TransactionType;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
private long id;
@Positive
@Max(value = 100000000)
@Min(value=10)
private BigDecimal amount;
private TransactionType type;
private String destinationIban;
private long userid;

}
