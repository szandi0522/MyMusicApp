package com.mymusic.mymusicapp.interactor;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by szandi0522 on 2016.04.19..
 */
public class NewSongInteractor {
    @Inject
    OrmDbModel model;

    public NewSongInteractor() {
        MyMusicApplication.injector.inject(this);
    }

    public String addNewSong(List<SongDetails> newSong){
        return "";
    }
}
