package com.mymusic.mymusicapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mymusic.mymusicapp.R;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
