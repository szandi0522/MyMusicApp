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
                List<SongDetails> list = new ArrayList<SongDetails>();
                newSongPresenter.addNewSong(list);
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
