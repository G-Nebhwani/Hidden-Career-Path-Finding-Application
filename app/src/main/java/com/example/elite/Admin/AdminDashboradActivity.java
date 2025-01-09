package com.example.elite.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.elite.BasicActivity;
import com.example.elite.LoginActivity;
import com.example.elite.R;

public class AdminDashboradActivity extends BasicActivity {

    GridLayout mainGrid;

    ImageView admin_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashborad);

        if (getSupportActionBar() != null) {
            // Option 1: Set color from color resource
            getSupportActionBar().setBackgroundDrawable(
                    new ColorDrawable(ContextCompat.getColor(this, R.color.app_green)));

            // Option 2: Set color directly using Color class
            // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5733")));
        }

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
        admin_profile=findViewById(R.id.AdminProfile);

        admin_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminDashboradActivity.this, AdminProfileActivity.class);
                startActivity(i);
            }
        });



    }
       private void setSingleEvent(GridLayout mainGrid) {
            // Loop through each child (CardView) in the GridLayout
            for (int i = 0; i < mainGrid.getChildCount(); i++) {
                // Get each CardView at index i
                CardView cardView = (CardView) mainGrid.getChildAt(i);

                // Set a click listener for each CardView
                final int index = i; // Store index for use in onClick
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Handle click events based on the index or tag
                        handleCardClick(index);
                    }
                });
            }
        }

    private void handleCardClick(int index) {

            switch (index) {
                case 0:
                    // Example: Navigate to CRUD Operation Activity
                    startActivity(new Intent(this, CounsellerOperation_admin.class));
                    break;
                case 1:
                    // Example: Show admin details
                    startActivity(new Intent(this, AdminDetails.class));
                    break;
                case 2:
                    // Example: View review
                    startActivity(new Intent(this, StudentReview_admin.class));
                    break;
                case 3:
                    // Example: Log out action
                    Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
                    showCustomLogoutDialog();
                    break;
                default:
                    Toast.makeText(this, "Card " + (index + 1) + " clicked", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    private void showCustomLogoutDialog() {
        // Inflate custom layout for the dialog
        LayoutInflater inflater = getLayoutInflater();
        View customView = inflater.inflate(R.layout.logout_alter, null);

        // Create an AlertDialog builder with the fragment context
        AlertDialog.Builder builder = new AlertDialog.Builder(AdminDashboradActivity.this);
        builder.setView(customView);  // Set custom view to the dialog

        // Get reference to buttons in the custom layout
        Button btnCancel = customView.findViewById(R.id.btnCancel);
        Button btnConfirm = customView.findViewById(R.id.btnConfirm);

        // Create the AlertDialog object
        AlertDialog dialog = builder.create();

        // Set onClick listener for Cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();  // Close the dialog
            }
        });

        // Set onClick listener for Confirm button (Logout)
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logout action
                logout();
                dialog.dismiss();  // Close the dialog
            }
        });

        // Show the custom dialog
        dialog.show();
    }

    // Handle the logout action
    private void logout() {
        // Add your logout logic here, such as clearing session data or navigating to login screen
        // Example: Redirect to login screen
        Intent intent = new Intent(AdminDashboradActivity.this, LoginActivity.class);
        startActivity(intent);
        AdminDashboradActivity.this.finish();  // Close current activity
    }
}