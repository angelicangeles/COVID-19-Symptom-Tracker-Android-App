package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private DBHelper DB;
    private EditText etID, etName, etAddress, etContact, etUsername2, etPassword2;
    private Button btnUpdate;
    String username;
    String password;
    Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        extras = getIntent().getExtras();
        username="sample";
        password="sample";
        if (extras != null) {
            username = extras.getString("username");
            password = extras.getString("password");
        }

        drawerLayout = findViewById(R.id.drawer_layout);

        DB = new DBHelper(this);
        etID = findViewById(R.id.etID);
        etName = (EditText) findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etContact = findViewById(R.id.etContact);
        etUsername2 = findViewById(R.id.etUsername2);
        etPassword2 = findViewById(R.id.etPassword2);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        etID.setFocusable(false);


        displayUserInfo();
        updateUserInfo();

    }

    public void displayUserInfo(){
        Cursor result = DB.getAllData(username,password);
        ArrayList<String[]> users = new ArrayList<>();
        try{
            while (result.moveToNext()) {
                String ID = (result.getString(0));
                String name = result.getString(1);
                String address = result.getString(2);
                String contact = result.getString(3);
                String username = result.getString(4);
                String password = result.getString(5);
                String array[] = {ID,name,address,contact,username,password};
                users.add(array);
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
        }

        etID.setText(users.get(0)[0]);
        etName.setText(users.get(0)[1]);
        etAddress.setText(users.get(0)[2]);
        etContact.setText(users.get(0)[3]);
        etUsername2.setText(users.get(0)[4]);
        etPassword2.setText(users.get(0)[5]);
    }

    public void updateUserInfo(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = DB.updateData(extras.getString("username"),etID.getText().toString(),
                                etName.getText().toString(),
                                etAddress.getText().toString(),
                                etContact.getText().toString(),
                                etUsername2.getText().toString(),
                                etPassword2.getText().toString());
                        if (isUpdated == true) {
                            username=etUsername2.getText().toString();
                            password=etPassword2.getText().toString();
                            Toast.makeText(ProfileActivity.this, "User information was successfully updated", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                            intent.putExtra("username",username+"");
                            intent.putExtra("password",password+"");
                            startActivity(intent);
                        } else {
                            Toast.makeText(ProfileActivity.this, "User information was not updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }



    public void ClickMenu(View view){
        HomeActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View View){
        HomeActivity.closedrawer(drawerLayout);
    }
    public void ClickHome(View view){ HomeActivity.redirectActivity(this, HomeActivity.class); }
    public void ClickProfile(View view){ recreate(); }
    public void ClickSymptomTracker(View view){ HomeActivity.redirectActivity(this, StartSymptom.class); }
    public void ClickHealthHistory(View view){ HomeActivity.redirectActivity(this, HealthHistory.class); }
    public void ClickHealthTips(View view){ HomeActivity.redirectActivity(this, HealthTips.class); }
    public void ClickHelp(View view){
        HomeActivity.redirectActivity(this, Help.class);
    }
    public void ClickLogout(View view){
        logout(this);
    }
    public void logout(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("LOG OUT");
        builder.setMessage("Are you sure you want to log out?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
    protected void onPause(){
        super.onPause();
        HomeActivity.closedrawer(drawerLayout);
    }
}