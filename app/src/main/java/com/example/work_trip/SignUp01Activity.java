package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivitySignUp01Binding;

import org.w3c.dom.Text;

public class SignUp01Activity extends AppCompatActivity implements View.OnClickListener {
    // 데이터 바인딩을 위한 객체 생성
    private ActivitySignUp01Binding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up01);
        // 버튼 비활성화

        // 입력받은 값 받아오기
        binding.ibNext.setOnClickListener(this);
        binding.ibPw1Visibility.setOnClickListener(this);
        binding.ibPw2Visibility.setOnClickListener(this);

        // 아이디 중복 확인 프로세스

        binding.etPw2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.tvPw2Error.setVisibility(View.VISIBLE);
                if(binding.etPw2.getText().toString().equals(binding.etPw1.getText().toString())){
                    binding.tvPw2Error.setText("일치합니다.");
                }
                else{
                    binding.tvPw2Error.setText("일치하지 않습니다.");
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_next:
                if(binding.etId.getText().toString().equals("")){
                    Toast.makeText(this,"아이디를 입력해주세요",Toast.LENGTH_LONG);

                }
                else if(binding.etPw1.getText().toString().equals("")){
                    Toast.makeText(this,"비밀번호를 입력해주세요",Toast.LENGTH_LONG);


                } else if (!(binding.tvPw2Error.getText().toString().equals("일치합니다."))) {
                    Toast.makeText(this,"비밀번호를 일치시켜주세요",Toast.LENGTH_LONG);
                }
                else{
                    Intent it = new Intent(this, SignUp02Activity.class);
                    it.putExtra("id", binding.etId.getText().toString());
                    it.putExtra("password", binding.etPw2.getText().toString());
                    startActivity(it);
                    finish();
                }
                break;
            case R.id.ib_pw1_visibility:
                binding.etPw1.setInputType(InputType.TYPE_CLASS_TEXT);
                // 다시 클릭하면 원상복구 가능하게
                break;
            case R.id.ib_pw2_visibility:
                binding.etPw2.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
        }
    }

}