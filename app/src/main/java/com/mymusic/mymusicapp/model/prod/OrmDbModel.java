package com.mymusic.mymusicapp.model.prod;

import com.mymusic.mymusicapp.model.SongDetails;

import java.util.List;

/**
 * Created by szandi0522 on 2016.04.28..
 */
public class OrmDbModel {

    List<SongDetails> songList;

    public OrmDbModel(){}

    public List<SongDetails> listSongDetails() {
        List<SongDetails> values = SongDetails.listAll(SongDetails.class);
        return values;
    }

}
