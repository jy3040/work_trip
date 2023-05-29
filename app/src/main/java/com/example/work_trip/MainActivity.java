package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[]={R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView=findViewById(R.id.recommended_course_cards);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        s1=getResources().getStringArray(R.array.card_recommended_course_subName);
        s2=getResources().getStringArray(R.array.card_recommended_course_subName);

        CardAdapter adapter=new CardAdapter(this, s1, s2, images);



    }
}