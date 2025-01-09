package com.example.elite.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.elite.R;

public class AdminLoginActivity extends AppCompatActivity {
    ImageView admin_threedot;
    Button adminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        admin_threedot = findViewById(R.id.admin_threedots);

        adminlogin = findViewById(R.id.Admin_Login_button);

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminLoginActivity.this, AdminDashboradActivity.class);
                startActivity(i);
                finish();
            }
        });
        admin_threedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(AdminLoginActivity.this, admin_threedot);
                popupMenu.getMenuInflater().inflate(R.menu.popup_admin_help, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.Admin_Help) {
                            Intent intent1 = new Intent(AdminLoginActivity.this, AdminHelpActivity.class);
                            startActivity(intent1);
                            return true;
                        }
                        return true;

                    }
                });
                popupMenu.show();

            }

        });
    }

}