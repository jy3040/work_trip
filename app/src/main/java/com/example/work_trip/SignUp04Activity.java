package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.work_trip.databinding.ActivitySignUp03Binding;
import com.example.work_trip.databinding.ActivitySignUp04Binding;

public class SignUp04Activity extends AppCompatActivity {

    String id;
    String password;
    String name;

    String birth;
    String email;
    String thema;

    private ActivitySignUp04Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up04);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        binding.tvName.setText(name + "님,");

        binding.ibDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }
}