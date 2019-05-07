package com.everis.d4i.tutorial.controllers;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;
import com.everis.d4i.tutorial.responses.NetflixResponse;

public interface ActorRestController {

	NetflixResponse<List<ActorRest>> retrieveActors() throws NetflixException;;

	NetflixResponse<ActorRest> retrieveActor(Long actorId) throws NetflixException;;

	NetflixResponse<List<ActorRest>> retrieveActorsByTvShowAndSeasonAndChapter(Long tvShowId, Long seasonId, Long chapterId) throws NetflixException;
	
}
