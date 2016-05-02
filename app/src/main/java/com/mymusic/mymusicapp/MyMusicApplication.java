package com.mymusic.mymusicapp;

import android.app.Application;

import com.mymusic.mymusicapp.view.ViewModule;
import com.mymusic.mymusicapp.BuildConfig;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class MyMusicApplication extends Application{

    public static MyMusicApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.FLAVOR.equals("mock")) {
            injector = DaggerMockMyMusicApplicationComponent.builder().viewModule(new ViewModule(this)).build();
        } else {
            injector = DaggerMyMusicApplicationComponent.builder().viewModule(new ViewModule(this)).build();
        }

    }

    public void setInjector(MyMusicApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
    }
}
