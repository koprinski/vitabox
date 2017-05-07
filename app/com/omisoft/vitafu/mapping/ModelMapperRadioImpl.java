package com.omisoft.vitafu.mapping;

import com.omisoft.vitafu.dto.RadioDTO;
import com.omisoft.vitafu.entity.Radio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nslavov on 1/29/15.
 */
public class ModelMapperRadioImpl implements ModelMapperRadio {


    /**
     * Maps Radio to RadioDTO
     * @param radioList
     * @return dtoList
     */
    @Override
    public List<RadioDTO> mapRadioDTO(List<Radio> radioList) {

        List<RadioDTO> dtoList = new ArrayList<>();

        for (Radio radio : radioList) {

            if(radio.getId() != null) {
                RadioDTO dto = new RadioDTO(radio.getName(),radio.getStreamurl(),radio.getCategory(),radio.getCountry(),radio.getBitrate(),radio.getWebsite(),radio.getStatus());
                dtoList.add(dto);
            }
        }

        return dtoList;

    }

    /**
     * Maps radioDto to radio
     * @param map
     * @return radioList
     */
    @Override
    public List<Radio> mapRadioDtoToRadio(Map<String, List<RadioDTO>> map) {

        Radio radio = new Radio();
        List<Radio> radioList=new ArrayList<Radio>();

        for(String categories : map.keySet()){
            for(RadioDTO radioDTO : map.get(categories) ){
                radio = new Radio(radioDTO.getName(),radioDTO.getStreamurl(),categories,radioDTO.getCountry(),radioDTO.getBitrate(),radioDTO.getWebsite(),radioDTO.getStatus());
                radioList.add(radio);

            }

        }
        return radioList;
    }

}
