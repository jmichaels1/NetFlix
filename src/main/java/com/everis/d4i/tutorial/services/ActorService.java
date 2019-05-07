package com.everis.d4i.tutorial.services;

import java.util.List;

import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.json.ActorRest;

public interface ActorService {
	
	List<ActorRest> getAllActors() throws NetflixException;
	
	ActorRest getActor(Long actorId) throws NetflixException;

	List<ActorRest> getActorsByTvShowAndSeasonAndChapter(Long tvShowId, Long chapterId, Long seasonId) throws NetflixException;

}
