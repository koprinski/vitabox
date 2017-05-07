package com.omisoft.vitafu.actors;

import akka.actor.UntypedActor;
import com.google.inject.Inject;
import com.omisoft.vitafu.services.CacheService;
import com.omisoft.vitafu.utils.plugins.akkaGuice.annotations.Schedule;
import play.Logger;

import java.util.concurrent.TimeUnit;

@Schedule(initialDelay = 1, timeUnit = TimeUnit.DAYS, interval = 1)
public class MovieSchedulerActor extends UntypedActor {

	@Inject
	private CacheService service;

	@Override
	public void onReceive(Object arg0) throws Exception {

		Logger.info("Movie Scheduler - daily update !");

		service.movieCache();
		service.updateMoviesInfoInDB();
	}
}