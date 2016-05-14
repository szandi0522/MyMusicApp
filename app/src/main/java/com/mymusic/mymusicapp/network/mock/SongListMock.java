package com.mymusic.mymusicapp.network.mock;

import android.net.Uri;

import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.network.NetworkConfig;
import com.mymusic.mymusicapp.network.GsonHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;


public class SongListMock {

    static List<SongDetails> songList = new ArrayList<>();
    static boolean isInitialised = false;

    public static SongDetails testP1 = new SongDetails("Test1", "Test1", 2011, "", "", "");
    public static SongDetails testP2 = new SongDetails("Test2", "Test2", 2015, "", "", "");
    public static SongDetails testP3 = new SongDetails("Test3", "Test3", 2014, "", "", "");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode = 200;
        Headers headers = request.headers();

        if (uri.getPath().contains(NetworkConfig.ENDPOINT_PREFIX + "search") && request.method().equals("GET")) {
            String text = "";
            text = uri.getQueryParameter("searchtext");

            if (!isInitialised) {
                songList.add(testP1);
                testP1.setSongId((int) (Math.random() * 100));
                songList.add(testP2);
                testP2.setSongId((int) (Math.random() * 100));
                songList.add(testP3);
                testP3.setSongId((int) (Math.random() * 100));
                isInitialised = true;
            }
            if (text.equals("")) {
                responseString = GsonHelper.getGson().toJson(songList);
                responseCode = 200;
            } else {
                List<SongDetails> result = new ArrayList<SongDetails>();
                for (int i = 0; i < songList.size(); i++) {
                    if (songList.get(i).getArtist().toLowerCase().contains(text.toLowerCase()) || songList.get(i).getTitle().toLowerCase().contains(text.toLowerCase())) {
                        result.add(songList.get(i));
                    }
                }
                responseString = GsonHelper.getGson().toJson(result);
                responseCode = 200;
            }


        } else if (uri.getPath().contains(NetworkConfig.ENDPOINT_PREFIX + "add") && request.method().equals("POST")) {
            String title = uri.getQueryParameter("title");
            String artist = uri.getQueryParameter("artist");
            String year = uri.getQueryParameter("year");
            String album = uri.getQueryParameter("album");
            String image = uri.getQueryParameter("image");
            String youtube = uri.getQueryParameter("youtube");

            SongDetails test = new SongDetails(title, artist, Integer.parseInt(year), album, image, youtube);
            test.setSongId((int) (Math.random() * 100));
            songList.add(test);

            responseString = "";
            responseCode = 200;

        } else if (uri.getPath().contains(NetworkConfig.ENDPOINT_PREFIX + "modify") && request.method().equals("PUT")) {
            String id = uri.getQueryParameter("id");
            String title = uri.getQueryParameter("title");
            String artist = uri.getQueryParameter("artist");
            String year = uri.getQueryParameter("year");
            String album = uri.getQueryParameter("album");
            String image = uri.getQueryParameter("image");
            String youtube = uri.getQueryParameter("youtube");

            for (int i = 0; i < songList.size(); i++) {
                if (songList.get(i).getSongId().equals(Integer.parseInt(id))) {
                    songList.get(i).setTitle(title);
                    songList.get(i).setArtist(artist);
                    songList.get(i).setYear(Integer.parseInt(year));
                    songList.get(i).setAlbum(album);
                    songList.get(i).setImage(image);
                    songList.get(i).setYoutube(youtube);

                    responseString = "";
                    responseCode = 200;
                } else {
                    responseString = "";
                    responseCode = 503;
                }
            }
        } else if (uri.getPath().contains(NetworkConfig.ENDPOINT_PREFIX + "delete") && request.method().equals("DELETE")) {
            String id = uri.getQueryParameter("id");

            int size = songList.size();
            for (int i = (size - 1); i >= 0; i--) {
                if (songList.get(i).getSongId() == Integer.parseInt(id)) {
                    songList.remove(i);
                    responseString = "";
                    responseCode = 200;

                }
            }
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        songList.clear();
        isInitialised = false;
    }
}
