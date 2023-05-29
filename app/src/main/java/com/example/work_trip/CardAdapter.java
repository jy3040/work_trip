package com.example.work_trip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.wtViewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public CardAdapter(Context ct, String s1[], String s2[], int img[])
    {
        context=ct;
        data1=s1;
        data2=s2;
        images=img;

    }

    @NonNull
    @Override
    public wtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activity_home, parent, false);
        return new wtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wtViewHolder holder, int position) {
        holder.tv1.setText(data1[position]);
        holder.tv2.setText(data2[position]);
        holder.iv.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class wtViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2;
        ImageView iv;
        public wtViewHolder(View itemView)
        {
            super(itemView);
            tv1=itemView.findViewById(R.id.card_recommended_course_subtitle);
            tv2=itemView.findViewById(R.id.card_recommended_course_title);
            iv=itemView.findViewById(R.id.card_recommended_course_background);

        }
    }
}
