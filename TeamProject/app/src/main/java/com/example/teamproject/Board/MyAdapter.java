package com.example.teamproject.Board;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamproject.Board.Board;
import com.example.teamproject.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Board> data = new ArrayList<Board>();
    MyAdapter(Context context)
    {
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return data.get(position).getType();
    }

    @Override
    public int getViewTypeCount()
    {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        int viewType = getItemViewType(position);

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_lay, parent, false);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.textView);
        TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);
        TextView textView3 = (TextView) convertView.findViewById(R.id.textView3);

        final Board board = data.get(data.size()-1 - position);

        textView1.setText(board.getTitle());
        textView2.setText(board.getDate());
        textView3.setText(board.getContent());


        LinearLayout itemLay = (LinearLayout)convertView.findViewById(R.id.ListArea);
        itemLay.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Toast.makeText(v.getContext(),board.getTitle().toString() + board.getContent().toString(),Toast.LENGTH_SHORT).show();
            }

        });


        return convertView;

    }

    public void Add(Board b)
    {
        data.add(b);
    }





}