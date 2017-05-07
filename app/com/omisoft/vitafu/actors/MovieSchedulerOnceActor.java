package com.omisoft.vitafu.actors;

import akka.actor.UntypedActor;

import com.google.inject.Inject;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.utils.plugins.akkaGuice.annotations.ScheduleOnce;
import com.omisoft.vitafu.services.CacheService;
import play.Logger;

import java.util.List;

@ScheduleOnce()
public class MovieSchedulerOnceActor extends UntypedActor {

	@Inject
	private CacheService service;

	@Inject
	private MovieDAO movieDAO;

	@Override
	public void onReceive(Object arg0) throws Exception {
		Logger.info("Movie SchedulerOnce working !");

		List<Movie> movieListDB = movieDAO.selectMoviesFromDB();

		if (movieListDB.size() > 1) {
			service.cacheMovieFromDB(movieListDB);
		}
		else {
			service.movieCache();
			service.saveMoviesInfoInDB();
		}

	}
}