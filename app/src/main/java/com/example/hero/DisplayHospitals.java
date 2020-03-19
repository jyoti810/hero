package com.example.hero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.content.Intent;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;

import com.example.hero.Model.Category;
import com.example.hero.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import android.app.Activity;
//import android.content.Context;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.widget.TextView;

//import android.util.Log;
//import android.widget.Toast;


//import java.util.ArrayList;
//aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//created new package - "Model in ex.hero"
//created java class category in model
//created new package "viewholder" in ex.hero
//created new layout file - "item_category"
public class DisplayHospitals extends AppCompatActivity {

     //ArrayList<String> myArrayList=new ArrayList<>();
     int PERMISSION_ID = 44;
    FusedLocationProviderClient mFusedLocationClient;
     RecyclerView recyclerView;
     RecyclerView.LayoutManager layoutManager;
     FirebaseRecyclerAdapter<Category, CategoryViewHolder>adapter;

     FirebaseAuth firebaseAuth;
     FirebaseDatabase database;
     private DatabaseReference myRef;
     double mylatitude,mylogitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        getLastLocation();
        //////////////////////////////////////////////////////////////////////////



        setContentView(R.layout.activity_display_hospitals);

        database=FirebaseDatabase.getInstance();
        firebaseAuth=FirebaseAuth.getInstance();
        myRef= database.getReference("Category");

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        showList();


    }



    private void showList(){
        final FirebaseRecyclerOptions<Category> options=new FirebaseRecyclerOptions.Builder<Category>().setQuery(myRef,Category.class).build();

        adapter=new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position , @NonNull Category model) {
                String  aaaaaa=model.getLatitude();
                double lat2=Double.valueOf(aaaaaa);
                //String a =Double.toString(lat2);


                String bb=model.getLongitude();
                double lon2 = Double.valueOf(bb);

                //double lon2=Double.parseDouble(model.getlogi());
                final int earthRadius = 6371;
                double lat1=mylatitude,lon1=mylogitude;

                double dLat =  Math.toRadians(lat2 - lat1);
                double dLon =  Math.toRadians(lon2 - lon1);
                double a =
                        (Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
                                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2));
                double c =  (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
                double distance = earthRadius * c;

                //String tp= Double.toString(distance);
                if(distance < 5) {
                    holder.txtusername.setText(model.getName());
                    holder.txtphone.setText(model.getPhone_No());
                    holder.txticu.setText(model.getICU_Beds());
                    holder.txttimings.setText(model.getTimings());
                    holder.txttypes.setText(model.getTypes());


                }else{

                   // notifyItemRemoved(position);

                    holder.itemView.setVisibility(View.GONE);
                    holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0,0));
                    //adapter.notifyItemRemoved(position);

                }
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category,viewGroup,false);
                return new CategoryViewHolder(view);
            }
        };
        adapter.startListening();

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
    @SuppressLint("MissingPermission")
    private void getLastLocation(){
        if (checkPermissions()) {

                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {
                                    //19.0865° N, 72.8305
                                    //latTextView.setText(location.getLatitude()+"");
                                    //lonTextView.setText(location.getLongitude()+"");
                                    mylatitude=location.getLatitude();
                                    mylogitude=location.getLongitude();
                                    //mylatitude=19.0865;
                                    //mylogitude = 72.8305;

                                }
                            }
                        }
                );

        } else {
            requestPermissions();
        }
    }


    @SuppressLint("MissingPermission")
    private void requestNewLocationData(){

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );

    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {



            Location mLastLocation = locationResult.getLastLocation();
            //19.0865° N, 72.8305
            mylatitude=mLastLocation.getLatitude();
            mylogitude=mLastLocation.getLongitude();
            //mylatitude=19.0865;
            //mylogitude=72.8305;


        }
    };

    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if (checkPermissions()) {
            getLastLocation();
        }

    }


}





