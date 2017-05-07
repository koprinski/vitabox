package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dido on 11/3/14.
 */
public class Navigation extends Controller {
    private static List<NavigationLinks> mainNavigation;

    static {
        if (mainNavigation == null) {
            mainNavigation = new ArrayList<NavigationLinks>();
            mainNavigation.add(new NavigationLinks("#tv", "TV"));
            mainNavigation.add(new NavigationLinks("#/movies/popular", "Movies"));
            mainNavigation.add(new NavigationLinks("#music/classical", "Music"));
            mainNavigation.add(new NavigationLinks("#explore", "Explore Now"));
            mainNavigation.add(new NavigationLinks("#hotelinfo", "Hotel Info"));
            mainNavigation.add(new NavigationLinks("#social", "Social"));
            mainNavigation.add(new NavigationLinks("#/player/playMovie?movieId=1", "Video Player Test"));


        }
    }

    public static Result mainNavigation() {


        return ok(Json.toJson(mainNavigation));
    }

}
