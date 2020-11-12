package com.example.teamproject.Board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.teamproject.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteActivity extends AppCompatActivity {

    Button button1;
    EditText edittext1;
    EditText edittext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        button1 = (Button) findViewById(R.id.button21);
        edittext1 = (EditText) findViewById(R.id.edittext21);
        edittext2 = (EditText) findViewById(R.id.edittext22);

        edittext2.setHorizontallyScrolling(false);

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

        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);

        setResult(RESULT_OK,myIntent);
        finish();

    }

}
