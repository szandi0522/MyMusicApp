package com.mymusic.mymusicapp;

import android.content.Context;

import com.mymusic.mymusicapp.model.prod.ModelModule;
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
/*
    @Provides
    public PeopleDbModel provideLoginPresenter() {
        return modelModule.providePeopleDbModel();
    }

    @Provides
    public MainPresenter provideMainPresenter() {
        return viewModule.provideMainPresenter();
    }
    */
}
