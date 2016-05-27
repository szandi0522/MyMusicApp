package com.mymusic.mymusicapp;

import android.content.Context;

import com.mymusic.mymusicapp.model.prod.ModelModule;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;
import com.mymusic.mymusicapp.presenter.DetailsPresenter;
import com.mymusic.mymusicapp.presenter.MainPresenter;
import com.mymusic.mymusicapp.presenter.NewSongPresenter;
import com.mymusic.mymusicapp.view.ViewModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by szandi0522 on 2016.05.14..
 */
@Module
public class TestModul {

    private final ViewModule viewModule;
    private final ModelModule modelModule;

    public TestModul(Context context) {

        this.viewModule = new ViewModule(context);
        this.modelModule = new ModelModule();
    }

    @Provides
    public Context provideContext() {
        return viewModule.provideContext();
    }

    @Provides
    public OrmDbModel provideLoginPresenter() {
        return modelModule.getOrmDbModel();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return viewModule.getMainPresenter();
    }

    @Provides
    public DetailsPresenter provideDetailsPresenter() {
        return viewModule.getDetailsPresenter();
    }
    @Provides
    public NewSongPresenter provideNewSongPresenter() {
        return viewModule.getNewSongPresenter();
    }


}
