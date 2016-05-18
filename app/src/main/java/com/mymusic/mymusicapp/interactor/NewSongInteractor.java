package com.mymusic.mymusicapp.interactor;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;
import com.mymusic.mymusicapp.network.CreateApi;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by szandi0522 on 2016.04.19..
 */
public class NewSongInteractor {
    @Inject
    OrmDbModel model;

    @Inject
    CreateApi createApi;

    public NewSongInteractor() {
        MyMusicApplication.injector.inject(this);
    }

    public String addNewSongToDb(SongDetails song) {
        return model.addSong(song);
    }

    public String addNewSongByNetwork(SongDetails song) throws Exception {
        Response response = null;

        BigDecimal bd = new BigDecimal(song.getYear());
        Call<Void> call = createApi.addPost(song.getTitle(),song.getArtist(),bd,
                song.getAlbum(),song.getImage(),song.getYoutube());
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with add!");
        }

        return /*response.body()*/"Song was added successfully by network!";
    }
}
