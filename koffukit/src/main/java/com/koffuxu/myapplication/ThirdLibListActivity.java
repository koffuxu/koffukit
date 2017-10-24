package com.koffuxu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.koffuxu.myapplication.bitmap.AnimationTest;
import com.koffuxu.myapplication.bitmap.BitmapTest;
import com.koffuxu.myapplication.bitmap.CanvasPaint;
import com.koffuxu.myapplication.bitmap.MatrixActivity;
import com.koffuxu.myapplication.bitmap.SurfaceViewMyActivity;
import com.koffuxu.myapplication.bitmap.TweenMyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koffuxu on 2016/11/20.
 */
public class ThirdLibListActivity extends Activity{

    private ListView listViewBitmap = null;
    private List<String> getDate() {
        List<String> data = new ArrayList<String>();
        data.add("ButterKnife");
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        listViewBitmap = (ListView) findViewById(R.id.listViewBitmap);
        listViewBitmap.setAdapter(new ArrayAdapter<String>(this, R.layout.text_one_line, getDate()));
        listViewBitmap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i2 = new Intent();
                switch (position) {
                    case 0:
                        Log.d(MainActivity.TAG, "Item Butter Knife Selected");
                        i2.setClass(ThirdLibListActivity.this, ButterKnifeTest.class);
                        startActivity(i2);
                        break;

                }
            }
        });

    }
}