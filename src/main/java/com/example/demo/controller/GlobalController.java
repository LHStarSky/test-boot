package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalController {
	private final Logger LOGGER = LoggerFactory.getLogger(GlobalController.class);

	@ExceptionHandler(value = Exception.class)
	public String globalException() {
		LOGGER.info("globalException run ->>");
		return "globalException error.";
	}
}
