package com.example.demo.exception;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
@Component
public class ObjectValidator <T>{
	private final ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
	public final Validator validator=factory.getValidator();
	public void validate(T objectToValidate) {
	Set<ConstraintViolation<T>> violation=validator.validate(objectToValidate);
	if(!violation.isEmpty()) {
		Set<String> errorMessages=violation.stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.toSet());
		throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
		
	}
}
}
