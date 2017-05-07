package com.omisoft.vitafu.dao.radio;

import com.avaje.ebean.Ebean;
import com.omisoft.vitafu.dao.base.BaseDAOImpl;
import com.omisoft.vitafu.entity.Radio;

import java.util.List;

/**
 * Created by nslavov on 2/3/15.
 */
public class RadioDAOImpl extends BaseDAOImpl<Radio> implements RadioDAO {
    /**
     * Constructor
     * @param type
     */
    public RadioDAOImpl(Class<Radio> type) {
        super(type);
    }

    public RadioDAOImpl(){
        this(Radio.class);
    }

    /**
     * Finds the radios by Category
     * @param category
     * @return list of radios
     */
    @Override
    public List<Radio> findRadioByCategory(String category) {

        List<Radio> radioList = Ebean.find(Radio.class).where().eq("category",category).findList();

        return radioList;
    }

    /**
     * Finds the radios by country
     * @param country
     * @return list of radios
     */
    @Override
    public List<Radio> findRadioByCountry(String country) {

        List<Radio> radioList =Ebean.find(Radio.class).where().eq("country",country).findList();

        return radioList;
    }
}
