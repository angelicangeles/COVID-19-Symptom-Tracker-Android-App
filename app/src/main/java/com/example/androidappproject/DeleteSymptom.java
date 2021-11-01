package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteSymptom extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private DBHelper DB;
    private Button btnBackHistory, btnDeleteSymptom;
    private EditText etDeleteSymptomID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_symptom);

        drawerLayout = findViewById(R.id.drawer_layout);
        DB = new DBHelper(this);

//        btnBackHistory = findViewById(R.id.btnBackHistory);
        btnDeleteSymptom = findViewById(R.id.btnDeleteSymptom);
        etDeleteSymptomID = findViewById(R.id.etDeleteSymptomID);

//        btnBackHistory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), HealthHistory.class);
//                startActivity(intent);
//            }
//        });

        deleteSymptomReport();

    }

    public void deleteSymptomReport(){
        btnDeleteSymptom.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = DB.deleteSymptom(etDeleteSymptomID.getText().toString());
                        if (deletedRows > 0){
                            Toast.makeText(DeleteSymptom.this, "Symptom report was successfully deleted", Toast.LENGTH_LONG).show();
//                            Intent intent = new Intent(getApplicationContext(), HealthHistory.class);
//                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(DeleteSymptom.this, "Symptom report was not deleted, check the symptom report ID number.", Toast.LENGTH_LONG).show();
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
    public void ClickProfile(View view){ HomeActivity.redirectActivity(this, ProfileActivity.class); }
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