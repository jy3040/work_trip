package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.work_trip.databinding.ActivitySignUp02Binding;

import org.w3c.dom.Text;

public class SignUp02Activity extends AppCompatActivity  implements View.OnClickListener {

    private ActivitySignUp02Binding binding;
    String id;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up02);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        password = intent.getStringExtra("password");


        binding.etEmail.addTextChangedListener(textWatcher);

        binding.ibEmailCheck.setOnClickListener(this);
        binding.ibNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_next:
                if(!(binding.etName.getText().toString().equals("")) && !(binding.etBirth.getText().toString().equals("")) && !(binding.etEmail.getText().toString().equals(""))){

                    Log.d("Yerim", binding.etName.getText().toString());
                    Log.d("Yerim", binding.etBirth.getText().toString());

                    Intent it = new Intent(this, SignUp03Activity.class);
                    it.putExtra("id", id);
                    it.putExtra("password",password);
                    it.putExtra("name", binding.etName.getText().toString());
                    it.putExtra("birth", binding.etBirth.getText().toString());
                    it.putExtra("email", binding.etEmail.getText().toString());

                    startActivity(it);
                    finish();
                }
                else{
                    Toast.makeText(this, "채워주세요",Toast.LENGTH_LONG);
                }
                break;
            case R.id.ib_email_check:
                break;


        }
    }

    public String checkEmailForm(String inputText){

        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(inputText);

        if(matcher.find()){
            //이메일 형식에 맞을 때
            return "올바른 이메일 입니다.";

        }else{
            //이메일 형식에 맞지 않을 때
            return "올바른 이메일을 입력해주세요.";

        }
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // 입력하기 전에 조치
            binding.tvEmailError.setVisibility(View.VISIBLE);
            binding.tvEmailError.setText(checkEmailForm(binding.etEmail.getText().toString()));

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // 입력난에 변화가 있을 시 조치
        }

        public void afterTextChanged(Editable s) {
            // 입력이 끝났을 때 조치
        }
    };
}