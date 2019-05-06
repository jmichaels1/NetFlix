package com.everis.d4i.tutorial.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.everis.d4i.tutorial.controllers.ActorRestController;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;
import com.everis.d4i.tutorial.services.ActorService;
import com.everis.d4i.tutorial.utils.constants.CommonConstants;

public class ActorRestControllerImpl implements ActorRestController {

	@Autowired
	private ActorService actorService;

	public NetflixResponse<List<ActorRest>> retrieveActors() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getAllActors());
	}

	public NetflixResponse<ActorRest> retrieveActor(final Long actorId) throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				actorService.getActor(actorId));
	}

	public NetflixResponse<List<ActorRest>> retrieveActorsByChapterAndSeason(final Long tvShowId, final Long seasonId,
			final Long chapterId) throws NetflixException {
		// TODO Auto-generated method stub
		return null;
	}

}
