package com.mymusic.mymusicapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mymusic.mymusicapp.model.SongDetails;

import java.util.HashMap;
import java.util.List;

public class SongDetailsAdapter extends ArrayAdapter<SongDetails>{

    Context mContext;
    int layoutResourceId;
    List<SongDetails> objects = null;

    public SongDetailsAdapter(Context context, int textViewResourceId,
                              List<SongDetails> objects) {
        super(context, textViewResourceId, objects);

        this.layoutResourceId = textViewResourceId;
        this.mContext = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        SongDetails objectItem = objects.get(position);

        TextView textViewItem = (TextView) convertView.findViewById(R.id.line);
        textViewItem.setText(objectItem.getTitle());

        TextView textViewItem2 = (TextView) convertView.findViewById(R.id.line2);
        textViewItem2.setText(objectItem.getArtist());

        return convertView;

    }


}
