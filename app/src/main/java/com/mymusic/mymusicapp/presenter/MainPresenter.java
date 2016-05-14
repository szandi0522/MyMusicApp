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

    public void search(String searchText) {

        try {
            view.showSearchResult(interactor.getSongListFromNetwork(searchText));
        } catch (Exception e) {
            view.showSearchResult(interactor.getSongListFromDb(searchText));
            //view.showMessage(e.getMessage());
        }

    }

//    public void search(String searchText){
//        view.showSearchResult(interactor.getList(searchText));
//    }
    public void refreshList(){
        try {
            view.showSearchResult(interactor.getSongListFromNetwork(""));
        } catch (Exception e) {
            view.showSearchResult(interactor.getSongListFromDb(""));
            //view.showMessage(e.getMessage());
        }
    }

    public void navigatoToAddNewPage(){
        view.navigateToNewSongPage();
    }

}

