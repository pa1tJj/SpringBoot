package com.jone.javweb.service;

import org.springframework.stereotype.Service;

import com.jone.javweb.converter.Converter;
import com.jone.javweb.model.dto.ActorDTO;
import com.jone.javweb.model.entity.Actor;
import com.jone.javweb.model.entity.Auth;
import com.jone.javweb.repository.ActorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActorService {

	private final ActorRepository actorRepository;
	private final Converter converter;
	
	public void save(Actor actor) {
		actorRepository.save(actor);
	}
}
