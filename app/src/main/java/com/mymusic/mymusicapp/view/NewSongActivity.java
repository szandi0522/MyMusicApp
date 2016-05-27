package com.mymusic.mymusicapp.view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.R;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.presenter.NewSongPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NewSongActivity extends AppCompatActivity implements NewSongScreen{

    @Inject
    NewSongPresenter newSongPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);

        MyMusicApplication.injector.inject(this);

        findViewById(R.id.addButton).setOnClickListener(new Button.OnClickListener() {

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

                SongDetails song = new SongDetails(title,artist,Integer.parseInt(year),album,image,youtube);

                newSongPresenter.addNewSong(song);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        newSongPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newSongPresenter.detachView();
    }


    @Override
    public void showMessageToast(String message) {
        Toast.makeText(NewSongActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
