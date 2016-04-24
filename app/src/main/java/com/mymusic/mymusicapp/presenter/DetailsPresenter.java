package com.mymusic.mymusicapp.presenter;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.interactor.DetailsInteractor;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.view.DetailsScreen;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class DetailsPresenter extends Presenter<DetailsScreen>{

    @Inject
    public DetailsInteractor interactor;

    public DetailsPresenter() {
        MyMusicApplication.injector.inject(this);
    }

    public void modify(List<SongDetails> modifiedList){
        view.showModifyMessage(interactor.modifyList(modifiedList));
    }

    public void delete(int id){
        view.showDeleteMessage(interactor.deleteListItem(id));
    }
}
