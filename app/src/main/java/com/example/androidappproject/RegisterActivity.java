package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    TextInputLayout  etRegName, etRegAddress, etRegContact, etRegUsername, etRegPassword, etRegRePassword;
    Button btnSignup;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegName = findViewById(R.id.etRegName);
        etRegAddress = findViewById(R.id.etRegAddress);
        etRegContact= findViewById(R.id.etRegContact);
        etRegUsername= findViewById(R.id.etRegUsername);
        etRegPassword= findViewById(R.id.etRegPassword);
        etRegRePassword = findViewById(R.id.etRegRePassword);
        btnSignup = findViewById(R.id.btnSignup);
        DB = new DBHelper(this);



        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etRegName.getEditText().getText().toString().trim();
                String address = etRegAddress.getEditText().getText().toString().trim();
                String contact = etRegContact.getEditText().getText().toString().trim();
                String user = etRegUsername.getEditText().getText().toString().trim();
                String pass = etRegPassword.getEditText().getText().toString().trim();
                String repass = etRegRePassword.getEditText().getText().toString().trim();


                if (name.isEmpty()){
                    etRegName.setError("Field Can't Be Empty");
                }else if (address.isEmpty()){
                    etRegAddress.setError("Field Can't Be Empty");
                }
                else if (contact.isEmpty()){
                    etRegContact.setError("Field Can't Be Empty");
                }
                else if(contact.length()>11){
                    etRegContact.setError("Invalid Phone Number");
                }
                else if (contact.length() < 11){
                    etRegContact.setError("Invalid Phone Number");
                }
                else if (user.isEmpty()){
                    etRegUsername.setError("Field Can't Be Empty");
                }
                else if(user.length() > 8){
                    etRegUsername.setError("Username too long");
                }
                else if (pass.isEmpty()){
                    etRegPassword.setError("Field Can't Be Empty");
                }
                else if (repass.isEmpty()){
                    etRegRePassword.setError("Field Can't Be Empty");
                }

                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checketUsername(user);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(name, address, contact, user, pass);
                            if (insert == true){
                                Toast.makeText(RegisterActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Username Already Exists!", Toast.LENGTH_SHORT).show();
                         
                        }
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Password do not Match", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

    }

    private boolean validateUsername(){
        String user = etRegUsername.getEditText().getText().toString().trim();
        if(user.isEmpty()){
            etRegUsername.setError("Field Can't Be Empty");
            return false;
        }
        else if(user.length() > 8){
            etRegUsername.setError("Username too long");
            return false;
        }
        else{
            etRegUsername.setError(null);
            return true;
        }
    }


    public void register(View view) {
    }
}