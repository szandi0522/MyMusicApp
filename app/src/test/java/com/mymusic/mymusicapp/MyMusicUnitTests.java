package com.mymusic.mymusicapp;

import com.mymusic.mymusicapp.interactor.DetailsInteractor;
import com.mymusic.mymusicapp.interactor.MainInteractor;
import com.mymusic.mymusicapp.interactor.NewSongInteractor;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.network.mock.SongListMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;
import static org.junit.Assert.*;
import static com.mymusic.mymusicapp.TestHelper.setTestInjector;

import javax.inject.Inject;
/**
 * Created by szandi0522 on 2016.05.14..
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MyMusicUnitTests {
    @Inject
    public MainInteractor mainInteractor;
    @Inject
    public DetailsInteractor detailsInteractor;
    @Inject
    public NewSongInteractor addInteractor;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainInteractor = new MainInteractor();
        detailsInteractor = new DetailsInteractor();
        addInteractor = new NewSongInteractor();
    }

    @Test
    public void getterTest() throws Exception {
        String title ="Hello";
        String artist = "Adele";
        int year = 2015;
        String album = "Album";
        String img = "ImgUrl";
        String youtube = "YoutubeUrl";

        SongDetails s = new SongDetails(title,artist,year,album,img,youtube);
        assertEquals(s.getTitle().equals(title), true);
        assertEquals(s.getArtist().equals(artist), true);
        assertEquals(s.getAlbum().equals(album), true);
        assertEquals(s.getYear().equals(year), true);
        assertEquals(s.getImage().equals(img), true);
        assertEquals(s.getYoutube().equals(youtube), true);
    }

    @Test
    public void mockGetAllSongListTest() throws Exception {
        SongListMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals(s.size(),3);

            assertEquals(s.get(0), SongListMock.testS1);
            assertEquals(s.get(1), SongListMock.testS2);
            assertEquals(s.get(2), SongListMock.testS3);
        }
    }
    @Test
    public void mockSearchWithNoResultTest() throws Exception {
        SongListMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            String searchText = "aky";
            List<SongDetails> s = mainInteractor.getSongListFromNetwork(searchText);

            assertEquals(s.size(),0);
        }
    }

    @Test
    public void mockSearchWithResultTest() throws Exception {
        SongListMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            String searchText = "stop";
            List<SongDetails> s = mainInteractor.getSongListFromNetwork(searchText);

            assertEquals(s.size(),1);
            assertEquals(s.get(0), SongListMock.testS2);
        }
    }
    @Test
    public void mockAddNewSongTest() throws Exception {
        SongListMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            SongDetails song = new SongDetails("Hello","Adele",2015,"Album","","");
            String m = addInteractor.addNewSongByNetwork(song);
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals("Song was added successfully by network!", m);
            assertEquals(s.size(), 4);
            assertEquals(s.get(0).getTitle(), song.getTitle());
            assertEquals(s.get(0).getArtist(), song.getArtist());
            assertEquals(s.get(0).getYear(), song.getYear());
            assertEquals(s.get(0).getAlbum(), song.getAlbum());
            assertEquals(s.get(0).getImage(), song.getImage());
            assertEquals(s.get(0).getYoutube(), song.getYoutube());
            assertEquals(s.get(1), SongListMock.testS1);
            assertEquals(s.get(2), SongListMock.testS2);
            assertEquals(s.get(3), SongListMock.testS3);

        }
    }
    @Test
    public void mockModifySongTest() throws Exception {
        SongListMock.resetList();
        SongListMock.initList();
        if (BuildConfig.FLAVOR == "mock") {
            SongDetails song = SongListMock.testS2;
            song.setYear(2011);
            String m = detailsInteractor.modifyListItemByNetwork(song);
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals("Songlist was modified!", m);
            assertEquals(s.get(1).getYear(), song.getYear());
        }
    }
    @Test(expected = Exception.class)
    public void mockModifyWrongSongTest() throws Exception {
        SongListMock.resetList();
        SongListMock.initList();
        if (BuildConfig.FLAVOR == "mock") {
            SongDetails song = new SongDetails("Test","Artist",2011,"Album","","");
            song.setSongId(-1);
            String m = detailsInteractor.modifyListItemByNetwork(song);
            assertEquals("Network error with modify!", m);
        }
    }
    @Test
    public void mockDeleteSongTest() throws Exception {
        SongListMock.resetList();
        SongListMock.initList();
        if (BuildConfig.FLAVOR == "mock") {
            SongDetails song = SongListMock.testS2;
            String m = detailsInteractor.deleteListItemByNetwork(song.getSongId());
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals("Songlist was deleted!", m);
            assertEquals(s.size(), 2);
            assertNotNull(SongListMock.testS2);
        }
    }

    @Test(expected = Exception.class)
    public void mockDeleteWrongSongTest() throws Exception {
        SongListMock.resetList();
        SongListMock.initList();
        if (BuildConfig.FLAVOR == "mock") {
            int id = -1;
            String m = detailsInteractor.deleteListItemByNetwork(id);
            assertEquals("Network error with delete!", m);
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals(s.size(), 3);
        }
    }
}
