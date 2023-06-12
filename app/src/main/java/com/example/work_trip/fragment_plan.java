package com.example.work_trip;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_navigation#newInstance} factory method to
 * create an instance of this fragment.
 */

public class fragment_plan extends Fragment {
    //버튼 포함 변수 선언
    private ViewGroup rootView;
    private ImageButton planAdd;
    private Button planAdd2;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_plan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_navigation.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_navigation newInstance(String param1, String param2) {
        fragment_navigation fragment = new fragment_navigation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //일정 추가 후
        //데이터 안 받아와짐
        if (getArguments() != null)
        {
            //값 받아오기
            String getName = getArguments().getString("name");
            String getPeriod = getArguments().getString("period");

            //변수 선언
            androidx.cardview.widget.CardView cardAdded = rootView.findViewById(R.id.card_added_plan);
            TextView notYet = rootView.findViewById(R.id.not_yet_plan);
            TextView addButton = rootView.findViewById(R.id.plan_add_2);

            //카드 보이게
            cardAdded.setVisibility(View.VISIBLE);

            TextView addedPeriod=rootView.findViewById(R.id.added_period);
            TextView addedTitle=rootView.findViewById(R.id.added_title);

            addedPeriod.setText(getPeriod);
            addedTitle.setText(getName);

            //나머지 안 보이게
            notYet.setVisibility(View.GONE);
            addButton.setVisibility(View.GONE);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_plan, container, false);

        rootView = (ViewGroup)inflater.inflate(R.layout.fragment_plan,container,false);

        //버튼
        planAdd = rootView.findViewById(R.id.plan_add);
        planAdd2 = rootView.findViewById(R.id.plan_add_2);


        //버튼 클릭 intent (fragment->activity)
        planAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment라 activity intent와는 다른 방식
                Intent intent = new Intent(getActivity(), planAddActivity.class);
                startActivity(intent);

            }
        });

        planAdd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment라 activity intent와는 다른 방식
                Intent intent = new Intent(getActivity(), planAddActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            }

        });
        return rootView;

    }
}
