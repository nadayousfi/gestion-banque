package com.example.demo.exception;

import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {
	
	@Getter
	private final Set<String> violation;
	@Getter
	
	private final String violationSource;

}
