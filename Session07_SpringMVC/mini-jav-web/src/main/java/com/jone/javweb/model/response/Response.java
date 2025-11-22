package com.jone.javweb.model.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Response<T> {

	private List<T> list = new ArrayList<>();
	private int total;
}
