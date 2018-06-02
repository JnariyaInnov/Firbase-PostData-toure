package com.karthi.sathguru;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FlightActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner,spinner1;
    private static final String[]paths = {"Chennai", "Coimbator"};
    private static String[] packages;
    int district=0,route=0;
    CardView cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8,cv9,cv10,cv11,cv12,cv13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        cv1=findViewById(R.id.card11);
        cv2=findViewById(R.id.card22);
        cv3=findViewById(R.id.card33);
        cv4=findViewById(R.id.card44);
        cv5=findViewById(R.id.card55);
        cv6=findViewById(R.id.card66);
        cv7=findViewById(R.id.card77);
        cv8=findViewById(R.id.card88);
        cv9=findViewById(R.id.card99);
        cv10=findViewById(R.id.card10);
        cv11=findViewById(R.id.card111);
        cv12=findViewById(R.id.card112);
        cv13=findViewById(R.id.card113);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner1 = (Spinner)findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FlightActivity.this,
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
                    packages = new String[]{"Shirdi Flight Packages From Chennai - 1 Days",
                            "Shirdi Flight Packages From Chennai - 2 Days",
                            "Shirdi Flight Packages From Chennai Via Mumbai - 2 Days",
                            "Shirdi Pandharpur Flight Packages From Chennai - 3 Days",
                            "Shirdi Nasik Flight Package From Chennai - 3 Days",
                            "Shirdi Train/Flight Package From Chennai - 3 Days",
                            "Shirdi And Jyotrilingam Package From Chennai - 4 Days",
                            "Shirdi Ajantha Ellora Package From Chennai - 4 Days",
                            "Shirdi And Lonavala Package From Chennai - 3 Days"
                    };
                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(FlightActivity.this,
                            android.R.layout.simple_spinner_item,packages);
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter1);
                    spinner1.setSelection(0);
                    spinner1.setOnItemSelectedListener(this);
                    district=1;
                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    packages = new String[]{"Coimbatore to Shirdi Flight Package - 1 day",
                            "Shirdi Flight Package From Coimbatore Via Pune- 2 day",
                            "Shirdi Flight Packages From Coimbatore Via Mumbai - 2 day",
                            "Shirdi Flight Packages From Coimbatore - 3 day"
                    };
                    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(FlightActivity.this,
                            android.R.layout.simple_spinner_item,packages);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter2);
                    spinner1.setSelection(0);
                    spinner1.setOnItemSelectedListener(this);
                    district=2;
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
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    if(district==2 && route==1) {
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.VISIBLE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
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
                    cv5.setVisibility(View.GONE);
                    cv6.setVisibility(View.GONE);
                    cv7.setVisibility(View.GONE);
                    cv8.setVisibility(View.GONE);
                    cv9.setVisibility(View.GONE);
                    cv10.setVisibility(View.GONE);
                    cv11.setVisibility(View.GONE);
                    cv12.setVisibility(View.GONE);
                    cv13.setVisibility(View.GONE);
                }
                    if(district==2 && route==2) {
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.VISIBLE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    route=3;
                    if(district==1 && route==3){
                    cv1.setVisibility(View.GONE);
                    cv2.setVisibility(View.GONE);
                    cv3.setVisibility(View.VISIBLE);
                    cv4.setVisibility(View.GONE);
                    cv5.setVisibility(View.GONE);
                    cv6.setVisibility(View.GONE);
                    cv7.setVisibility(View.GONE);
                    cv8.setVisibility(View.GONE);
                    cv9.setVisibility(View.GONE);
                    cv10.setVisibility(View.GONE);
                    cv11.setVisibility(View.GONE);
                    cv12.setVisibility(View.GONE);
                    cv13.setVisibility(View.GONE);
                }
                    if(district==2 && route==3) {
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.VISIBLE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
                case 3:
                    // Whatever you want to happen when the first item gets selected
                    route=4;
                    if(district==1 && route==4){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.VISIBLE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    if(district==2 && route==4) {
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.VISIBLE);
                    }
                    break;
                case 4:
                    // Whatever you want to happen when the second item gets selected
                    route=5;
                    if(district==1 && route==5){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.VISIBLE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
                case 5:
                    // Whatever you want to happen when the thrid item gets selected
                    route=6;
                    if(district==1 && route==6){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.VISIBLE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
                case 6:
                    // Whatever you want to happen when the first item gets selected
                    route=7;
                    if(district==1 && route==7){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.VISIBLE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
                case 7:
                    // Whatever you want to happen when the second item gets selected
                    route=8;
                    if(district==1 && route==8){
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.VISIBLE);
                        cv9.setVisibility(View.GONE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
                case 8:
                    // Whatever you want to happen when the thrid item gets selected
                    route=9;
                    if(district==1 && route==9) {
                        cv1.setVisibility(View.GONE);
                        cv2.setVisibility(View.GONE);
                        cv3.setVisibility(View.GONE);
                        cv4.setVisibility(View.GONE);
                        cv5.setVisibility(View.GONE);
                        cv6.setVisibility(View.GONE);
                        cv7.setVisibility(View.GONE);
                        cv8.setVisibility(View.GONE);
                        cv9.setVisibility(View.VISIBLE);
                        cv10.setVisibility(View.GONE);
                        cv11.setVisibility(View.GONE);
                        cv12.setVisibility(View.GONE);
                        cv13.setVisibility(View.GONE);
                    }
                    break;
            }
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void showD(View v){

        if(district==1 && route==1){
            cv1.setVisibility(View.VISIBLE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==2){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.VISIBLE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==3){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.VISIBLE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==4){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.VISIBLE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==5){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.VISIBLE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==6){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.VISIBLE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==7){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.VISIBLE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==8){
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.VISIBLE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==1 && route==9) {
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.VISIBLE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==2 && route==1) {
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.VISIBLE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==2 && route==2) {
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.VISIBLE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.GONE);
        }else if(district==2 && route==3) {
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.VISIBLE);
            cv13.setVisibility(View.GONE);
        }else if(district==2 && route==4) {
            cv1.setVisibility(View.GONE);
            cv2.setVisibility(View.GONE);
            cv3.setVisibility(View.GONE);
            cv4.setVisibility(View.GONE);
            cv5.setVisibility(View.GONE);
            cv6.setVisibility(View.GONE);
            cv7.setVisibility(View.GONE);
            cv8.setVisibility(View.GONE);
            cv9.setVisibility(View.GONE);
            cv10.setVisibility(View.GONE);
            cv11.setVisibility(View.GONE);
            cv12.setVisibility(View.GONE);
            cv13.setVisibility(View.VISIBLE);
        }else{

        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void about(View v) {
        startActivity(new Intent(FlightActivity.this,AboutActivity.class));

    }
}
