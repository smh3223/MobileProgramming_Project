package com.example.teamproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WriteBoard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WriteBoard extends Fragment {

//    Button button1;
//    EditText edittext1;
//    EditText edittext2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WriteBoard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WriteBoard.
     */
    // TODO: Rename and change types and number of parameters
    public static WriteBoard newInstance(String param1, String param2) {
        WriteBoard fragment = new WriteBoard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_write_board, container, false);
//
//
//        button1 = (Button) rootView.findViewById(R.id.button21);
//        edittext1 = (EditText) rootView.findViewById(R.id.edittext21);
//        edittext2 = (EditText) rootView.findViewById(R.id.edittext22);
//
//        button1.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = new Date();
//                DatabaseReference database = FirebaseDatabase.getInstance().getReference();
//                Board board = new Board(edittext1.getText().toString(),dateform.format(date).toString(),edittext2.getText().toString(),1);
//                database.child("message").push().setValue(board);
//                edittext1.setText("");
//                edittext2.setText("");
//
//                Toast.makeText(getContext(), "글을 등록했습니다", Toast.LENGTH_SHORT).show();
//            }
//        });


        return rootView;
    }

}