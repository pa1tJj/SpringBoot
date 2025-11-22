package com.jone.coffee.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ErrorMessage {

	private String error;
	private List<String> detail = new ArrayList<>();
}
