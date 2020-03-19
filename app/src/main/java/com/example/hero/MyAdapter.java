package com.example.hero;

import android.content.Intent;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Model1> models;

    public MyAdapter(Context c, ArrayList<Model1> models){
        this.c=c;
        this.models=models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, null);

        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myholder, int i) {

        myholder.mTitle.setText(models.get(i).getTitle());
        myholder.mImaeView.setImageResource(models.get(i).getImg());


        myholder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                Intent intent = new Intent(c, EnterPhoneNumber.class);
                c.startActivity(intent);

            }

        });





        /*myholder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                if(models.get(position).getClass().equals("EnterPhoneNumber.class")){


                }
                if(models.get(position).getClass().equals("HospitalLogin.class")){


                }

             }
        });*/




    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
