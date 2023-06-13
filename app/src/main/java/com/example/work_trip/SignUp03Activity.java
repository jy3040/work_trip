package com.example.work_trip;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivitySignUp02Binding;
import com.example.work_trip.databinding.ActivitySignUp03Binding;

public class SignUp03Activity extends AppCompatActivity implements View.OnClickListener {

    String id;
    String password;
    String name;

    String birth;
    String email;
    String position;

    String company;
    String department;
    private ActivitySignUp03Binding binding;
    String check_thema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up03);

        binding.thema1.setOnClickListener(this);
        binding.thema2.setOnClickListener(this);
        binding.thema3.setOnClickListener(this);
        binding.thema4.setOnClickListener(this);
        binding.thema5.setOnClickListener(this);

        DBHelper helper;
        SQLiteDatabase db;
        helper = new DBHelper(this, "members.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        password = intent.getStringExtra("password");
        name = intent.getStringExtra("name");
        birth = intent.getStringExtra("birth");
        email = intent.getStringExtra("email");
        company = intent.getStringExtra("name");
        department = intent.getStringExtra("birth");
        position = intent.getStringExtra("email");


        binding.ibNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(check_thema.equals(""))){
                    // sql 처리
                    try{
                        String sql = "INSERT INTO members(id,password, name) values('" + id
                                + "', '" + password
                                + "', '" + name
                                + "')";
                        db.execSQL(sql);
                        Log.d("DB","회원 테이블에 데이터를 추가했습니다");
                        db.close();

                    }
                    catch (SQLException e){
                        Log.d("DB", e.toString());
                    }

                    try{

                        SQLiteDatabase db2;
                        db2 = helper.getReadableDatabase();
                        helper.onCreate(db2);

                        String sql = "select * from members;";
                        Cursor c = db2.rawQuery(sql, null);
                        while(c.moveToNext()){
                            Log.d("DB",c.getString(0));
                            Log.d("DB",c.getString(1));
                            Log.d("DB",c.getString(2));
                            Log.d("DB",c.getString(3));
                        }
                        db2.close();

                    }
                    catch (SQLException e){
                        Log.d("DB", e.toString());
                    }
                    Intent it = new Intent(getApplicationContext(), SignUp04Activity.class);
                    it.putExtra("name", name);
                    startActivity(it);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(), "테마를 선택해주세요",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.thema1:
                check_thema += binding.thema1.getText().toString() + " ";
            case R.id.thema2:
                check_thema += binding.thema2.getText().toString() + " ";
            case R.id.thema3:
                check_thema += binding.thema3.getText().toString() + " ";
            case R.id.thema4:
                check_thema += binding.thema4.getText().toString() + " ";
            case R.id.thema5:
                check_thema += binding.thema5.getText().toString() + " ";
        }
    }
}