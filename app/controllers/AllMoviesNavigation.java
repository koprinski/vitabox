package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bkoprinski on 14-12-5.
 */
public class AllMoviesNavigation extends Controller {
    private static List<NavigationLinks> allMoviesNavigation;

    static {
        if (allMoviesNavigation == null) {
            allMoviesNavigation = new ArrayList<NavigationLinks>();
            allMoviesNavigation.add(new NavigationLinks("#/movies/popular", "Popular Movies"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/upcoming", "Upcoming"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/top-rated", "Top Rated"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/now-playing", "Now Playing"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/action", "Action"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/comedy", "Comedy"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/drama", "Drama"));
            allMoviesNavigation.add(new NavigationLinks("#/movies/fantasy", "Fantasy"));
        }
    }

    public static Result allMoviesNavigation() {
        return ok(Json.toJson(allMoviesNavigation));
    }
}
