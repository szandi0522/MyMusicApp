package com.mymusic.mymusicapp.interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Module
public class InteractorModule {
    @Provides
    public MainInteractor getMainInteractor() {
        return new MainInteractor();
    }

    @Provides
    public DetailsInteractor getDetailsInteractor() {
        return new DetailsInteractor();
    }

    @Provides
    public NewSongInteractor getNewSongInteractor() {return new NewSongInteractor();
    }
}
