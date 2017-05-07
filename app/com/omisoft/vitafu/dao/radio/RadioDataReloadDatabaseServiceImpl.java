package com.omisoft.vitafu.dao.radio;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.omisoft.vitafu.dao.APIKeys;
import com.omisoft.vitafu.dto.RadioDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.*;

/**
 * Created by nslavov on 1/28/15.
 *Implementation class RadioDataReloadDatabaseService
 */
public class RadioDataReloadDatabaseServiceImpl implements RadioDataReloadDatabaseService {

    private CloseableHttpClient httpClient;
    private String responseBody;
    private List<RadioDTO> radioDTOList ;
    private List<RadioCategories> radioCategoriesList;
    private BasicResponseHandler response;
    private HttpGet httpGet;
    private Gson gson;
    private JsonParser parser;
    private JsonArray jsonArray;

    /**
     * Find radios by category from dirble.com
     * @param idCategory
     * @return List<RadioDTO>
     */
    @Override
    public List<RadioDTO> findRadioByIdCategory(String idCategory) {

         httpClient = HttpClients.createDefault();
         radioDTOList = new ArrayList<>();
         gson = new Gson();
         parser = new JsonParser();

        try {

            httpGet = new HttpGet(RadioApi.BASE_URL+RadioApi.STATIONS+RadioApi.API_KEY+ "/" + APIKeys.THERADIO_API_KEY+RadioApi.ID+ "/" + idCategory );
            response = new BasicResponseHandler();

            try {
                responseBody = httpClient.execute(httpGet, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } finally {

            try {

                if(httpClient != null){

                    httpClient.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

             jsonArray = parser.parse(responseBody).getAsJsonArray();

            for(JsonElement jsonElement : jsonArray )
            {
                RadioDTO  radioDTO = gson.fromJson( jsonElement , RadioDTO.class);
                if(StringUtils.isNotEmpty(radioDTO.getStreamurl()) && !"0".equals(radioDTO.getStatus())){

                    radioDTOList.add(radioDTO);

                }

            }

        }
        return radioDTOList;
    }


    /**
     * Find radio category by id from dirble.com
     * @param id
     * @return List<RadioCategories>
     */
    @Override
    public List<RadioCategories> getRadioCategories(int id) {

        httpClient = HttpClients.createDefault();
        radioCategoriesList = new ArrayList<RadioCategories>();
        gson = new Gson();
        parser = new JsonParser();

        try {

            if(id == 0){
                httpGet = new HttpGet(RadioApi.BASE_URL+RadioApi.PRIMARY_CATEGORIES + RadioApi.API_KEY + "/" + APIKeys.THERADIO_API_KEY);
            } else {
                httpGet = new HttpGet(RadioApi.BASE_URL+ RadioApi.CHILD_CATEGORIES + RadioApi.API_KEY +"/" + APIKeys.THERADIO_API_KEY + RadioApi.PRIMARY_ID+ "/" + id );
            }

            response = new BasicResponseHandler();

            try {
                responseBody = httpClient.execute(httpGet, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } finally {
            try {

                if(httpClient != null){

                    httpClient.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            jsonArray = parser.parse(responseBody).getAsJsonArray();

            for(JsonElement jsonElement : jsonArray )
            {
                RadioCategories radioCategories = gson.fromJson( jsonElement , RadioCategories.class);
                if(StringUtils.isNotEmpty(radioCategories.getName())){
                    radioCategoriesList.add(radioCategories);

                }

            }

        }

        return radioCategoriesList;
    }

    /**
     * Get all radios
     * @return Map<String,List<RadioDTO>>
     */
    @Override
    public Map<String,List<RadioDTO>> getAllRadioStations() {

        Map<String,List<RadioDTO>> mapFromListDto = new HashMap<String,List<RadioDTO>>();
        List<RadioCategories> radioCategoriesList1 = getRadioCategories(0);

        for(int i = 0; i<radioCategoriesList1.size(); i++){
            List<RadioDTO> radioDTOListBuffer = new ArrayList<RadioDTO>();
            List<RadioCategories> radioCategoriesListBuffer = getRadioCategories(Integer.parseInt(radioCategoriesList1.get(i).getId().toString()));

                for (int j = 0; j < radioCategoriesListBuffer.size(); j++) {
                    radioDTOListBuffer.addAll(findRadioByIdCategory(radioCategoriesListBuffer.get(j).getId().toString()));
                }

            Set<RadioDTO> radioDTOSet = new LinkedHashSet<RadioDTO>();
            radioDTOSet.addAll(radioDTOListBuffer);
            radioDTOListBuffer.clear();
            radioDTOListBuffer.addAll(radioDTOSet);
            mapFromListDto.put(radioCategoriesList1.get(i).getName(), radioDTOListBuffer);

        }

        return mapFromListDto;
    }

}
