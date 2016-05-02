package com.mymusic.mymusicapp.network;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CreateApi {
  
  /**
   * Add new song to the list
   * The user can add a new song to the list. In the request we can send the details of the new song item.
   * @param title Title of the song.
   * @param artist The artist of the song.
   * @param year The release year of the song.
   * @param album The title of the album.
   * @param image The image url of the album.
   * @param youtube The youtube url of the album.
   * @return Call<Void>
   */
  
  @POST("add")
  Call<Void> addPost(
    @Query("title") String title, @Query("artist") String artist, @Query("year") BigDecimal year, @Query("album") String album, @Query("image") String image, @Query("youtube") String youtube
  );

  
}
