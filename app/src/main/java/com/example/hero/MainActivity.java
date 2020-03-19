package com.example.hero;
//////////////////////
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this
        ));
        myAdapter = new MyAdapter(this, getMyList());
        mRecyclerView.setAdapter(myAdapter);

    }

    private ArrayList<Model1> getMyList () {

        ArrayList<Model1> models = new ArrayList<>();

        Model1 m = new Model1();
        m.setTitle("Hospitals Near me");
        m.setImg(R.drawable.hospitals);
        models.add(m);


        m = new Model1();
        m.setTitle("Laboratories");
        m.setImg(R.drawable.labs);
        models.add(m);


        m = new Model1();
        m.setTitle("Blood Banks");
        m.setImg(R.drawable.blood_bank);
        models.add(m);


        m = new Model1();
        m.setTitle("Hospital Login");
        m.setImg(R.drawable.login);
        models.add(m);


        return models;

    }




    /*public void aep(View view) {

        startActivity(new Intent(this,EnterPhoneNumber.class));


    }

    public void hi(View view) {
        startActivity(new Intent(this, HospitalLogin.class));


    }*/

    /*public void hey(View view) {
        startActivity(new Intent(this, GetUserLocation.class));


    }*/

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_arrow) {
            Intent myintent = new Intent(MainActivity.this,
                    NewActivity.class);
            startActivity(myintent);

            return false;


        }
        return true;
    }


}



