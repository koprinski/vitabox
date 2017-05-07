package controllers;

import com.google.inject.Inject;
import com.omisoft.vitafu.dao.radio.RadioDAO;
import com.omisoft.vitafu.entity.Radio;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


/**
 * Created by nslavov on 2/6/15.
 * Find radio by category from database
 */
public class GetRadiosFromDatabase extends Controller {

    @Inject
    private RadioDAO radioDAO;

    /**
     * Find radio by category from database
     * @param category
     * @return json
     */
    public Result getRadiosFromDatabase(String category) {

        List<Radio> radioList = radioDAO.findRadioByCategory(category);


        //System.out.println(Json.toJson(radioList));
        return ok(Json.toJson(radioList));

    }

}
