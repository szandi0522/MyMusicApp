package com.mymusic.mymusicapp.model.mock;

import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by szandi0522 on 2016.04.28..
 */
public class MockDbModel extends OrmDbModel {
    LinkedList<SongDetails> values = new LinkedList<>();

    public MockDbModel() {
        values.add(new SongDetails("Hello","Adele",2015, "","",""));
        values.add(new SongDetails("Broken Arrows","AVICII",2016, "","",""));
        values.add(new SongDetails("Stevie Knows","OLLY MURS",2016, "","",""));
        values.add(new SongDetails("No","MEGHAN TRAINOR",2016, "","",""));
    }

    @Override
    public List<SongDetails> listSongDetails(String text) {
        List<SongDetails> result = new ArrayList<SongDetails>();
        if(text.equals("") ){
            result = values;
        }else {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(i).getArtist().toLowerCase().contains(text.toLowerCase()) || values.get(i).getTitle().toLowerCase().contains(text.toLowerCase())) {
                    result.add(values.get(i));
                }
            }
        }
        return result;
    }

}
