package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class CounselorDeatilsActivity extends AppCompatActivity {
    TextView nameTextView ,ratingTextView,priceTextView, experienceTextView,detailTextView;
    ImageView profileImageView;
    Button bookslot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_deatils);
        // Set up the ActionBar with background color, title, and back button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(ContextCompat.getColor(this, R.color.app_green)));

            // Create a TextView for custom title styling
            TextView titleTextView = new TextView(this);
            titleTextView.setText("Counsellor Details");
            titleTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
            titleTextView.setTextSize(20);

            // Set the custom title view in the ActionBar
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setCustomView(titleTextView);

            // Enable the back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.white_back); // Optional: custom back icon

            bookslot=findViewById(R.id.bookstot_btn);
            bookslot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(CounselorDeatilsActivity.this, BookSlotActivity.class);
                    startActivity(i);
                }
            });

            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            String detail = intent.getStringExtra("detail");
            String experience = intent.getStringExtra("experience");
            String price = intent.getStringExtra("price");
            String rating = intent.getStringExtra("rating");
            String profileImageUrl = intent.getStringExtra("profileImageUrl");

            nameTextView = findViewById(R.id.ccDetail_name);
             detailTextView = findViewById(R.id.ccDetail_detail);
             experienceTextView = findViewById(R.id.ccDetail_yearofExp);
            priceTextView = findViewById(R.id.ccDetail_Price);
            ratingTextView = findViewById(R.id.ccDetail_ranting);
            profileImageView = findViewById(R.id.ccDetail_ProfilePic);

            nameTextView.setText(name);
            detailTextView.setText(detail);
            experienceTextView.setText(experience);
            priceTextView.setText(price);
            ratingTextView.setText(rating);
            Picasso.get().load(APIs.image+profileImageUrl).into(profileImageView);
        }
    }

    // Handle the back button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Navigate back when the back button is pressed
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}