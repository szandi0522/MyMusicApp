package com.mymusic.mymusicapp.view;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mymusic.mymusicapp.R;

public class NewSongActivity extends AppCompatActivity implements NewSongScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_song);
    }

    @Override
    public void showMessageToast(String message) {
        Toast.makeText(NewSongActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
