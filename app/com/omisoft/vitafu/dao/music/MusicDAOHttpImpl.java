package com.omisoft.vitafu.dao.music;

import com.omisoft.vitafu.dao.base.BaseDAOImpl;
import com.omisoft.vitafu.entity.Music;

import java.util.List;

/**
 * Created by dido on 10/16/14.
 * Currentlly loads from  web. Results should be persisted so that we can limit bandwidth
 */
public class MusicDAOHttpImpl extends BaseDAOImpl<Music> implements MusicDAO {


    public MusicDAOHttpImpl() {
        super(Music.class);
    }
}