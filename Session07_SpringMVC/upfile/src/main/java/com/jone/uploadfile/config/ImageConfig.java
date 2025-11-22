package com.jone.uploadfile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// ánh xạ đường dẫn /images/** tới thư mục ngoài project
		registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
		// "file:images/" nghĩa là lấy thư mục "images" ngay cạnh thư mục src/
	}
}
