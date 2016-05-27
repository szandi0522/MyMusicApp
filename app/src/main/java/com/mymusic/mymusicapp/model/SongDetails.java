package com.mymusic.mymusicapp.model;

import com.orm.SugarRecord;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mobsoft on 2016. 04. 18..
 */
public class SongDetails extends SugarRecord implements Serializable{

    @SerializedName("song_id")
    private Integer songId = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("artist")
    private String artist = null;

    @SerializedName("year")
    private Integer year = null;

    @SerializedName("album")
    private String album = null;

    @SerializedName("image")
    private String image = null;

    @SerializedName("youtube")
    private String youtube = null;

    public SongDetails(){
    }

    public SongDetails(String title, String artist, int year, String album, String imgUrl, String youtubeUrl) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.album = album;
        this.youtube = youtubeUrl;
        this.image = imgUrl;
    }

    /**
     **/
    //@ApiModelProperty(value = "")
    public Integer getSongId() {
        return songId;
    }
    public void setSongId(Integer songId) {
        this.songId = songId;
    }


    /**
     **/
    //@ApiModelProperty(value = "")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     **/
    //@ApiModelProperty(value = "")
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }


    /**
     **/
    //@ApiModelProperty(value = "")
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }


    /**
     **/
    //@ApiModelProperty(value = "")
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }


    /**
     **/
    //@ApiModelProperty(value = "")
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    /**
     **/
    //@ApiModelProperty(value = "")
    public String getYoutube() {
        return youtube;
    }
    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SongDetails songDetails = (SongDetails) o;
        return Objects.equals(songId, songDetails.songId) &&
                Objects.equals(title, songDetails.title) &&
                Objects.equals(artist, songDetails.artist) &&
                Objects.equals(year, songDetails.year) &&
                Objects.equals(album, songDetails.album) &&
                Objects.equals(image, songDetails.image) &&
                Objects.equals(youtube, songDetails.youtube);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, title, artist, year, album, image, youtube);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SongDetails {\n");

        sb.append("    songId: ").append(toIndentedString(songId)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    artist: ").append(toIndentedString(artist)).append("\n");
        sb.append("    year: ").append(toIndentedString(year)).append("\n");
        sb.append("    album: ").append(toIndentedString(album)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    youtube: ").append(toIndentedString(youtube)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
