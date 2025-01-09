package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.elite.AdapterClass.UserChaterAdapter;
import com.example.elite.Model.UserChaterModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserChaterActivity extends AppCompatActivity {

    CircleImageView profile;
    RecyclerView recyclerView;
    ArrayList<UserChaterModel> usserArry=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_user_chater);
        profile=findViewById(R.id.userchat_profile);
        recyclerView=findViewById(R.id.userChatter_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        UserChaterModel model1 =new UserChaterModel(R.drawable.simle_emoji,"Gauri"," Nebhwani");
        usserArry.add(model1);
        UserChaterModel model2 =new UserChaterModel(R.drawable.happy_emoji,"Sima"," Kutemate");
        usserArry.add(model2);
        UserChaterModel model3 =new UserChaterModel(R.drawable.smart,"Prerna"," Manowar");
        usserArry.add(model3);
        UserChaterModel model4 =new UserChaterModel(R.drawable.sad,"ram"," Nebhwani");
        usserArry.add(model4);
        UserChaterModel model5 =new UserChaterModel(R.drawable.angry,"Priyanka"," Nebhwani");
        usserArry.add(model5);
        UserChaterModel model6 =new UserChaterModel(R.drawable.chatbot,"Krish"," Nebhwani");
        usserArry.add(model6);

        UserChaterAdapter adapter = new UserChaterAdapter(this,usserArry);
        recyclerView.setAdapter(adapter);
    }
}