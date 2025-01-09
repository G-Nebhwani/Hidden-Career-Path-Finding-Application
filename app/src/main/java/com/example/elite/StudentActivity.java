package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StudentActivity extends BasicActivity {
    private Button after10, after12;
    private LinearLayout group1, group2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        // Customizing ActionBar
        if (getSupportActionBar() != null) {
            // Set ActionBar background color
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(ContextCompat.getColor(this, R.color.app_green))
            );

            // Create a custom TextView for ActionBar title
            TextView titleTextView = new TextView(this);
            titleTextView.setText("Hello Student");
            titleTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
            titleTextView.setTextSize(20);
            titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            titleTextView.setPadding(10, 0, 0, 0); // Adjust padding for alignment

            // Apply custom title
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setCustomView(titleTextView);

            // Enable back button with custom icon
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.white_back);
        }

        // Initialize buttons and groups
        after10 = findViewById(R.id.button1);
        after12 = findViewById(R.id.button2);
        group1 = findViewById(R.id.group1);
        group2 = findViewById(R.id.group2);

        // Button click listeners
        after10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(group1, group2);
            }
        });

        after12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisibility(group2, group1);
            }
        });
    }

    // Toggle visibility between groups
    private void toggleVisibility(LinearLayout toShow, LinearLayout toHide) {
        if (toShow.getVisibility() == View.GONE) {
            toShow.setVisibility(View.VISIBLE);
            toHide.setVisibility(View.GONE);
        } else {
            toShow.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Handle back navigation
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
