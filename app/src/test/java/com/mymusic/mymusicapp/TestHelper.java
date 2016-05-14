package com.mymusic.mymusicapp;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by szandi0522 on 2016.05.14..
 */
public class TestHelper {

    public static void setTestInjector() {
        MyMusicApplication application = (MyMusicApplication)RuntimeEnvironment.application;
        MyMusicApplicationComponent injector = DaggerTestComponent.builder().testModul(new TestModul(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}
