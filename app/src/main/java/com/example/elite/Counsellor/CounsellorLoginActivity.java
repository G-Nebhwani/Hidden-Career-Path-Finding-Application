package com.example.elite.Counsellor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.example.elite.Admin.AdminHelpActivity;
import com.example.elite.R;

public class CounsellorLoginActivity extends AppCompatActivity {
EditText et_userid,et_password;
ImageView img_threedot;
Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_login);

        et_userid=findViewById(R.id.Counserllor_login_userid);
        et_password=findViewById(R.id.Counserllor_login_password);
        img_threedot=findViewById(R.id.Counserllor_login_threedots);
        btn_login=findViewById(R.id.Counserllor_Login_button);

        img_threedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(CounsellorLoginActivity.this,img_threedot);
                popupMenu.getMenuInflater().inflate(R.menu.popup_admin_help,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.Admin_Help){
                            Intent i=new Intent(CounsellorLoginActivity.this, AdminHelpActivity.class);
                            startActivity(i);
                            return true;

                        }
                        return true;
                    }
                });
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_userid.getText().toString().isEmpty()){
                    et_userid.setError("Please Enter the UserName");
                } else if (et_password.getText().toString().isEmpty()) {
                    et_password.setError("Enter Password");
                } else if (et_password.getText().toString().length() < 8) {
                    et_password.setError("Password must be greater than 8");
                } else if (!et_password.getText().toString().matches("(.*[@#$&%*+].*)")) {

                    et_password.setError("must contain Special Symbol");
                }else{
                    Intent i=new Intent(CounsellorLoginActivity.this, CounsellorDashbordActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}