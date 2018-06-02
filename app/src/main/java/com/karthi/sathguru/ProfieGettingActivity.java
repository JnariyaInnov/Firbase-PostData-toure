package com.karthi.sathguru;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProfieGettingActivity extends AppCompatActivity {

    private String name,femail,email,phone,city,state,uid;
    EditText uName,uPhone,uCity,uState;
    TextView uEmail;
    Button submit;
    DatabaseReference userDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profie_getting);

        userDB = FirebaseDatabase.getInstance().getReference("users");


        uName=findViewById(R.id.name);
        uPhone=findViewById(R.id.phone);
        uCity=findViewById(R.id.add_city);
        uState=findViewById(R.id.addr_state);
        uEmail=findViewById(R.id.emaill);
        submit=findViewById(R.id.submit_button);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            femail = user.getEmail();
            uid = user.getUid();
        }

        email=femail.toString().trim();
        name=uName.getText().toString();
        phone=uPhone.getText().toString();
        city=uCity.getText().toString();
        state=uState.getText().toString();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = userDB.push().getKey();
                UserDetails userDetails = new UserDetails(name,email.toString().trim(),phone,city,state);
                userDB.child(uid).setValue(userDetails)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // Write was successful!
                                // ...
                                Toast.makeText(ProfieGettingActivity.this, "upload sucsess.",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Write failed
                                // ...
                                Toast.makeText(ProfieGettingActivity.this, "Profile info error",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                Intent intent=new Intent(ProfieGettingActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

            }
        });

    }

}

