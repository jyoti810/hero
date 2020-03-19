package com.example.hero;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder2 extends RecyclerView.ViewHolder {

    public TextView txtusername;
    public TextView txtphone;
    public TextView txtlabtype;
    public TextView txtlabtime;
    public CategoryViewHolder2(@NonNull View itemView) {
        super(itemView);
        txtusername=itemView.findViewById(R.id.textView_labname);
        txtphone=itemView.findViewById(R.id.textView_phone);
        txtlabtype=itemView.findViewById(R.id.textView_types);
        txtlabtime=itemView.findViewById(R.id.textView_timings);
    }

}
