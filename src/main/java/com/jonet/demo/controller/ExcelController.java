package com.jonet.demo.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jonet.demo.service.BatchService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/excel")
@RequiredArgsConstructor
public class ExcelController {
	private final BatchService batchService;
	@PostMapping
	public ResponseEntity<?> importExcel(@RequestParam("file") MultipartFile multipartFile) {
		batchService.importExcel(multipartFile);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<?> exportExcel(HttpServletResponse response, @RequestParam("id") UUID id) {
		batchService.exportExcel(response, "data", id);
		return ResponseEntity.ok("success");
	}
}
