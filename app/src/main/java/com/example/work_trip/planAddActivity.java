package com.example.work_trip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.util.Pair;

import android.util.Log;
import android.widget.EditText;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import android.app.Fragment;


import com.example.work_trip.databinding.ActivityPlanAddBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class planAddActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityPlanAddBinding binding;
    Calendar calender;
    EditText etPlanPeriod;
    EditText etPlanName;

    //이상함
    Fragment fragmentPlan_ = new Fragment();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_plan_add);

        etPlanName=(EditText)findViewById(R.id.et_plan_name);

        // 버튼
        binding.planDone.setOnClickListener(this);
        binding.calenderPlanPeriod.setOnClickListener(this);

        //캘린더
        calender=Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        Long today=MaterialDatePicker.todayInUtcMilliseconds();

        etPlanPeriod=(EditText) findViewById(R.id.et_plan_period);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plan_done: //완료 버튼
                if (binding.etPlanName.getText().toString().equals("")) {
                    Toast.makeText(this, "일정 이름을 입력해주세요.", Toast.LENGTH_LONG).show();

                } else if (binding.etPlanPeriod.getText().toString().equals("")) {
                    Toast.makeText(this, "기간을 입력해주세요", Toast.LENGTH_LONG).show();

                } else { //일정 추가
                    //Intent it = new Intent(this, fragment_plan.class);
                    //it.putExtra("name", binding.etPlanName.getText().toString());
                    //it.putExtra("period", binding.etPlanPeriod.getText().toString());
                    //startActivity(it);
                    //finish();


                    //문제있음
                    Bundle bundle = new Bundle();
                    bundle.putString("name",binding.etPlanName.getText().toString());
                    bundle.putString("period",binding.etPlanPeriod.getText().toString());
                    fragmentPlan_.setArguments(bundle);

                    replaceFragment();
                }
                break;
            case R.id.calender_plan_period: //캘린더 호출
                //기간 선택 버튼
                MaterialDatePicker.Builder<Pair<Long, Long>> builder=MaterialDatePicker.Builder.dateRangePicker();
                builder.setTitleText("워크숍 기간 선택");

                //미리 날짜 선택
                builder.setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds()));
                MaterialDatePicker materialDatePicker=builder.build();
                materialDatePicker.show(getSupportFragmentManager(), "PLAN_PERIOD");

                //저장 버튼
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair <Long, Long> selection) {
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy년 MM월 dd일");
                        Date departure= new Date();
                        Date arrival= new Date();

                        departure.setTime(selection.first);
                        arrival.setTime(selection.second);

                        String departureString=simpleDateFormat.format(departure).toString();
                        String arrivalString=simpleDateFormat.format(arrival).toString();

                        etPlanPeriod.setText(departureString+" ~ "+arrivalString); //추가 화면의 edit text 칸에 자동 입력
                    }
                });
               break;
        }
    }

    //문제있음
    public void replaceFragment()
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment_plan nPlan=new fragment_plan();
        fragmentTransaction.add(R.id.home_layout, fragmentPlan_);
        //fragmentTransaction.replace(R.id.home_layout,fragmentPlan_);
        fragmentTransaction.commit();
    }

}
