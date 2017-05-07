package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nslavov on 2/13/15.
 */
public class AllRadioNavigation extends Controller {
    private static List<NavigationLinks> allRadioNavigation;

    static{
        if (allRadioNavigation == null){
            allRadioNavigation = new ArrayList<NavigationLinks>();
            allRadioNavigation.add(new NavigationLinks("#/music/local-radio","Local Radio"));
            allRadioNavigation.add(new NavigationLinks("#/music/classical","Classical"));
            allRadioNavigation.add(new NavigationLinks("#/music/country","Country"));
            allRadioNavigation.add(new NavigationLinks("#/music/decades","Decades"));
            allRadioNavigation.add(new NavigationLinks("#/music/electronic","Electronic"));
            allRadioNavigation.add(new NavigationLinks("#/music/folk","Folk"));
            allRadioNavigation.add(new NavigationLinks("#/music/international","International"));
            allRadioNavigation.add(new NavigationLinks("#/music/jazz","Jazz"));
            allRadioNavigation.add(new NavigationLinks("#/music/misc","Misc"));
            allRadioNavigation.add(new NavigationLinks("#/music/pop","Pop"));
            allRadioNavigation.add(new NavigationLinks("#/music/R&B-Urban","R&B/Urban"));
            allRadioNavigation.add(new NavigationLinks("#/music/rap","Rap"));
            allRadioNavigation.add(new NavigationLinks("#/music/reggae","Reggae"));
            allRadioNavigation.add(new NavigationLinks("#/music/rock","Rock"));
            allRadioNavigation.add(new NavigationLinks("#/music/Talk-Speech","Talk & Speech"));

            //http://api.dirble.com/v1/categories/apikey/e9da52d5566f493c03e83c9f5e6d8f3f28f81851

        }

    }

   public static Result allRadioNavigation(){

       return ok(Json.toJson(allRadioNavigation));

   }

}
