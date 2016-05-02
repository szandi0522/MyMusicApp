package com.mymusic.mymusicapp;

import android.app.Application;

import com.mymusic.mymusicapp.view.ViewModule;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class MyMusicApplication extends Application{

    public static MyMusicApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMyMusicApplicationComponent.builder().viewModule(new ViewModule(this)).build();
    }

    public void setInjector(MyMusicApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
    }
}
