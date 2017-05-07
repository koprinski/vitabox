package controllers;

import akka.actor.ActorRef;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.services.HttpService;
import com.omisoft.vitafu.services.TmdbHttpService;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
    @Inject
    private MovieDAO movieDAO;

    public  Result index() {
//        movieDAO.findAll();
        return ok(index.render());
    }

}
