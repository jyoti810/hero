package com.example.hero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HospitalLogin extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    Button btnLogin;
    private int counter = 5;
    private TextView tvRegister;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);





    }
    private Boolean validatemail(){
        String val=etEmail.getText().toString();
        if(val.isEmpty()){
            etEmail.setError("mail cannot be emty");
            return false;
        }else {
            etEmail.setError(null);
            etEmail.setEnabled(false);
            return true;
        }
    }
    private Boolean validatepass(){
        String val=etPassword.getText().toString();
        if(val.isEmpty()){
            etPassword.setError("mail cannot be emty");
            return false;
        }else {
            etPassword.setError(null);
            etPassword.setEnabled(false);
            return true;
        }

    }
    public  void login(View view){
        if(!validatemail() |!validatepass()){
            return;
        }
        else {
            isUser();
        }
    }

    private void isUser() {
        final String userenteremail=etEmail.getText().toString().trim();
        final String userenterpass=etPassword.getText().toString().trim();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Category");
        Query check=reference.orderByChild("EmailId").equalTo(userenteremail);
        check.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    etEmail.setError(null);
                    etEmail.setEnabled(false);
                    String passdb=dataSnapshot.child(userenteremail).child("Password").getValue(String.class);
                    if(passdb.equals(userenterpass)){
                        etEmail.setError(null);
                        etEmail.setEnabled(false);

                        String addressdb=dataSnapshot.child(userenteremail).child("Address").getValue(String.class);
                        String emaildb=dataSnapshot.child(userenteremail).child("EmailId").getValue(String.class);
                        String beddb=dataSnapshot.child(userenteremail).child("ICU_Beds").getValue(String.class);
                        String lab_timedb=dataSnapshot.child(userenteremail).child("Lab_Time").getValue(String.class);
                        String Lab_typedb=dataSnapshot.child(userenteremail).child("Lab_Type").getValue(String.class);
                        String latdb =dataSnapshot.child(userenteremail).child("Latitude").getValue(String.class);
                        String longdb=dataSnapshot.child(userenteremail).child("Longitude").getValue(String.class);
                        String namedb=dataSnapshot.child(userenteremail).child("Name").getValue(String.class);
                        String passworddb=dataSnapshot.child(userenteremail).child("Phone").getValue(String.class);
                        String phonedb=dataSnapshot.child(userenteremail).child("Name").getValue(String.class);
                        String timingdb=dataSnapshot.child(userenteremail).child("Timings").getValue(String.class);
                        String typedb=dataSnapshot.child(userenteremail).child("Types").getValue(String.class);
                        Intent intent=new Intent(getApplicationContext(),WhenSignedIn.class);

                        intent.putExtra("address",addressdb);
                        intent.putExtra("email",emaildb);
                        intent.putExtra("bed",beddb);
                        intent.putExtra("labtime",lab_timedb);
                        intent.putExtra("labtype",Lab_typedb);
                        intent.putExtra("lat",latdb);
                        intent.putExtra("long",longdb);
                        intent.putExtra("name",namedb);
                        intent.putExtra("pass",passworddb);
                        intent.putExtra("phone",phonedb);
                        intent.putExtra("timing",timingdb);
                        intent.putExtra("type",typedb);
                        startActivity(intent);
                    }
                    else {
                        etPassword.setError("wrong");
                        etEmail.requestFocus();
                    }
                }
                else {
                    etEmail.setError("no user");
                    etEmail.requestFocus();
                };
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
