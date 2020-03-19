package com.example.hero.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hero.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    public TextView txtusername;
    public TextView txtphone;
    public TextView txticu;
    public TextView txttimings;
    public TextView txttypes;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        txtusername=itemView.findViewById(R.id.textView_username);
        txtphone=itemView.findViewById(R.id.textView_phone);
        txticu=itemView.findViewById(R.id.textView_icu);
        txttimings=itemView.findViewById(R.id.textView_timings);
        txttypes=itemView.findViewById(R.id.textView_types);
    }
}
