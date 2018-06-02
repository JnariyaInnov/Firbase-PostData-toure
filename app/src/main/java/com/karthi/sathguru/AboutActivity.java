package com.karthi.sathguru;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void webBezzietech(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://bezzietech.com")));
    }

    public void webSathguru(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sathgurutours.com")));
    }

    public void mailSathguru(View view) {
        startActivity(new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","admin@sathgurutours.com",null)));
    }
    public void mailBezzietech(View view) {
        startActivity(new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","admin@bezzietech.com",null)));
    }

    public void phoneSathguru(View view) {
        startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+919962102056")));
    }
    public void phoneBezzietech(View view) {
        startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:+917010894452")));
    }
}
