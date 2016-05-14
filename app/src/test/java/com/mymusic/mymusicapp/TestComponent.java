package com.mymusic.mymusicapp;

import com.mymusic.mymusicapp.interactor.InteractorModule;
import com.mymusic.mymusicapp.network.mock.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModul.class, InteractorModule.class})
public interface TestComponent extends MyMusicApplicationComponent {
}