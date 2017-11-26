package com.bedirhanatasoy.springboot.auth.utils;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class RestMessage {

	private String message;

	public RestMessage(String message) {
		this.message = message;
	}
}
