package com.agung.android.slidingdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.agung.android.slidingdrawer.SlidingDrawerFragment.ARG_STICK_TO;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_BOTTOM;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_LEFT;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_RIGHT;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_TOP;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private static final String[] ITEMS = {"STICK TO BOTTOM", "STICK TO LEFT"
            , "STICK TO RIGHT", "STICK TO TOP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ITEMS);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        setContentView(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, SlidingDrawerActivity.class);
        switch (position){
            case 0:
                intent.putExtra(ARG_STICK_TO, STICK_TO_BOTTOM);
                break;
            case 1:
                intent.putExtra(ARG_STICK_TO, STICK_TO_LEFT);
                break;
            case 2:
                intent.putExtra(ARG_STICK_TO, STICK_TO_RIGHT);
                break;
            case 3:
                intent.putExtra(ARG_STICK_TO, STICK_TO_TOP);
                break;
        }
        startActivity(intent);
    }
}
