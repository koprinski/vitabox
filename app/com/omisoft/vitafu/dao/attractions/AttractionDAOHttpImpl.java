package com.omisoft.vitafu.dao.attractions;

import com.omisoft.vitafu.dao.base.BaseDAOImpl;
import com.omisoft.vitafu.entity.Attraction;

import java.util.List;

/**
 * Created by dido on 10/16/14.
 * Currentlly loads from  web. Results should be persisted so that we can limit bandwidth
 */
public class AttractionDAOHttpImpl extends BaseDAOImpl<Attraction> implements AttractionDAO {


    public AttractionDAOHttpImpl() {
        super(Attraction.class);
    }
}