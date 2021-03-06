package com.koffuxu.myapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.koffuxu.myapplication.fileOps.CopyLogActivity;
import com.koffuxu.myapplication.network.SocketTestActivity;
import com.koffuxu.myapplication.service.Client;

import java.util.ArrayList;
import java.util.List;

/*
 * This used for constructing a entry by Koffu Xu(koffuxu@gmail.com)
 */
public class MainActivity extends Activity {
    public static final String TAG = "koffuxu";

    private ListView listView = null;

    private List<String> getDate() {
        List<String> data = new ArrayList<String>();
        data.add("00_ServiceTest");
        data.add("01_BitmapTest");
        data.add("02_FileOpsTest");
        data.add("03_ViewTest");
        data.add("04_JavaLangTest");
        data.add("05_KfProject");
        data.add("06_SocketTest");
        data.add("07_3nd_lib_Test");
        return data;
    }

    private void openApp(String pkg, String act)
    {
        Log.d(TAG, "open the app----->pkg:" + pkg + "  act:" + act);
        ComponentName comp = new ComponentName(pkg, act);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setComponent(comp);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.text_one_line, getDate()));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent i = new Intent();
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Log.d(TAG, "Item 0 Selected");
                        i.setClass(MainActivity.this, Client.class);
                        startActivity(i);
                        break;
                    case 1:
                        Log.d(TAG, "Item BitmapTest Selected");
                        //openApp("com.koffuxu.myapplication", "com.koffuxu.myapplication.BitmapListActivity");
                        i.setClass(MainActivity.this, BitmapListActivity.class);
                        startActivity(i);
                        break;
                    case 2:
                        Log.d(TAG, "Item file ops Selected");
                        i.setClass(MainActivity.this, CopyLogActivity.class);
                        startActivity(i);
                        break;
                     case 3:
                        Log.d(TAG, "Item view test Selected");
                        i.setClass(MainActivity.this, ViewListActivity.class);
                        startActivity(i);
                        break;
                    case 4:
                        Log.d(TAG, "Java Base test Selected");
                        i.setClass(MainActivity.this, BaseActivity.class);
                        startActivity(i);
                        break;
                     case 5:
                        Log.d(TAG, "Koffu Project test Selected");
                        i.setClass(MainActivity.this, KoffuProjectListActivity.class);
                        startActivity(i);
                        break;
                    case 6:
                        Log.d(TAG, "Koffu Socket test Selected");
                        i.setClass(MainActivity.this, SocketTestActivity.class);
                        startActivity(i);
                        break;
                    case 7:
                        Log.d(TAG, "Koffu 3nd lib test Selected");
                        i.setClass(MainActivity.this, ThirdLibListActivity.class);
                        startActivity(i);
                        break;
                }
            }
        });

    }
}
