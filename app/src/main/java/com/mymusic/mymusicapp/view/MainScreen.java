package com.mymusic.mymusicapp.view;

import com.mymusic.mymusicapp.model.SongDetails;

import java.util.List;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public interface MainScreen {

    public void showList(String s);
    public void showSearchResult(List<SongDetails> resultList);
    public void navigateToNewSongPage();

}
