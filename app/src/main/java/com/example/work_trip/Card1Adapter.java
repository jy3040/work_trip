package com.example.work_trip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

public class Card1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ViewGroup viewGroup;

    @NonNull
    @Override
    //inflate
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //View view= LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.card_recommended_course, viewGroup, false);
        //return new RecyclerView.ViewHolder(view);
        return null;
    }

    @Override
    //항목 구성
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
