package com.mymusic.mymusicapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.R;
import com.mymusic.mymusicapp.presenter.DetailsPresenter;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsScreen{

    @Inject
    DetailsPresenter detailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDeleteMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
