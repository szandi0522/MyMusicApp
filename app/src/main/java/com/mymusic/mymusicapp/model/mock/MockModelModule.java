package com.mymusic.mymusicapp.model.mock;

import com.mymusic.mymusicapp.model.prod.OrmDbModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 05. 02..
 */
@Module
public class MockModelModule {

    @Provides
    public OrmDbModel provideMockDbModel() {
        return new MockDbModel();
    }
}
