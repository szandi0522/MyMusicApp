package com.mymusic.mymusicapp.interactor;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.model.SongDetails;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class MainInteractor {
    @Inject
    SongDetails model;

    public MainInteractor() {
        MyMusicApplication.injector.inject(this);
    }

    public String getTitle() {
        return model.getTitle();
    }
}
