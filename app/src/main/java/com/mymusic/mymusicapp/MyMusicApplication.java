package com.mymusic.mymusicapp;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.mymusic.mymusicapp.view.ViewModule;
import com.mymusic.mymusicapp.BuildConfig;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import io.fabric.sdk.android.Fabric;


/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class MyMusicApplication extends Application{

    public static MyMusicApplicationComponent injector;

    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

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

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
