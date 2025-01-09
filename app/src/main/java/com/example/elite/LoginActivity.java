package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.elite.Admin.AdminLoginActivity;
import com.example.elite.Common.Urls;
import com.example.elite.Counsellor.CounsellorLoginActivity;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText Email, Password;
    Button login_btn;
    TextView registation_page;
    ImageView threedot;
    ProgressDialog progressDialog;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registation_page = findViewById(R.id.login_reg);
        login_btn = findViewById(R.id.Login_button);
        Email = findViewById(R.id.login_emailid);
        Password = findViewById(R.id.login_password);
//        loginUser("omwanve@gmail.com","12345");
        threedot = findViewById(R.id.login_threedots);

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        threedot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PopupMenu popupMenu = new PopupMenu(LoginActivity.this, threedot);
                popupMenu.getMenuInflater().inflate(R.menu.popup_usertype, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.login_Admin) {
                            Intent intent1 = new Intent(LoginActivity.this, AdminLoginActivity.class);
                            startActivity(intent1);
                            return true;
                        }
                        if (item.getItemId() == R.id.login_counsellor) {
                            Intent intent1 = new Intent(LoginActivity.this, CounsellorLoginActivity.class);
                            startActivity(intent1);
                            return true;
                        }
                        return true;

                    }
                });
                popupMenu.show();

            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Email.getText().toString().isEmpty()) {
                    Email.setError("Please Enter the UserName");
                } else if (!Email.getText().toString().contains("@") || !Email.getText().toString().contains(".com")) {
                    Email.setError("Enter Valid Email");
                } else if (Password.getText().toString().isEmpty()) {
                    Password.setError("Enter Password");
//                } else if (Password.getText().toString().length() < 8) {
//                    Password.setError("Password must be greater than 8");
//                } else if (!Password.getText().toString().matches("(.*[@#$&%*+].*)")) {
//
//                    Password.setError("must contain Special Symbol");
                }
                    else{
                        progressDialog = new ProgressDialog(LoginActivity.this);
                        progressDialog.setTitle("Login User");
                        progressDialog.setCancelable(false);
                        progressDialog.setCanceledOnTouchOutside(false);
                        progressDialog.setMessage("Please wait.......");
                        progressDialog.show();
                        Intent i=new Intent(LoginActivity.this,DashboardActivity.class);
                        startActivity(i);
                        finish();
//                        loginUser(Email.getText().toString(),Password.getText().toString());
                    }


            }
        });


        registation_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    private void loginUser(String email, String password) {
        Map<String, String> params = new HashMap<>();
        Log.d("Testing",email+" "+password);
        params.put("email", email);
        params.put("password", password);

        APIRequestHandler apiRequestHandler = new APIRequestHandler(
                this,
                APIs.user_login, // Your login API endpoint
                params,
                null, // No auth token
                null // No progress overlay
        );

        apiRequestHandler.sendRequest(new APIRequestHandler.APICallback() {
            @Override
            public void onSuccess(JSONObject response) {

                try {
                    String status = response.getString("status");
                    String message=response.getString("message");

                    if (status.equals("success")){
                        JSONObject object=response.getJSONObject("data");

                        String userId = object.getString("id");
                        String userEmail = object.getString("email");
                        String userName = object.getString("name");
                        Toast.makeText(LoginActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                        // Store data in SharedPreferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("userId", userId);
                        editor.putString("userEmail", userEmail);
                        editor.putString("userName", userName);
                        editor.putBoolean("islogin",true);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));

                        progressDialog.dismiss();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                    }


                    Toast.makeText(LoginActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String error) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
 });}



}