package com.example.work_trip;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.work_trip.databinding.ActivitySignUp01Binding;
import com.example.work_trip.databinding.FragmentCommunityBinding;

import java.util.ArrayList;

public class fragment_community extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private ViewGroup rootView;

    View addwrite;

    RecyclerView recyclerView;
    CommunityDBHelper db;
    Cursor cursor;

    ArrayList<CommunityData> communityList = new ArrayList<>();
    CommunityAdapter adapter;

    RadioGroup radioGroup;
    RadioButton radioButton0;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;

    String name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_community,container,false);

        name = getArguments().getString("name");
        addwrite = rootView.findViewById(R.id.addwrite);

        radioGroup = rootView.findViewById(R.id.thema);

        radioButton0 = rootView.findViewById(R.id.thema0);
        radioButton1 = rootView.findViewById(R.id.thema1);
        radioButton2 = rootView.findViewById(R.id.thema2);
        radioButton3 = rootView.findViewById(R.id.thema3);
        radioButton4 = rootView.findViewById(R.id.thema4);
        radioButton5 = rootView.findViewById(R.id.thema5);

        radioButton0.setChecked(true);

        radioGroup.setOnCheckedChangeListener(this);
        addwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), Community_writeActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

                db.close();
                cursor.close();

            }
        });

        adapter = new CommunityAdapter(getContext());

        recyclerView = rootView.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);

        db = new CommunityDBHelper(getContext());
        storeDataInArrays(0);

        return rootView;
    }

    void storeDataInArrays(int num) {
        switch (num){
            case 1:
                cursor = db.readDatabytag(radioButton1.getText().toString());
                break;
            case 2:
                cursor = db.readDatabytag(radioButton2.getText().toString());
                break;
            case 3:
                cursor = db.readDatabytag(radioButton3.getText().toString());
                break;
            case 4:
                cursor = db.readDatabytag(radioButton4.getText().toString());
                break;
            case 5:
                cursor = db.readDatabytag(radioButton5.getText().toString());
                break;
            default:
                cursor = db.readAllData();
                break;
        }
        if(cursor.getCount() == 0){

            Log.d("DB","데이터가 없습니다.");
        }
        else{
            while (cursor.moveToNext()){
                CommunityData communityData = new CommunityData(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getBlob(8),
                        cursor.getString(9),
                        cursor.getString(10)); // content의 내용이 필요 없는 부분이기에 null로 설정

                // 데이터 등록
                communityList.add(communityData);
                adapter.addItem(communityData);

                // 적용
                adapter.notifyDataSetChanged();

            }
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case  R.id.thema0:
                storeDataInArrays(0);
                break;
            case  R.id.thema1:
                storeDataInArrays(1);
                break;
            case  R.id.thema2:
                storeDataInArrays(2);
                break;
            case  R.id.thema3:
                storeDataInArrays(3);
                break;
            case  R.id.thema4:
                storeDataInArrays(4);
                break;
            case  R.id.thema5:
                storeDataInArrays(5);
                break;

        }

    }
}