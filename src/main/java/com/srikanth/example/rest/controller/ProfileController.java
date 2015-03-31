package com.srikanth.example.rest.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sample/{name}")
public class ProfileController {

	@RequestMapping(value = "/{age}", method = RequestMethod.GET)
	public ResponseEntity<String> getAge(@PathVariable String name,
			@PathVariable String age) {
		log.debug("getAge method called : ");

		String response = "Hello " + name + " Your Age is " + age;

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}