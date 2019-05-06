package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepository tvShowRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TvShowRest> getTvShowsByCategory(final Long categoryId) throws NetflixException {
		return tvShowRepository.findByCategoryList_id(categoryId).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowRest.class)).collect(Collectors.toList());
	}

	@Override
	public TvShowRest getTvShowById(final Long id) throws NetflixException {
		try {
			return modelMapper.map(tvShowRepository.getOne(id), TvShowRest.class);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}
	}

	@Override
	public TvShowRest createTvShow(final TvShowRest tvShowRest) throws NetflixException {
		return saveTvShow(checkAndMapTvShow(tvShowRest));
	}

	private TvShow checkAndMapTvShow(final TvShowRest tvShowRest) { 
		checkTvShow(tvShowRest.getName());
		return mapTvShow(tvShowRest);
	}

	private TvShow mapTvShow(TvShowRest tvShowRest) {
		return modelMapper.map(tvShowRest, TvShow.class);
	}

	private void checkTvShow(String tvShowName) {
		if (tvShowRepository.findByName(tvShowName) != null) {
			//LANZAR EXCEPTION DUPLICATE
		}
	}

	private TvShowRest saveTvShow(final TvShow tvShow) {
		try {
			tvShowRepository.save(tvShow);
		} catch (final Exception e) {
			// TODO: Internal exception
		}
		return modelMapper.map(tvShow, TvShowRest.class);
	}
}
