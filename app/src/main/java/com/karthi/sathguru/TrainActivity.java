package com.karthi.sathguru;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TrainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner,spinner1;
    private static final String[]paths = {"Chennai", "Coimbator", "Salem"};
    private static String[] packages;
    int district=0,route=0;

    CardView cv1,cv2,cv3,cv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        cv1=findViewById(R.id.card0);
        cv2=findViewById(R.id.card1);
        cv3=findViewById(R.id.card2);
        cv4=findViewById(R.id.card3);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TrainActivity.this,
                android.R.layout.simple_spinner_item,paths);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(this);

    }


    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        Spinner spin = (Spinner)parent;
        Spinner spin2 = (Spinner)parent;
        if(spin.getId() == R.id.spinner)
        {
            switch (position) {
                case 0:
                    // Whatever you want to happen when the first item gets selected
                    packages = new String[]{"Shirdi Train Packages From Chennai - 4 Days", "Shirdi Mantralayam Train Packages From Chennai - 5 Days", "Shirdi Train/Flight Package From Chennai - 3 Days"};
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(TrainActivity.this,
                            android.R.layout.simple_spinner_item,packages);
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter1);
                    spinner1.setSelection(0);
                    spinner1.setOnItemSelectedListener(this);
                    district=1;

                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    packages = new String[]{"Shirdi Train Package From Coimbatore/Salem - 5 day"};
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(TrainActivity.this,
                            android.R.layout.simple_spinner_item,packages);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter2);
                    spinner1.setSelection(0);
                    spinner1.setOnItemSelectedListener(this);
                    district=2;
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    packages = new String[]{"Shirdi Train Package From Coimbatore/Salem - 5 day"};
                    ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(TrainActivity.this,
                            android.R.layout.simple_spinner_item,packages);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter3);
                    spinner1.setSelection(0);
                    spinner1.setOnItemSelectedListener(this);
                    district=3;
                    break;

            }        }
        if(spin2.getId() == R.id.spinner1)
        {
            switch (position) {
                case 0:
                    // Whatever you want to happen when the first item gets selected
                    route=1;
                    if(district==1 && route==1){
                        cv1.setVisibility(View.VISIBLE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                    }
                    if(district==2 && route==1){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.VISIBLE);
                    }
                    if(district==3 && route==1){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.VISIBLE);
                    }
                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    route=2;
                    if(district==1 && route==2){
                    cv1.setVisibility(View.GONE);
                    cv2.setVisibility(View.VISIBLE);
                    cv3.setVisibility(View.GONE);
                    cv4.setVisibility(View.GONE);
                }
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    route=3;
                    if(district==1 && route==3) {
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.VISIBLE);
                        cv4.setVisibility(View.GONE);
                    }
                break;
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showD(View v){
        //Dialgoue interface
//        final Dialog dialog = new Dialog(TrainActivity.this);
//        dialog.setContentView(R.layout.activity_flight);
//        dialog.setTitle("Title...");
//
//        dialog.show();

        if(district==1 && route==1){
            cv1.setVisibility(View.VISIBLE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
        }else if(district==1 && route==2){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.VISIBLE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
        }else if(district==1 && route==3){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.VISIBLE);
            cv4.setVisibility(View.GONE);
        }else if(district==2 && route==1){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.VISIBLE);
        }else if(district==3 && route==1){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.VISIBLE);
        }else{

        }


    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void about(View v) {
        startActivity(new Intent(TrainActivity.this,AboutActivity.class));

    }

}
