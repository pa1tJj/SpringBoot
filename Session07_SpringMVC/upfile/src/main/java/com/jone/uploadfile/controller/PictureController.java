package com.jone.uploadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jone.uploadfile.dto.PicDTO;
import com.jone.uploadfile.entity.Picture;
import com.jone.uploadfile.service.PicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PictureController {

	private final PicService picService;
	@GetMapping("/picture")
	public String getPicture(Model model) {
		model.addAttribute("result", picService.get());
		return "picture";
	}
	
	@GetMapping("/up")
	public String getUpfile(Model model) {
		model.addAttribute("pic", new PicDTO());
		return "upfile";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute PicDTO picDTO) {
		picService.save(picDTO);
		return "redirect:/picture";
	}
}
