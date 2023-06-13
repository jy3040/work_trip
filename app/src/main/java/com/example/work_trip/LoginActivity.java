package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivityLoginBinding;
import com.example.work_trip.databinding.ActivitySignUp021Binding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.ibNext.setOnClickListener(this);

        binding.tvSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_next:

                try{

                    DBHelper helper;
                    helper = new DBHelper(this, "members.db", null, 1);
                    SQLiteDatabase db;
                    db = helper.getReadableDatabase();
                    helper.onCreate(db);
                    String sql = "select * from members;";
                    Cursor c = db.rawQuery(sql, null);
                    boolean check_id = false;
                    boolean check_password = false;
                    while(c.moveToNext()){
                        if(c.getString(1).equals(binding.etId.getText().toString())){
                            check_id = true;
                            if(c.getString(2).equals(binding.etPassword.getText().toString())){
                                check_password = true;
                                Intent it = new Intent(this, MainActivity.class);
                                it.putExtra("name", c.getString(1));
                                startActivity(it);
                                finish();
                                break;
                            }
                        }
                    }
                    if(!check_id){
                        Toast.makeText(this, "일치하는 아이디가 없습니다.", Toast.LENGTH_LONG).show();
                    }
                    else if(!check_password){
                        Toast.makeText(this, "비밀번호가 틀렸습니다. 다시 입력해주세요", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "로그인에 성공했습니다!", Toast.LENGTH_SHORT).show();

                    }


                }
                catch (SQLException e){
                    Log.d("DB", e.toString());
                }
                break;
            case R.id.tv_sign_up:
                Intent intent = new Intent(this, SignUp01Activity.class);
                startActivity(intent);
                break;
        }

    }
}