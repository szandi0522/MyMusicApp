package com.mymusic.mymusicapp;

import com.mymusic.mymusicapp.interactor.InteractorModule;
import com.mymusic.mymusicapp.model.mock.MockModelModule;
import com.mymusic.mymusicapp.model.prod.ModelModule;
import com.mymusic.mymusicapp.network.mock.MockNetworkModule;
import com.mymusic.mymusicapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mobsoft on 2016. 05. 02..
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, MockModelModule.class,MockNetworkModule.class})
public interface MockMyMusicApplicationComponent extends MyMusicApplicationComponent{
}
