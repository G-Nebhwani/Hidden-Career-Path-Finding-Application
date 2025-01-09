package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BookSlotActivity extends AppCompatActivity {
    TextView actualDatetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_slot);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(ContextCompat.getColor(this, R.color.app_green)));

            // Create a TextView for custom title styling
            TextView titleTextView = new TextView(this);
            titleTextView.setText("Select a slot");
            titleTextView.setTextColor(ContextCompat.getColor(this, R.color.white));
            titleTextView.setTextSize(20);

            // Set the custom title view in the ActionBar
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setCustomView(titleTextView);

            // Enable the back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.white_back); // Optional: custom back icon



            actualDatetext=findViewById(R.id.actualDate);
            updateYearTextView();

        }
    }

    private void updateYearTextView() {
        Date currentMothYear=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMMM(Y)", Locale.getDefault());
        String FormatedDate=dateFormat.format(currentMothYear);
        actualDatetext.setText(FormatedDate);
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
