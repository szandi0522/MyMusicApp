package com.mymusic.mymusicapp.presenter;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.interactor.MainInteractor;
import com.mymusic.mymusicapp.view.MainScreen;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    public MainInteractor interactor;

    public MainPresenter() {
        MyMusicApplication.injector.inject(this);
    }

//    public void doStuff() {
//        view.showString(interactor.getString());
//    }
}

