package com.jone.uploadfile.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jone.uploadfile.dto.PicDTO;
import com.jone.uploadfile.dto.PicResponse;
import com.jone.uploadfile.entity.Picture;
import com.jone.uploadfile.repository.PicRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PicService {

	private final PicRepository picRepository;
	public void save(PicDTO picDTO) {
		Picture p = new Picture();
		p.setName(picDTO.getName());
		p.setImage(saveImage(picDTO.getFile()));
		picRepository.save(p);
	}
	
	private static final Path path = Paths.get("images");
	public String saveImage(MultipartFile multipartFile){
		try {
			if(!Files.exists(path)) {
				Files.createDirectories(path);
			}
			Path target = path.resolve(multipartFile.getOriginalFilename());
			multipartFile.transferTo(target);
		} catch (IOException e) {
			// TODO: handle exception
		}
		return multipartFile.getOriginalFilename();
	}
	
	public List<PicResponse> get() {
		List<Picture> pics = picRepository.findAll();
		List<PicResponse> result = new ArrayList<>();
		for(Picture item : pics) {
			PicResponse p = new PicResponse();
			p.setName(item.getName());
			p.setImageUrl(item.getImage());
			result.add(p);
		}
		return result;
	}
}
