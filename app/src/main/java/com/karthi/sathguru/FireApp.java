package com.karthi.sathguru;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by karthikeyansekar on 28/05/18.
 */

public class FireApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
