package com.mymusic.mymusicapp.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Module
public class ModelModule {
    @Provides
    public SongDetails getSongDetailsModel() {
        return new SongDetails();
    }
}
