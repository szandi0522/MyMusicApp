package com.mymusic.mymusicapp.model;

import com.orm.SugarRecord;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class SongDetails extends SugarRecord {

    String title;
    String artist;
    int year;
    String album;
    String youtubeUrl;
    String imgUrl;

    public SongDetails(){
    }

    public SongDetails(String title, String artist, int year, String album, String youtubeUrl, String imgUrl) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.youtubeUrl = youtubeUrl;
        this.imgUrl = imgUrl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public String getSearchResult(String searchText){
        return searchText;
    }
}
