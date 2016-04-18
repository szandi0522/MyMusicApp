package com.mymusic.mymusicapp;

import com.mymusic.mymusicapp.interactor.InteractorModule;
import com.mymusic.mymusicapp.interactor.MainInteractor;
import com.mymusic.mymusicapp.model.ModelModule;
import com.mymusic.mymusicapp.presenter.MainPresenter;
import com.mymusic.mymusicapp.view.MainActivity;
import com.mymusic.mymusicapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class})
public interface MyMusicApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(MainInteractor stringInteractor);
}
