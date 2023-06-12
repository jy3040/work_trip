package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivitySignUp021Binding;
import com.example.work_trip.databinding.ActivitySignUp02Binding;

public class SignUp02_1Activity extends AppCompatActivity  implements View.OnClickListener {

    private ActivitySignUp021Binding binding;
    String id;
    String password;
    String name;

    String birth;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up021);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        password = intent.getStringExtra("password");
        name = intent.getStringExtra("name");
        birth = intent.getStringExtra("birth");
        email = intent.getStringExtra("email");

        binding.ibNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_next:
                if(!(binding.etCompany.getText().toString().equals("")) && !(binding.etDepartment.getText().toString().equals("")) && !(binding.etPosition.getText().toString().equals(""))){

                    Intent it = new Intent(this, SignUp03Activity.class);
                    it.putExtra("id", id);
                    it.putExtra("password",password);
                    it.putExtra("name", name);
                    it.putExtra("birth",birth);
                    it.putExtra("email", email);
                    it.putExtra("company", binding.etCompany.getText().toString());
                    it.putExtra("department",binding.etDepartment.getText().toString());
                    it.putExtra("position", binding.etPosition.getText().toString());

                    startActivity(it);
                    finish();
                }
                else{
                    if(binding.etCompany.getText().toString().equals("")){
                        Toast.makeText(this, "회사 이름을 채워주세요",Toast.LENGTH_LONG).show();
                    }
                    else if(binding.etDepartment.getText().toString().equals("")){
                        Toast.makeText(this, "부서 이름을 채워주세요",Toast.LENGTH_LONG).show();

                    }
                    else if(binding.etPosition.getText().toString().equals("")){
                        Toast.makeText(this, "직급을 채워주세요",Toast.LENGTH_LONG).show();

                    }
                }
                break;


        }
    }
}