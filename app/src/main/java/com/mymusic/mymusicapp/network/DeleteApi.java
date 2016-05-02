package com.mymusic.mymusicapp.network;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DeleteApi {
  
  /**
   * Deletes the selected song from the list.
   * With the id of the song we could delete the selected song from the list.
   * @param id The id of the song.
   * @return Call<Void>
   */
  
  @DELETE("delete")
  Call<Void> deleteDelete(
    @Query("id") BigDecimal id
  );

  
}
