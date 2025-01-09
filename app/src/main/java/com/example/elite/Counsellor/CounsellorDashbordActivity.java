package com.example.elite.Counsellor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.elite.AdapterClass.CounsellorUserChaterAdapter;
import com.example.elite.Model.CounsellorChaterModel;
import com.example.elite.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CounsellorDashbordActivity extends AppCompatActivity {
ImageView chatting;
CircleImageView profile;
ArrayList<CounsellorChaterModel> userArr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_dashbord);
        chatting=findViewById(R.id.counserllor_dt_chatting);
        profile=findViewById(R.id.counserllor_Profileimg);

        RecyclerView recyclerView= findViewById(R.id.Counserllor_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CounsellorChaterModel model1=new CounsellorChaterModel(R.drawable.userimg,"Mr Peter","How are you");
        userArr.add(model1);
        CounsellorChaterModel model2=new CounsellorChaterModel(R.drawable.userimg,"Mr Peter","How are you");
        userArr.add(model2);
        CounsellorChaterModel model3=new CounsellorChaterModel(R.drawable.userimg,"Mr Peter","How are you");
        userArr.add(model3);
        CounsellorUserChaterAdapter adapter=new CounsellorUserChaterAdapter(this,userArr);
        recyclerView.setAdapter(adapter);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CounsellorDashbordActivity.this, CounsellorProfileActivity.class);
                startActivity(i);
            }
        });

        chatting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CounsellorDashbordActivity.this, Counsellor_ChattingActivity.class);
                startActivity(i);
            }
        });


    }
}