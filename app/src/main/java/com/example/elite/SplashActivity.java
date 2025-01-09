package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    Animation animation;
    SharedPreferences   sharedPreferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=findViewById(R.id.splash_logo);
        animation= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.fadein);
        imageView.setAnimation(animation);
        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                if (sharedPreferences.getBoolean("islogin",false)){
                    startActivity(new Intent(SplashActivity.this,DashboardActivity.class));
                }
                else{
                    Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },1500);
    }

}