package com.mymusic.mymusicapp.interactor;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;
import com.mymusic.mymusicapp.network.SearchApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class MainInteractor {
    @Inject
    OrmDbModel model;

    @Inject
    SearchApi searchApi;

    public MainInteractor() {
        MyMusicApplication.injector.inject(this);
    }

    public String getTitle() {
        return ""/*model.getTitle()*/;
    }

    public List<SongDetails> getSongListFromDb(String text) {
        return model.listSongDetails(text);
    }

    public List<SongDetails> getSongListFromNetwork(String text) throws Exception {
        Response<List<SongDetails>> response = null;

        Call<List<SongDetails>> call = searchApi.searchGet(text);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return response.body();
    }
}
