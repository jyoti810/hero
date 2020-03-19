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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HospitalInfo extends AppCompatActivity {
    private EditText editTextname;
    private EditText editTextAddress;
    private EditText editTextPhone;
    private EditText  editTextICU;
    private EditText editTextLat;
    private EditText editTextLong;
    private EditText editTextPassword;
    private EditText etUserEmail;
    private EditText editTextTimings;
    private EditText editTextTypes;
    private  EditText editTextLabType;
    private EditText editTextLabTime;
    String name,address,phone,icu,lat,lng,email,password,timings,types,labtype,labtime;
    //private TextView tvUserLogin;
    private Button Buttonsave;
    private FirebaseAuth firebaseAuth;
    DatabaseReference myRef;
    FirebaseDatabase firebaseDatabase;
    //Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_info);
        //tvUserLogin=(TextView)findViewById(R.id.tvUserLogin) ;
        setUpUIViews();
        myRef=firebaseDatabase.getInstance().getReference("Category");
        firebaseAuth=FirebaseAuth.getInstance();




        //reff= FirebaseDatabase.getInstance().getReference().child("Member");
        //member=new Member();
        Buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    String password=editTextPassword.getText().toString().trim();
                    String email=etUserEmail.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(HospitalInfo.this, "Registration successful ", Toast.LENGTH_SHORT).show();
                                sendUserData();
                                finish();

                            startActivity(new Intent(HospitalInfo.this,WhenSignedIn.class));
                            }else{
                                Toast.makeText(HospitalInfo.this, "Registration Failed ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                /*String name= editTextname.getText().toString();
                String address= editTextAddress.getText().toString();
                Long phone=Long.parseLong(editTextPhone.getText().toString().trim());
                Integer icu = Integer.parseInt(editTextICU.getText().toString().trim());
                Double lat=Double.parseDouble(editTextLat.getText().toString().trim());
                Double lng=Double.parseDouble(editTextLong.getText().toString().trim());
                String password=editTextPassword.getText().toString().trim();

                member.setName(name);
                member.setAddress(address);
                member.setPhone_No(phone);
                member.setICU(icu);
                member.setLat(lat);
                member.setLng(lng);
                member.setPassword(password);

                reff.push().setValue(member);
                Toast.makeText(HospitalInfo.this, "data iserted successfully ", Toast.LENGTH_SHORT).show();*/
            }
        });
        /*tvUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HospitalInfo.this,HospitalLogin.class));
            }
        });*/
    }
    private void setUpUIViews(){
        editTextname= (EditText)findViewById(R.id.editTextName);
        editTextAddress = (EditText)findViewById(R.id.editTextAddress);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextICU = (EditText)findViewById(R.id.editTextICU);
        editTextLat = (EditText)findViewById(R.id.editTextLat);
        editTextLong = (EditText)findViewById(R.id.editTextLong);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        etUserEmail=(EditText)findViewById(R.id.etUserEmail);
        editTextTimings=(EditText)findViewById(R.id.editTextTimings);
        editTextTypes=(EditText)findViewById(R.id.editTextTypes);
        editTextLabType =(EditText)findViewById(R.id.editTextLabType);
        editTextLabTime=(EditText)findViewById(R.id.editTextLabTime);
        Buttonsave=(Button)findViewById(R.id.Buttonsave);

    }
    private Boolean validate(){
        Boolean result=false;
        name= editTextname.getText().toString();
        address= editTextAddress.getText().toString();
        phone=editTextPhone.getText().toString().trim();
        icu = editTextICU.getText().toString().trim();
        lat=editTextLat.getText().toString().trim();
        lng=editTextLong.getText().toString().trim();
        password=editTextPassword.getText().toString().trim();
        email=etUserEmail.getText().toString().trim();
        timings=editTextTimings.getText().toString();
        types=editTextTypes.getText().toString();
        labtype=editTextLabType.getText().toString();
        labtime=editTextLabTime.getText().toString();


        if(name.isEmpty() || address.isEmpty()|| phone.isEmpty()  || lat.isEmpty() || lng.isEmpty()
                || password.isEmpty() || email.isEmpty() ){
            Toast.makeText(this, "Please enter all the necessary details", Toast.LENGTH_LONG).show();
        }else{
            result = true;
        }
        return result;

    }
    private void  sendUserData(){

        //DatabaseReference myRef;
        String id=myRef.push().getKey();
        UserProfile userProfile= new UserProfile(email,name,address,phone,lat,lng,password,icu,timings,types,id,labtype,labtime);
        myRef.child(id).setValue(userProfile);

    }

}
