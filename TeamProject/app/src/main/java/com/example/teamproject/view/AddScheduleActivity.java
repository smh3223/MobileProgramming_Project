package com.example.teamproject.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teamproject.R;
import com.example.teamproject.databinding.ActivityAddScheduleBinding;
import com.example.teamproject.model.PublicSchedule;

public class AddScheduleActivity extends AppCompatActivity {
    private ActivityAddScheduleBinding addSchBinding;
    private PublicSchedule schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        addSchBinding = ActivityAddScheduleBinding.inflate(getLayoutInflater());

        //저장 누르면
        addSchBinding.saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //입력한 제목-내용 세팅해줌
                schedule.setContents(addSchBinding.addContents.getText().toString());
                schedule.setTitle(addSchBinding.addTitle.getText().toString());

                //데이트 피커에서 년월일 선택하면,,
                addSchBinding.datePicker.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                        schedule.setYear(i);
                        schedule.setMonth(i1);
                        schedule.setDay(i2);
                    }
                });
                /*레포클래스의 publicScheduleList.put(위에 만든 스케쥴객체) 해서 저장할때마다 파베에 데이터 추가
                PublicScheduleList.put(schedule); 왜 안되지...*/

                //프래그먼트의 calendarView 에 점찍어주기
            }
        });
    }
}