package com.mymusic.mymusicapp.interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Module
public class InteractorModule {
    @Provides
    public MainInteractor getStringInteractor() {
        return new MainInteractor();
    }
}
