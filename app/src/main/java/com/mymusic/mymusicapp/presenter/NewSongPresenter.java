package com.mymusic.mymusicapp.presenter;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.interactor.DetailsInteractor;
import com.mymusic.mymusicapp.interactor.NewSongInteractor;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.view.DetailsScreen;
import com.mymusic.mymusicapp.view.NewSongScreen;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class NewSongPresenter extends Presenter<NewSongScreen>{

    @Inject
    public NewSongInteractor interactor;

    public NewSongPresenter() {
        MyMusicApplication.injector.inject(this);
    }

    public void addNewSong(List<SongDetails> newSong){
        view.showMessageToast(interactor.addNewSong(newSong));
    }

}
