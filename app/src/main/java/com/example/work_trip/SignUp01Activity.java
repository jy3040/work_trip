package com.example.work_trip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.work_trip.databinding.ActivitySignUp01Binding;

import org.w3c.dom.Text;

public class SignUp01Activity extends AppCompatActivity implements View.OnClickListener {
    // 데이터 바인딩을 위한 객체 생성
    private ActivitySignUp01Binding binding;
    boolean password_visibility_1 = false;
    boolean password_visibility_2 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up01);
        // 버튼 비활성화

        // 입력받은 값 받아오기
        binding.ibNext.setOnClickListener(this);
        binding.ibPw1Visibility.setOnClickListener(this);
        binding.ibPw2Visibility.setOnClickListener(this);
        binding.ibDoubleCheck.setOnClickListener(this);

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
                Log.d("aa", binding.etId.getText().toString() + binding.etPw1.getText().toString() + binding.tvPw2Error.getText().toString());

                if(binding.etId.getText().toString().equals("")){
                    Toast.makeText(this,"아이디를 입력해주세요",Toast.LENGTH_LONG).show();

                }
                else if(binding.etPw1.getText().toString().equals(null)){
                    Toast.makeText(this,"비밀번호를 입력해주세요",Toast.LENGTH_LONG).show();


                } else if (!(binding.tvPw2Error.getText().toString().equals("일치합니다."))) {
                    Toast.makeText(this,"비밀번호를 일치시켜주세요",Toast.LENGTH_LONG).show();
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
                password_visibility_1 = !password_visibility_1;
                if(password_visibility_1){
                    binding.etPw1.setInputType(InputType.TYPE_CLASS_TEXT);

                }else{

                    binding.etPw1.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
                break;
            case R.id.ib_pw2_visibility:
                password_visibility_2 = !password_visibility_2;
                if(password_visibility_2){
                    binding.etPw2.setInputType(InputType.TYPE_CLASS_TEXT);

                }else{
                    binding.etPw2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
                break;
            case R.id.ib_double_check:

                try{

                    DBHelper helper;
                    helper = new DBHelper(this, "members.db", null, 1);
                    SQLiteDatabase db;
                    db = helper.getReadableDatabase();
                    helper.onCreate(db);
                    String sql = "select * from members;";
                    Cursor c = db.rawQuery(sql, null);
                    boolean check = false;
                    while(c.moveToNext()){
                        if(c.getString(1).equals(binding.etId.getText().toString())){
                            check = true;
                            break;
                        }
                        else{
                            check = false;
                        }

                    }
                    if(!check){
                        Toast.makeText(this, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        new AlertDialog.Builder(this)
                                .setTitle("아이디 중복 확인")
                                .setMessage("이미 존재하는 아이디입니다. \n 아이디를 다시 설정해주세요")
                                .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dlg, int sumthin) {
                                    }
                                })
                                .show(); // 팝업창 보여줌
                    }
                    db.close();

                }
                catch (SQLException e){
                    Log.d("DB", e.toString());
                }


        }
    }

}