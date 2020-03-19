package com.example.hero;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView mImaeView;
    TextView mTitle;
    ItemClickListener itemClickListener;
    private Context c;
    Intent intent = new Intent();

    public MyHolder( View itemView) {
        super(itemView);
        c = itemView.getContext();

        this.mImaeView = itemView.findViewById(R.id.imageIv);
        this.mTitle = itemView.findViewById(R.id.titleTv);

        itemView.setOnClickListener(this);
        itemView.setClickable(true);

    }
    @Override
    public void onClick(View v) {


        switch (getAdapterPosition()){
            case 0:
                intent = new Intent(c,DisplayHospitals.class);
                break;
            case 1:
                intent = new Intent(c,DisplayLabs.class);
                break;
            /*case 2:
                intent = new Intent(c,HospitalLogin.class);
                break;*/
            case 3:
                intent = new Intent(c,HospitalLogin.class);
                break;

            default:

        }
        c.startActivity(intent);


    }







    public void setItemClickListener(ItemClickListener ic){

        this.itemClickListener = ic;
    }


}