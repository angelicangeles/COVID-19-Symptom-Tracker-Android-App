package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnlogin;
    TextView tvsignup;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnlogin = findViewById(R.id.btnlogin);
        tvsignup = findViewById(R.id.tvsignup);
        DB = new DBHelper(this);

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Check Fields!", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checketUsernameetPassword(user, pass);
                    if (checkuserpass == true){
                        Toast.makeText(LoginActivity.this, "Welcome to Covidify!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        intent.putExtra("username",user+"");
                        intent.putExtra("password",pass+"");
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}