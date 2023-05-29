package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivitySignUp01Binding;

public class SignUp01Activity extends AppCompatActivity implements View.OnClickListener {
    // 데이터 바인딩을 위한 객체 생성
    private ActivitySignUp01Binding binding;

    String id; // id
    String password; // password
    String repassword; // 기존 password 와 비교하기 위한 값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up01);
        // 버튼 비활성화



        // 입력받은 값 받아오기
            binding.ibNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_next:
                if(binding.etId.getText().toString() != "" && binding.etPw1.getText().toString() != "" && binding.etPw2.getText().toString() != "" && (binding.etPw1.getText().toString().equals(binding.etPw2.getText().toString()) )){

                    Log.d("Yerim", binding.etPw1.getText().toString());
                    Log.d("Yerim", binding.etPw2.getText().toString());

                    id = binding.etId.toString();
                    password = binding.etPw1.toString();
                    repassword = binding.etPw2.toString();
                    Intent it = new Intent(this, SignUp02Activity.class);
                    startActivity(it);
                    finish();
                }
                else{
                    Toast.makeText(this, "채워주세요",Toast.LENGTH_LONG);
                }
        }
    }

}