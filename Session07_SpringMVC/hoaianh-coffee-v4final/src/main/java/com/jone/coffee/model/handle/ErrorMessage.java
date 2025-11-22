package com.jone.coffee.model.handle;

import java.util.List;

import lombok.Data;

@Data
public class ErrorMessage {

	private String error;
	private List<String> details;
}
