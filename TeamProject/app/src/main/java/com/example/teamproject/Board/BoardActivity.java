package com.example.teamproject.Board;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.teamproject.Board.Board;
import com.example.teamproject.Board.MyAdapter;
import com.example.teamproject.Board.WriteActivity;
import com.example.teamproject.R;
import com.example.teamproject.WriteBoard;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BoardActivity extends AppCompatActivity {

    //리스트 저장
    ListView listview1;
    ArrayList<Board> board1 = new ArrayList<Board>();
    ArrayDeque<Board> board2 = new ArrayDeque<Board>();

    //게시글 작성 시 제목 / 내용 / 등록 버튼


    // 게시글 작성 프래그먼트 호출
    Button go_write_btn;

    // 프래그먼트
    WriteBoard writeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview1 = (ListView) findViewById(R.id.listView);
        final MyAdapter adapter = new MyAdapter(this);
        listview1.setAdapter(adapter);



        go_write_btn = (Button) findViewById(R.id.go_write_btn);
        writeFragment = new WriteBoard();

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("message").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String s) {

                Board board = snapshot.getValue(Board.class);
                board1.add(board);
                board2.push(board);
                adapter.Add(board);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        go_write_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                go_write_button(v);
            }

        });

    }

    //게시글 등록 함수
//    public void click1button(View v)
//    {
//        SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
//        Board board = new Board(edittext1.getText().toString(),dateform.format(date).toString(),edittext2.getText().toString(),1);
//        database.child("message").push().setValue(board);
//        edittext1.setText("");
//        edittext2.setText("");
//
//        Toast.makeText(this, "글을 등록했습니다", Toast.LENGTH_SHORT).show();
//    }

    public void go_write_button(View v)
    {
        Intent myIntent = new Intent(getApplicationContext(), WriteActivity.class);

        startActivityForResult(myIntent,0);
    }

}
