package com.github.chandanv89.hateoasexample.model;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Greeting
 * 
 * @author chandanv89
 *
 */
public class Greeting extends RepresentationModel<Greeting>{
	@JsonProperty
	private String message;

	@JsonCreator
	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
