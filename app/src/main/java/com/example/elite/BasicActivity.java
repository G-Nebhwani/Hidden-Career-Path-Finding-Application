package com.example.elite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        if (getSupportActionBar() != null) {
            // Option 1: Set color from color resource
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(ContextCompat.getColor(this, R.color.app_green)));

            // Option 2: Set color directly using Color class
            // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5733")));
        }

    }
}