package com.karthi.sathguru;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatImageView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView icon1car,icon1bus,icon1flight,icon1train,icon1room;
    ImageView icon2car,icon2bus,icon2flight,icon2train,icon2room;
    TextView tv1car,tv1bus,tv1flight,tv1train,tv1room;
    TextView tv2car,tv2bus,tv2flight,tv2train,tv2room;
    int ccar=0,cbus=0,cflight=0,ctrain=0,croom=0;
    private FirebaseAuth auth;
    String usName,usEmail,usUid;
    Uri usPhotoUrl;
    EditText userInput;
    boolean emailVerified;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
             usName = user.getDisplayName();
             usEmail = user.getEmail();
             usPhotoUrl = user.getPhotoUrl();
             emailVerified = user.isEmailVerified();
             usUid = user.getUid();
        }



//        if(usName == "") {
//            namepopup();
//        }

//        AppCompatImageView iv=findViewById(R.id.logo_id);
//        String i="http://d1rwqyflb8a4eu.cloudfront.net/saibaba.jpg";
//        iv.setImageURI(Uri.parse(i));
//
//        Picasso.get().load(usPhotoUrl).into(iv);
//        TextView ts = findViewById(R.id.sample);
//        ts.setText("hj");

        TextView but=findViewById(R.id.button);
        but.setText(Html.fromHtml("<u>View Packages >></u>"));

        icon1car=findViewById(R.id.car_id);
        icon1bus=findViewById(R.id.bus_is);
        icon1flight=findViewById(R.id.flight_id);
        icon1train=findViewById(R.id.train_id);
        icon1room=findViewById(R.id.accom_id);

        icon2car=findViewById(R.id.icon2_car);
        icon2bus=findViewById(R.id.icon2_bus);
        icon2flight=findViewById(R.id.icon2_flight);
        icon2train=findViewById(R.id.icon2_train);
        icon2room=findViewById(R.id.icon2_rooms);

        tv2car=findViewById(R.id.icon2_cartext);
        tv2bus=findViewById(R.id.icon2_bustext);
        tv2flight=findViewById(R.id.icon2_flighttext);
        tv2train=findViewById(R.id.icon2_traintext);
        tv2room=findViewById(R.id.icon2_roomstext);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
//                    //set icon
//                    .setIcon(android.R.drawable.ic_dialog_alert)
                    //set title
                    .setTitle("Exit")
                    //set message
                    .setMessage("Are you sure to Exit")
                    //set positive button
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what would happen when positive button is clicked
                            finish();
                        }
                    })
                    //set negative button
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what should happen when negative button is clicked
                            Toast.makeText(getApplicationContext(),"Stay tunned",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(HomeActivity.this, ProSettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

        } else if (id == R.id.nav_gallery) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(HomeActivity.this, GalleryActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.nav_temple_details) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(HomeActivity.this, TemgalActivity.class);
            startActivity(intent);
            return true;

        }
        else if (id == R.id.nav_profile) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(HomeActivity.this, ProSettingsActivity.class);
            startActivity(intent);
            return true;
        }
//        else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_about) {
//
//        }
        else if (id == R.id.nav_about) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void onCar(View view) {
        if(ccar==0){
            ccar++;
        icon2car.setVisibility(View.VISIBLE);
        tv2car.setVisibility(View.VISIBLE);

        icon2room.setVisibility(View.GONE);
        tv2room.setVisibility(View.GONE);

        icon2train.setVisibility(View.GONE);
        tv2train.setVisibility(View.GONE);

        icon2flight.setVisibility(View.GONE);
        tv2flight.setVisibility(View.GONE);

        icon2bus.setVisibility(View.GONE);
        tv2bus.setVisibility(View.GONE);
        }else{
            ccar=0;
            icon2car.setVisibility(View.GONE);
            tv2car.setVisibility(View.GONE);
        }
    }

    public void onRooms(View view) {

        if(croom==0) {
            croom++;
            icon2room.setVisibility(View.VISIBLE);
            tv2room.setVisibility(View.VISIBLE);

            icon2train.setVisibility(View.GONE);
            tv2train.setVisibility(View.GONE);

            icon2flight.setVisibility(View.GONE);
            tv2flight.setVisibility(View.GONE);

            icon2bus.setVisibility(View.GONE);
            tv2bus.setVisibility(View.GONE);

            icon2car.setVisibility(View.GONE);
            tv2car.setVisibility(View.GONE);
        }else{
            croom=0;
            icon2room.setVisibility(View.GONE);
            tv2room.setVisibility(View.GONE);
        }
    }

    public void onTrain(View view) {
        if(ctrain==0) {
            ctrain++;
            icon2train.setVisibility(View.VISIBLE);
            tv2train.setVisibility(View.VISIBLE);

            icon2flight.setVisibility(View.GONE);
            tv2flight.setVisibility(View.GONE);

            icon2bus.setVisibility(View.GONE);
            tv2bus.setVisibility(View.GONE);

            icon2car.setVisibility(View.GONE);
            tv2car.setVisibility(View.GONE);

            icon2room.setVisibility(View.GONE);
            tv2room.setVisibility(View.GONE);
        }else {
            ctrain=0;
            icon2train.setVisibility(View.GONE);
            tv2train.setVisibility(View.GONE);
        }
    }

    public void onFlight(View view) {
        if (cflight == 0) {
            cflight++;
            icon2flight.setVisibility(View.VISIBLE);
            tv2flight.setVisibility(View.VISIBLE);

            icon2bus.setVisibility(View.GONE);
            tv2bus.setVisibility(View.GONE);

            icon2car.setVisibility(View.GONE);
            tv2car.setVisibility(View.GONE);

            icon2room.setVisibility(View.GONE);
            tv2room.setVisibility(View.GONE);

            icon2train.setVisibility(View.GONE);
            tv2train.setVisibility(View.GONE);
        } else {
            cflight=0;
            icon2flight.setVisibility(View.GONE);
            tv2flight.setVisibility(View.GONE);
        }
    }

    public void onBus(View view) {
        if(cbus==0) {
            cbus++;
            icon2bus.setVisibility(View.VISIBLE);
            tv2bus.setVisibility(View.VISIBLE);

            icon2car.setVisibility(View.GONE);
            tv2car.setVisibility(View.GONE);

            icon2room.setVisibility(View.GONE);
            tv2room.setVisibility(View.GONE);

            icon2train.setVisibility(View.GONE);
            tv2train.setVisibility(View.GONE);

            icon2flight.setVisibility(View.GONE);
            tv2flight.setVisibility(View.GONE);
        }else {
            cbus=0;
            icon2bus.setVisibility(View.GONE);
            tv2bus.setVisibility(View.GONE);

        }
    }

    public void packages(View view) {
        Intent intent = new Intent(HomeActivity.this, PackageActivity.class);
        startActivity(intent);
    }

//    public void namepopup(){
//
//
//            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            // get prompts.xml view
//            LayoutInflater li = LayoutInflater.from(this);
//            View promptsView = li.inflate(R.layout.custom, null);
//
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                    this);
//
//            // set prompts.xml to alertdialog builder
//            alertDialogBuilder.setView(promptsView);
//
//            userInput = (EditText) promptsView
//                    .findViewById(R.id.editTextDialogUserInput);
//
//            // set dialog message
//            alertDialogBuilder
//                    .setCancelable(false)
//                    .setPositiveButton("OK",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,int id) {
//                                    // get user input and set it to result
//                                    // edit text
//                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
//                                            .setDisplayName(userInput.getText().toString())
//                                            .build();
//
//                                    user.updateProfile(profileUpdates)
//                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                    if (task.isSuccessful()) {
//                                                        Toast.makeText(HomeActivity.this, "Name Changed!", Toast.LENGTH_SHORT).show();
//
//
//                                                    }
//                                                }
//                                            });
//                                }
//                            })
//                    .setNegativeButton("Cancel",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,int id) {
//                                    dialog.cancel();
//                                }
//                            });
//
//            // create alert dialog
//            AlertDialog alertDialog = alertDialogBuilder.create();
//
//            // show it
//            alertDialog.show();
//
//
//    }


}
