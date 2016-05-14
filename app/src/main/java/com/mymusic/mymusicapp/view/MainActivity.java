package com.mymusic.mymusicapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mymusic.mymusicapp.MyMusicApplication;
import com.mymusic.mymusicapp.R;
import com.mymusic.mymusicapp.SongDetailsAdapter;
import com.mymusic.mymusicapp.model.SongDetails;
import com.mymusic.mymusicapp.network.mock.SongListMock;
import com.mymusic.mymusicapp.presenter.MainPresenter;
import com.orm.SugarContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        MyMusicApplication.injector.inject(this);
        SugarContext.init(this);

        //mainPresenter.refreshList();

        findViewById(R.id.searchButton).setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText searchField = (EditText) findViewById(R.id.searchField);
                String searchText = searchField.getText().toString();
                mainPresenter.search(searchText);
            }
        });


        findViewById(R.id.addButton).setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainPresenter.navigatoToAddNewPage();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_new:
                mainPresenter.navigatoToAddNewPage();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showList(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSearchResult(List<SongDetails> resultList) {

        //Toast.makeText(this,resultList.get(0).getTitle(),Toast.LENGTH_LONG).show();
        final ArrayList<SongDetails> list = new ArrayList<>();
        for (int i = 0; i < resultList.size(); ++i) {
            list.add(resultList.get(i));
        }
//        ((ListView) findViewById(R.id.listView)).setAdapter(
//                new SongDetailsAdapter(this, R.layout.list_item, list));

        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new SongDetailsAdapter(this, R.layout.list_item, list));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra("SONG", (Serializable)(list.get(position)));
                startActivity(intent);
            }
        });
    }

    @Override
    public void navigateToNewSongPage() {
        Intent intent = new Intent(this, NewSongActivity.class);
        startActivity(intent);
    }
}
