package com.jone.javweb.config;

import jakarta.validation.Payload;

public @interface FileNotEmpty {

	String message() default "Vui lòng chọn file";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
