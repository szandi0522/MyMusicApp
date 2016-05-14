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
    public void mockGetSongListTest() throws Exception {
        SongListMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals(s.get(0).getTitle(), SongListMock.testP1.getTitle());
            assertEquals(s.get(1).getTitle(), SongListMock.testP2.getTitle());
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
            assertEquals(s.get(0).getTitle(), song.getTitle());
        }
    }
    @Test
    public void mockModifySongTest() throws Exception {
        SongListMock.resetList();
        SongListMock.initList();
        if (BuildConfig.FLAVOR == "mock") {
            SongDetails song = SongListMock.testP2;
            song.setYear(2011);
            String m = detailsInteractor.modifyListItemByNetwork(song);
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals("Songlist was modified!", m);
            assertEquals(s.get(1).getYear(), song.getYear());
        }
    }
    @Test
    public void mockDeleteSongTest() throws Exception {
        SongListMock.resetList();
        SongListMock.initList();
        if (BuildConfig.FLAVOR == "mock") {
            SongDetails song = SongListMock.testP2;
            String m = detailsInteractor.deleteListItemByNetwork(song.getSongId());
            List<SongDetails> s = mainInteractor.getSongListFromNetwork("");
            assertEquals("Songlist was deleted!", m);
            assertEquals(s.size(), 2);
            assertNotNull(SongListMock.testP2);
        }
    }
}
