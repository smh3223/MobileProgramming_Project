package com.example.teamproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listview1;
    ArrayList<Board> board1 = new ArrayList<Board>();

    ArrayDeque<Board> board2 = new ArrayDeque<Board>();

    Button button1;
    EditText edittext1;
    EditText edittext2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview1 = (ListView) findViewById(R.id.listView);
        final MyAdapter adapter = new MyAdapter(this);
        listview1.setAdapter(adapter);

        button1 = (Button) findViewById(R.id.button21);
        edittext1 = (EditText) findViewById(R.id.edittext21);
        edittext2 = (EditText) findViewById(R.id.edittext22);


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


        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                click1button(v);
            }
        });


    }

    public void click1button(View v)
    {
        SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        Board board = new Board(edittext1.getText().toString(),dateform.format(date).toString(),edittext2.getText().toString(),1);
        database.child("message").push().setValue(board);
        edittext1.setText("");
        edittext2.setText("");

        Toast.makeText(this, "글을 등록했습니다", Toast.LENGTH_SHORT).show();

    }

}
