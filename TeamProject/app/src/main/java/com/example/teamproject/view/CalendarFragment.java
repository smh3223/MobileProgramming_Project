package com.example.teamproject.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.teamproject.R;
import com.example.teamproject.databinding.FragmentCalendarBinding;

public class CalendarFragment extends Fragment {
    FragmentCalendarBinding fragmentCalendarBinding;
    private String SelectedDay; //디폴트는 당일

    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentCalendarBinding = FragmentCalendarBinding.inflate(inflater, container, false);

        
        
        //버튼 onClick 시
        //바인딩.selectedDate(?).OnClick 리스너->뷰모델에 만들어놓은'임의의 날짜 클릭시 에딧텍스트(제목, 내용) 보여주는 메소드' 갖다쓰기
        //바인딩.+버튼.OnClick 리스너->버튼 누르면 일정 추가 메소드(달력의 해당 날짜에 빨간색 동그라미표시 생성)' 갖다쓰기


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }
}