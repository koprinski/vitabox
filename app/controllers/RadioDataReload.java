package controllers;

import com.google.inject.Inject;
import com.omisoft.vitafu.dao.radio.RadioDAO;
import com.omisoft.vitafu.dao.radio.RadioDataReloadDatabaseService;
import com.omisoft.vitafu.dto.RadioDTO;
import com.omisoft.vitafu.entity.Radio;
import com.omisoft.vitafu.mapping.ModelMapperRadio;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by nslavov on 1/29/15.
 * Get all radios from dirble.com and save in database
 */
public class RadioDataReload extends Controller {

    @Inject
    private RadioDAO radioDAO;

    @Inject
    private ModelMapperRadio modelMapperRadio;

    @Inject
    private RadioDataReloadDatabaseService radioDataReloadDatabaseService;


    /**
     * Get all radio from dirble.com and map database
     * @return json
     */
    public Result getAllRadioStations(){

        Map<String ,List<RadioDTO>> map = radioDataReloadDatabaseService.getAllRadioStations();
        List<Radio> radioList = modelMapperRadio.mapRadioDtoToRadio(map);
        radioDAO.saveAll(radioList);

        return ok(Json.toJson(radioList));

    }

}
