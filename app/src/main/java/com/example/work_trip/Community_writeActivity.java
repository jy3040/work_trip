package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivityCommunityWriteBinding;
import com.example.work_trip.databinding.ActivitySignUp01Binding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Community_writeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private ActivityCommunityWriteBinding binding;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


    String id;
    String title;
    String money;
    String duration;
    String people;
    String content;
    String date;
    String name;
    String thema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommunityWriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        binding.thema.setOnCheckedChangeListener(this);

        binding.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 작성한 데이터
                title =  binding.tv2.getText().toString();
                money =  binding.tv4.getText().toString();
                duration =  binding.tv6.getText().toString();
                people =  binding.tv10.getText().toString();
                content =  binding.tv8.getText().toString();


                if(title.equals("")){
                    Toast.makeText(Community_writeActivity.this, "제목을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if(money.equals("")){
                    Toast.makeText(Community_writeActivity.this, "사용 금액을 입력해주세요", Toast.LENGTH_SHORT).show();

                }
                else if(duration.equals("")){
                    Toast.makeText(Community_writeActivity.this, "기간을 입력해주세요", Toast.LENGTH_SHORT).show();

                }
                else if(people.equals("")){
                    Toast.makeText(Community_writeActivity.this, "참가 인원 수를 입력해주세요", Toast.LENGTH_SHORT).show();

                }
                else if(content.equals("")){
                    Toast.makeText(Community_writeActivity.this, "후기을 입력해주세요", Toast.LENGTH_SHORT).show();

                }
                else if(thema.equals("")){
                    Toast.makeText(Community_writeActivity.this, "테마를 선택해주세요", Toast.LENGTH_SHORT).show();

                }
                else{
                    // 작성 시간 설정
                    mNow = System.currentTimeMillis();
                    mDate = new Date(mNow);
                    date = mFormat.format(mDate);

                    // 좋아요 수 랜덤 설정
                    String good = String.valueOf((int)(Math.random() * (300 - 20 + 1) + 20));

                    // db 객체 생성
                    CommunityDBHelper communityDB = new CommunityDBHelper(getApplicationContext());

                    //db에 저장하기
                    int result = communityDB.addData(title,date,name,money,duration,people,good,null,content, thema);

                    if(result == 1){
                        finish();
                    }
                }



            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case  R.id.thema1:
                thema = binding.thema1.getText().toString();
                break;
            case  R.id.thema2:
                thema = binding.thema2.getText().toString();
                break;
            case  R.id.thema3:
                thema = binding.thema3.getText().toString();
                break;
            case  R.id.thema4:
                thema = binding.thema4.getText().toString();
                break;
            case  R.id.thema5:
                thema = binding.thema5.getText().toString();
                break;
        }
    }
}