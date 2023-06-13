package com.example.work_trip;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_home#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class fragment_home extends Fragment {

    //버튼 포함 변수 선언
    private ViewGroup rootView;
    private LinearLayout card_recommended_course_;
    private ImageButton category_lodging_;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_home.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_home newInstance(String param1, String param2) {
        fragment_home fragment = new fragment_home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public fragment_home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);

        card_recommended_course_ = rootView.findViewById(R.id.card_recommended_course1);
        category_lodging_ = rootView.findViewById(R.id.category_lodging);



        //intent (fragment->activity)
        //추천 코스 카드 클릭
        card_recommended_course_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment라 activity intent와는 다른 방식
                Intent intent = new Intent(getActivity(), CardDetailActivity.class);
                startActivity(intent);

            }
        });

        //카테고리-숙소 클릭
        category_lodging_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment라 activity intent와는 다른 방식
                Intent intent = new Intent(getActivity(), CategoryLoadgingActivity.class);
                startActivity(intent);

            }
        });

        return rootView;
        // Inflate the layout for this fragment
    }
}