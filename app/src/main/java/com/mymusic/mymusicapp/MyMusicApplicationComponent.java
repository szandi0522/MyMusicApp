package com.mymusic.mymusicapp;

import com.mymusic.mymusicapp.interactor.DetailsInteractor;
import com.mymusic.mymusicapp.interactor.InteractorModule;
import com.mymusic.mymusicapp.interactor.MainInteractor;
import com.mymusic.mymusicapp.interactor.NewSongInteractor;
import com.mymusic.mymusicapp.model.ModelModule;
import com.mymusic.mymusicapp.presenter.DetailsPresenter;
import com.mymusic.mymusicapp.presenter.MainPresenter;
import com.mymusic.mymusicapp.presenter.NewSongPresenter;
import com.mymusic.mymusicapp.view.DetailsActivity;
import com.mymusic.mymusicapp.view.MainActivity;
import com.mymusic.mymusicapp.view.NewSongActivity;
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

    void inject(MainInteractor mainInteractor);

    void inject(DetailsActivity detActivity);

    void inject(DetailsPresenter detPresenter);

    void inject(DetailsInteractor detInteractor);

    void inject(NewSongActivity newSongActivity);

    void inject(NewSongPresenter newSongPresenter);

    void inject(NewSongInteractor newSongInteractor);
}
