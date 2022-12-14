package com.example.androidapp;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;


import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Intent;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;


import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ListView lv;

    SessionManagement sessionManagement ;


  @Override
  protected void onStart(){
        super.onStart();

        // check if the user is logged in
      sessionManagement = new SessionManagement(MainActivity.this);


        int userID = sessionManagement.getSession();

        if(userID != -1){
            Intent it = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(it);
        }
    }



    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        int[] imageId = {R.drawable.finalbackfoot, R.drawable.finalbackswimming, R.drawable.finalbacktennis};
        String[] name = {"Foot-ball","Natation","Tennis"};
         String[] sid = {String.valueOf(R.string.id1), String.valueOf(R.string.id2), String.valueOf(R.string.id3)};
        String[] prix = {"400 MAD", "450 MAD", "550 MAD"};
        int[] emploi ={R.drawable.footballtable,R.drawable.swimmingtable,R.drawable.tennistable} ;

        // generique list of sports objects
        ArrayList<Sports> userArrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Sports sp = new Sports(sid[i],name[i],imageId[i],prix[i],emploi[i]);

            userArrayList.add(sp);
        }


        LandingAdaptateur listAdapter = new LandingAdaptateur(this, userArrayList);

        lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(listAdapter);


        // lv.setClickable(true);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in = new Intent(MainActivity.this, LoginActivity.class);
                in.putExtra("name", name[position]);
                startActivity(in);




            }
        });

    }

}

