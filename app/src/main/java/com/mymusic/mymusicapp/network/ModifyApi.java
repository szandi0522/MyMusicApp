package com.mymusic.mymusicapp.network;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ModifyApi {
  
  /**
   * Modifies the details of the selected song.
   * With the id of the selected song we can send the modified data to the server.
   * @param id The id of the song.
   * @param title Title of the song.
   * @param artist The artist of the song.
   * @param year The release year of the song.
   * @param album The title of the album.
   * @param image The image url of the album.
   * @param youtube The youtube url of the album.
   * @return Call<Void>
   */
  
  @PUT("modify")
  Call<Void> modifyPut(
    @Query("id") BigDecimal id, @Query("title") String title, @Query("artist") String artist, @Query("year") BigDecimal year, @Query("album") String album, @Query("image") String image, @Query("youtube") String youtube
  );

  
}
