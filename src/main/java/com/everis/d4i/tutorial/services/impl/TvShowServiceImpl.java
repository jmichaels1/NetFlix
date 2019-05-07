package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.Optional;
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

	public List<TvShowRest> getTvShowsByCategory(final Long categoryId) throws NetflixException {
		return tvShowRepository.findByCategoryList_id(categoryId).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowRest.class)).collect(Collectors.toList());
	}

	public TvShowRest getTvShowById(final Long id) throws NetflixException {
		try {
			return modelMapper.map(tvShowRepository.getOne(id), TvShowRest.class);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}
	}

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
			// LANZAR EXCEPTION DUPLICATE
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

	public TvShowRest updateTvShow(final Long tvShowId, final TvShowRest tvShow) throws NetflixException {
		checkTvShowIds(tvShowId, tvShow);
		checkAndReturnTvShow(tvShow);
		
		return null;
	}

	private void checkTvShowIds(final Long tvShowId, final TvShowRest tvShow) {
		if (!tvShowId.equals(tvShow.getId())) {
			// TODO lanzar excepción sobre los Id's (badRequest?)
		}
	}

	private TvShow checkAndReturnTvShow(final TvShowRest tvShow) {
		final TvShow TvShowInDb = tvShowRepository.findById(tvShow.getId()).get();
		if (TvShowInDb == null) {
			// TODO lanzar excepción que no existe el objecto en db
		}
		return TvShowInDb;
	}

}
