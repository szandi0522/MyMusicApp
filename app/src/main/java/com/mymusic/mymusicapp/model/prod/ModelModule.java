package com.mymusic.mymusicapp.model.prod;

import com.mymusic.mymusicapp.model.SongDetails;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Module
public class ModelModule {
    @Provides
    public OrmDbModel getOrmDbModel() {
        return new OrmDbModel();
    }
}