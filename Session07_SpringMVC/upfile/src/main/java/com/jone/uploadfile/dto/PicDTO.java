package com.jone.uploadfile.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PicDTO {

	private Long id;
	private String name;
	private MultipartFile file;
}
