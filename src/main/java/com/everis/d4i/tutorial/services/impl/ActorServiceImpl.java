package com.everis.d4i.tutorial.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.everis.d4i.tutorial.entities.Actor;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.repositories.ActorRepository;
import com.everis.d4i.tutorial.services.ActorService;

public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;

	private ModelMapper modelMapper =  new ModelMapper();

	public List<ActorRest> getAllActors() throws NetflixException {
		final List<Actor> actorsList = actorRepository.findAll();
		return !CollectionUtils.isEmpty(actorsList)
				? actorsList.stream().map(actor -> modelMapper.map(actor, ActorRest.class)).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public ActorRest getActor(final Long actorId) throws NetflixException {
		Actor actor = checkAndReturnActor(actorId);
		return modelMapper.map(actor, ActorRest.class);
	}

	private Actor checkAndReturnActor(final Long actorId) {
		Actor actor = actorRepository.findById(actorId).get();
		if (actor == null) {
			//TODO lanzar excepxión NOT FOUND
		}
		return actor;
	}
	
}
