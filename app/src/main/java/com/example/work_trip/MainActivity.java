package com.example.work_trip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //네비게이션바 변수
    BottomNavigationView bottomNavigationView;

    //fragment 변수
    Fragment fragment_home;
    Fragment fragment_community;

    //리사이클러뷰 변수
    RecyclerView recyclerView;

    //리사이클러뷰 관련
    /*String s1[], s2[];
    int images[]={R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1,
            R.drawable.card_recommended_course_sample1};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //리사이클러뷰 관련
        /*recyclerView=findViewById(R.id.recommended_course_cards);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        s1=getResources().getStringArray(R.array.card_recommended_course_subName);
        s2=getResources().getStringArray(R.array.card_recommended_course_subName);

        CardAdapter adapter=new CardAdapter(this, s1, s2, images);*/

        //fragment 생성
        fragment_home=new fragment_home();
        fragment_community=new fragment_community();

        //네비게이션바
        bottomNavigationView=findViewById(R.id.bottom_navigation);

        //네비게이션 리스너
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Log.i(tag, "바텀 네비게이션 클릭");

                switch (item.getItemId())
                {
                    case R.id.action_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_layout, fragment_home).commitAllowingStateLoss();
                        break;

                    case R.id.action_community:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_layout, fragment_community).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });

    }
}