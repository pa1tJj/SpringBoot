package com.jone.javweb.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("/com.jone.javweb")
public class ModerMapperConfig {

	@Bean
	public ModelMapper get() {
		return new ModelMapper();
	}
}
