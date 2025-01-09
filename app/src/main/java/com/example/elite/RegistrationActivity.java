package com.example.elite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.elite.Common.Urls;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
TextInputEditText Name,Email,Password;
CheckBox box;
Button Registration;
TextView LoginPage;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name=findViewById(R.id.reg_name);
        Email=findViewById(R.id.reg_email);
        Password=findViewById(R.id.reg_pass);
        LoginPage=findViewById(R.id.Reg_Signin_login);
        Registration=findViewById(R.id.reg_registration_btn);

        LoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i=new Intent(RegistrationActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
            }
        });

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = Name.getText().toString().trim();
                if (nameInput.isEmpty()) {
                    Name.setError("Enter your full Name");
                } else if (!nameInput.contains(" ") || nameInput.split("\\s+").length < 2) {
                    Name.setError("Enter both first and last name");
                } else if (!Email.getText().toString().contains("@") || !Email.getText().toString().contains(".com")) {
                    Email.setError("Enter Valid Email");
                }else if (Password.getText().toString().isEmpty()) {
                    Password.setError("Enter password");
                } else if (Password.getText().toString().length() < 8) {
                    Password.setError("password must be greater than 8");
                } else if (!Password.getText().toString().matches("(.*[@#$&%*+].*)")) {

                    Password.setError("must contain Special Symbol");
                }else{

                    progressDialog=new ProgressDialog(RegistrationActivity.this);
                    progressDialog.setTitle("Register User");
                    progressDialog.setCancelable(false);
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.setMessage("Please wait.......");
                    progressDialog.show();
                    RegisterUser();
                }

            }
        });
    }

    private void RegisterUser() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Urls.UrlRegisterStudent, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj=new JSONObject(response);
                    String status=obj.getString("status");

                    if(status.equals("success")){
                        Toast.makeText(RegistrationActivity.this, response,Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                        Toast.makeText(RegistrationActivity.this,"Registration Successfully Done",Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                    else{
                        String message=obj.getString("message");
                        Toast.makeText(RegistrationActivity.this, message, Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegistrationActivity.this,response, Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrationActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();

            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> Params =new HashMap<>();
                Params.put("Name",Name.getText().toString());
                Params.put("Email",Email.getText().toString());
                Params.put("Password",Password.getText().toString());

                return Params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);
        requestQueue.add(stringRequest);
    }
}