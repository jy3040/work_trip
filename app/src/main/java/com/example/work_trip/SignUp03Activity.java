package com.example.work_trip;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivitySignUp02Binding;
import com.example.work_trip.databinding.ActivitySignUp03Binding;

public class SignUp03Activity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    String id;
    String password;
    String name;

    String birth;
    String email;

    private ActivitySignUp03Binding binding;
    String check_thema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up03);

        DBHelper helper;
        SQLiteDatabase db;
        helper = new DBHelper(this, "member.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        password = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        birth = intent.getStringExtra("birth");
        email = intent.getStringExtra("email");

        binding.thema.setOnCheckedChangeListener(this);

        binding.ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(check_thema.equals(""))){
                    // sql 처리
                    String sql = "INSERT INTO mytable('txt') values('Bulgogi');";
                    db.execSQL(sql);

                    Intent it = new Intent(getApplicationContext(), SignUp04Activity.class);
                    it.putExtra("name", name);
                    startActivity(it);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "선택해주세요",Toast.LENGTH_LONG);
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case  R.id.thema1:
                check_thema = binding.thema1.getText().toString();
            case  R.id.thema2:
                check_thema = binding.thema2.getText().toString();
            case  R.id.thema3:
                check_thema = binding.thema3.getText().toString();
            case  R.id.thema4:
                check_thema = binding.thema4.getText().toString();
            case  R.id.thema5:
                check_thema = binding.thema5.getText().toString();
        }
    }
}