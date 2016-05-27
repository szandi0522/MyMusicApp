package com.mymusic.mymusicapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.mymusic.mymusicapp.BuildConfig;
import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.R;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.presenter.DetailsPresenter;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    SongDetails selectedSong = new SongDetails();
    @Inject
    DetailsPresenter detailsPresenter;

    private Tracker mTracker;
    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MyMusicApplication application = (MyMusicApplication) getApplication();
        mTracker = application.getDefaultTracker();


        Intent i = getIntent();
        selectedSong = (SongDetails) i.getSerializableExtra("SONG");
        selectedSong.setId((long)i.getLongExtra("ID",0));

        EditText field = (EditText) findViewById(R.id.titleField);
        field.setText(selectedSong.getTitle());
        field = (EditText) findViewById(R.id.artistField);
        field.setText(selectedSong.getArtist());
        field = (EditText) findViewById(R.id.yearField);
        field.setText(Integer.toString(selectedSong.getYear()));
        field = (EditText) findViewById(R.id.albumField);
        field.setText(selectedSong.getAlbum());
        field = (EditText) findViewById(R.id.imageField);
        field.setText(selectedSong.getImage());
        field = (EditText) findViewById(R.id.youtubeField);
        field.setText(selectedSong.getYoutube());

        findViewById(R.id.deleteButton).setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (BuildConfig.FLAVOR.equals("mock")) {
                    detailsPresenter.delete(selectedSong.getSongId());
                } else {
                    long id = selectedSong.getId();
                    detailsPresenter.delete(id);
                }
            }
        });

        findViewById(R.id.modifyButton).setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText titleField = (EditText) findViewById(R.id.titleField);
                String title = titleField.getText().toString();
                EditText artField = (EditText) findViewById(R.id.artistField);
                String artist = artField.getText().toString();
                EditText yearField = (EditText) findViewById(R.id.yearField);
                String year = yearField.getText().toString();

                EditText field = (EditText) findViewById(R.id.albumField);
                String album = field.getText().toString();
                field = (EditText) findViewById(R.id.imageField);
                String image = field.getText().toString();
                field = (EditText) findViewById(R.id.youtubeField);
                String youtube = field.getText().toString();

                if(title.equalsIgnoreCase("")){
                    titleField.setError("Field is required!");
                    return;
                }
                if(artist.equalsIgnoreCase("")){
                    artField.setError("Field is required!");
                    return;
                }
                if(year.equalsIgnoreCase("")){
                    yearField.setError("Field is required!");
                    return;
                }

                selectedSong.setTitle(title);
                selectedSong.setAlbum(album);
                selectedSong.setArtist(artist);
                selectedSong.setYear(Integer.parseInt(year));
                selectedSong.setImage(image);
                selectedSong.setYoutube(youtube);
                detailsPresenter.modify(selectedSong);
            }
        });

        MyMusicApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailsPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailsPresenter.detachView();
    }

    @Override
    public void showModifyMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDeleteMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume(){
        super.onResume();

        Log.i(TAG, "Setting screen name: " + TAG);
        mTracker.setScreenName("Image~" + TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
