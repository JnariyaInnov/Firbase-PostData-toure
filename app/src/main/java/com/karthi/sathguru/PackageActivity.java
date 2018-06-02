package com.karthi.sathguru;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class PackageActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);

        TabHost tabHost = getTabHost();

        // Tab for Photos
        TabHost.TabSpec trainspec = tabHost.newTabSpec("Photos");
        // setting Title and Icon for the Tab
        trainspec.setIndicator("Train", getResources().getDrawable(R.drawable.ic_action_train));
        Intent photosIntent = new Intent(this, TrainActivity.class);
        trainspec.setContent(photosIntent);

        // Tab for Songs
        TabHost.TabSpec flightspec = tabHost.newTabSpec("Songs");
        flightspec.setIndicator("Flight", getResources().getDrawable(R.drawable.ic_action_flight));
        Intent songsIntent = new Intent(this, FlightActivity.class);
        flightspec.setContent(songsIntent);


        // Adding all TabSpec to TabHost
        tabHost.addTab(trainspec); // Adding photos tab
        tabHost.addTab(flightspec); // Adding songs tab
    }
}
