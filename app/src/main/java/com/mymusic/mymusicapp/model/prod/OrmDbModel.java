package com.mymusic.mymusicapp.model.prod;

import com.mymusic.mymusicapp.model.SongDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szandi0522 on 2016.04.28..
 */
public class OrmDbModel {

    List<SongDetails> songList;

    public OrmDbModel(){}

    public List<SongDetails> listSongDetails(String text) {
        List<SongDetails> values = new ArrayList<SongDetails>();
        if(text == "") {
            values = SongDetails.listAll(SongDetails.class);
        }else{
            values = SongDetails.find(SongDetails.class, "title = ? or artist = ?", text, text);
        }
        return values;
    }
    public String addSong(SongDetails song){
        song.save();
        return "Song was added to the db!";
    }

    public String deleteSong(int id){
        SongDetails song = SongDetails.findById(SongDetails.class, id);
        song.delete();
        return "Song was deleted from the db!";
    }

    public String modifyListItem(SongDetails song){
        SongDetails updatedSong = SongDetails.findById(SongDetails.class, song.getId());
        updatedSong = song;
        updatedSong.save();

        return "Song was modified in the db!";
    }

}

