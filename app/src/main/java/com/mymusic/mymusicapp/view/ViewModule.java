package com.mymusic.mymusicapp.view;

import android.content.Context;

import com.mymusic.mymusicapp.presenter.DetailsPresenter;
import com.mymusic.mymusicapp.presenter.MainPresenter;
import com.mymusic.mymusicapp.presenter.NewSongPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {
    private Context context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter getMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter getDetailsPresenter() {
        return new DetailsPresenter();
    }

    @Provides
    @Singleton
    public NewSongPresenter getNewSongPresenter() {
        return new NewSongPresenter();
    }
}
