package com.omisoft.vitafu.dao.radio;

import com.omisoft.vitafu.dao.base.BaseDAO;
import com.omisoft.vitafu.entity.Radio;

import java.util.List;

/**
 * Created by nslavov on 1/28/15.
 */
public interface RadioDAO extends BaseDAO<Radio> {

    /**
     * Finds the radios by Category
     * @param Category
     * @return list of radios
     */
    public List<Radio> findRadioByCategory(final String Category);

    /**
     * Finds the radios by country
     * @param country
     * @return list of radios
     */
    public List<Radio> findRadioByCountry(final String country);
}
