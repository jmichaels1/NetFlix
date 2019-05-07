package com.everis.d4i.tutorial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.d4i.tutorial.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
	
	List<Actor> findByTvShow_IdAndSeason_IdAndChapter_Id(Long tvShowId, Long chapterId, Long seasonId);
}
