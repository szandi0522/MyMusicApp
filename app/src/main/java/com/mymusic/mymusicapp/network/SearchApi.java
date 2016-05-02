package com.mymusic.mymusicapp.network;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.mymusic.mymusicapp.model.SongDetails;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchApi {
  
  /**
   * Search by artist or  by title
   * The user can search in the song list by the name of the artist or by the title of the song.
   * @param searchtext The name of the artist or the title of the song.
   * @return Call<List<SongDetails>>
   */
  
  @GET("search")
  Call<List<SongDetails>> searchGet(
    @Query("searchtext") String searchtext
  );

  
}
