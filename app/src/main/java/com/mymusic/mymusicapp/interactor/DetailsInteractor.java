package com.mymusic.mymusicapp.interactor;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.model.prod.OrmDbModel;
import com.mymusic.mymusicapp.network.DeleteApi;
import com.mymusic.mymusicapp.network.ModifyApi;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by szandi0522 on 2016.04.19..
 */
public class DetailsInteractor {
    @Inject
    OrmDbModel model;

    @Inject
    DeleteApi deleteApi;

    @Inject
    ModifyApi modifyApi;

    public DetailsInteractor() {
        MyMusicApplication.injector.inject(this);
    }

    public String modifyList(List<SongDetails> modifiedList){
        return "";
    }

    public String modifyListItem(SongDetails song) {
        return model.modifyListItem(song);
    }

    public String modifyListItemByNetwork(SongDetails song) throws Exception {
        Response response = null;

        BigDecimal bdyear = new BigDecimal(song.getYear());
        BigDecimal bdid = new BigDecimal(song.getSongId());
        Call<Void> call = modifyApi.modifyPut(bdid,song.getTitle(),song.getArtist(),bdyear,
                song.getAlbum(),song.getImage(),song.getYoutube());
        try {
             response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return "Songlist was modified!";
    }

    public String deleteListItem(int id) {
        return model.deleteSong(id);
    }
    public String deleteListItem(long id) {
        return model.deleteSong(id);
    }

    public String deleteListItemByNetwork(int id) throws Exception {
        Response response = null;

        BigDecimal bd = new BigDecimal(id);
        Call<Void> call = deleteApi.deleteDelete(bd);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return "Songlist was deleted!";
    }

    public String deleteListItemByNetwork(long id) throws Exception {
        Response response = null;

        BigDecimal bd = new BigDecimal(id);
        Call<Void> call = deleteApi.deleteDelete(bd);
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }

        return "Songlist was deleted!";
    }
}
