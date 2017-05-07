package com.omisoft.vitafu.mapping;

import com.omisoft.vitafu.dto.RadioDTO;
import com.omisoft.vitafu.entity.Radio;

import java.util.List;
import java.util.Map;

/**
 * Created by nslavov on 1/29/15.
 */
public interface ModelMapperRadio {


    /**
     * Maps Radio to RadioDTO
     * @param radio
     * @return
     */
    List<RadioDTO> mapRadioDTO(final List<Radio> radio);


    /**
     * Maps RadioDTO to Radio
     * @param map
     * @return
     */
    List<Radio> mapRadioDtoToRadio(final Map<String, List<RadioDTO>> map);
}
