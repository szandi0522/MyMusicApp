package com.mymusic.mymusicapp.model.mock;

import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by szandi0522 on 2016.04.28..
 */
public class MockDbModel extends OrmDbModel {
    LinkedList<SongDetails> values = new LinkedList<>();

    public MockDbModel() {
        values.add(new SongDetails("Hello","Adele",2015, "","",""));
        values.add(new SongDetails("mock","MockArtist",2011, "","",""));
    }

    @Override
    public List<SongDetails> listSongDetails() {
        return values;
    }

}
