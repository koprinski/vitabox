package com.omisoft.vitafu.utils.di;

import com.google.inject.AbstractModule;
//import com.omisoft.vitafu.akkaGuiceTest.SayHello;
//import com.omisoft.vitafu.akkaGuiceTest.SayHelloImpl;
//import com.omisoft.vitafu.akkaGuiceTest.ServiceThatUsesActor;
//import com.omisoft.vitafu.akkaGuiceTest.ServiceThatUsesActorImpl;
import com.omisoft.vitafu.dao.radio.RadioDAO;
import com.omisoft.vitafu.dao.radio.RadioDAOImpl;
import com.omisoft.vitafu.dao.radio.RadioDataReloadDatabaseService;
import com.omisoft.vitafu.dao.radio.RadioDataReloadDatabaseServiceImpl;
import com.omisoft.vitafu.mapping.ModelMapper;
import com.omisoft.vitafu.mapping.ModelMapperImpl;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.dao.movies.MovieDAOHttpImpl;
import com.omisoft.vitafu.mapping.ModelMapperRadio;
import com.omisoft.vitafu.mapping.ModelMapperRadioImpl;
import com.omisoft.vitafu.opensubtitlesapi.api.OpenSubtitles;
import com.omisoft.vitafu.opensubtitlesapi.impl.OpenSubtitlesImpl;
import com.omisoft.vitafu.services.*;

/**
 * Created by dido on 10/16/14.
 */

public class DependencyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MovieDAO.class).to(MovieDAOHttpImpl.class);
        bind(ModelMapper.class).to(ModelMapperImpl.class);
        bind(CacheService.class).to(CacheServiceImpl.class);
        bind(TmdbHttpService.class).to(TmdbHttpServiceImpl.class);
//        bind(OpenSubtitles.class).to(OpenSubtitlesImpl.class);

        bind(RadioDAO.class).to(RadioDAOImpl.class);
        bind(RadioDataReloadDatabaseService.class).to(RadioDataReloadDatabaseServiceImpl.class);
        bind(ModelMapperRadio.class).to(ModelMapperRadioImpl.class);
    }
}
