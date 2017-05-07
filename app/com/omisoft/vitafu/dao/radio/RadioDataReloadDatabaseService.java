package com.omisoft.vitafu.dao.radio;

import com.omisoft.vitafu.dto.RadioDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by nslavov on 2/3/15.
 * Get json object from dirble.com
 *
 */
public interface RadioDataReloadDatabaseService {

    /**
     * Find radios by category from dirble.com
     * @param idCategory
     * @return List<RadioDTO>
     */
    public List<RadioDTO> findRadioByIdCategory(final String idCategory);

    /**
     * Find radio category by id from dirble.com
     * @param id
     * @return List<RadioCategories>
     */
    public List<RadioCategories> getRadioCategories(int id);

    /**
     * Get all radios
     * @return Map<String,List<RadioDTO>>
     */
    public Map<String,List<RadioDTO>> getAllRadioStations();

}
