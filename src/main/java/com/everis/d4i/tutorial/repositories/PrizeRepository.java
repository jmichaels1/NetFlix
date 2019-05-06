package com.everis.d4i.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.d4i.tutorial.entities.Prize;

public interface PrizeRepository extends JpaRepository<Prize, Long> {

}
