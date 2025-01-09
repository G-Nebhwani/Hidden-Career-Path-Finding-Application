package com.example.elite.Counsellor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.elite.AdapterClass.CounsellorChatAdapter;
import com.example.elite.Model.CounsellorChatModel;
import com.example.elite.R;

import java.util.ArrayList;

public class Counsellor_ChattingActivity extends AppCompatActivity {
RecyclerView recycler_gchat;
ArrayList<CounsellorChatModel> data;
CounsellorChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_chatting);
        recycler_gchat=findViewById(R.id.recycler_gchat);
        recycler_gchat.setLayoutManager(new LinearLayoutManager(this));
        data=new ArrayList<CounsellorChatModel>();
        adapter=new CounsellorChatAdapter(data, Counsellor_ChattingActivity.this);

        CounsellorChatModel model=new CounsellorChatModel(1,"hii");
        data.add(model);
        CounsellorChatModel model2=new CounsellorChatModel(2,"hello");
        data.add(model2);
        adapter.notifyDataSetChanged();
        recycler_gchat.setAdapter(adapter);



    }
}