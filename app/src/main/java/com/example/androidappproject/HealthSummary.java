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

public class HealthSummary extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private DBHelper DB;
    private EditText etSymptomID;
    private TextView tvSymptom;
    String username;
    String password;
    private Button btnSaveSymptoms, btnBackSymptom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_summary);

        drawerLayout = findViewById(R.id.drawer_layout);
        DB = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        username="sample";
        password="sample";
        if (extras != null) {
            username = extras.getString("username");
            password = extras.getString("password");
        }

        etSymptomID = findViewById(R.id.etSymptomID);
        etSymptomID.setFocusable(false);
        tvSymptom = findViewById(R.id.tvSymptom);
        btnSaveSymptoms = (Button) findViewById(R.id.btnSaveSymptoms);
        btnBackSymptom = findViewById(R.id.btnBackSymptom);

        displaySymptomID();
        displaySymptoms();

        btnBackSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StartSymptom.class);
                startActivity(intent);
            }
        });

    }

    public void displaySymptomID(){
        Cursor result = DB.getSymptomID(username,password);
        ArrayList<String[]> symptomid = new ArrayList<>();
        try{
            while (result.moveToNext()) {
                String ID = (result.getString(0));
                String array[] = {ID};
                symptomid.add(array);
            }
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_LONG);
        }
        etSymptomID.setText(symptomid.get(0)[0]);
    }

    public void displaySymptoms(){
//        btnSaveSymptoms.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ArrayList<Cursor[]> symptoms = new ArrayList<>();
//                        while (SymptomID.moveToNext()) {
//                            Cursor[] array = {SymptomID};
//                            symptoms.add(array);
//                        }
                        Cursor result = DB.getSpecificSymptoms(etSymptomID.getText().toString());
                        if (result.getCount() == 0) {
                            Toast.makeText(HealthSummary.this, "No data found", Toast.LENGTH_LONG).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (result.moveToNext()) {
//                            buffer.append("Symptom ID: " + result.getInt(0) + "\n");
                            buffer.append("COVID-19 SYMPTOMS \n\n");
                            if (result.getInt(3) == 1) {
                                buffer.append("Fever above 38°C \n");
                            }
                            if (result.getInt(4) == 1) {
                                buffer.append("Chills \n");
                            }
                            if (result.getInt(5) == 1) {
                                buffer.append("Body aches \n");
                            }
                            if (result.getInt(6) == 1) {
                                buffer.append("Sore throat \n");
                            }
                            if (result.getInt(7) == 1) {
                                buffer.append("Difficulty swallowing \n");
                            }
                            if (result.getInt(8) == 1) {
                                buffer.append("Persistent cough \n");
                            }
                            if (result.getInt(9) == 1) {
                                buffer.append("Difficulty breathing \n");
                            }
                            if (result.getInt(10) == 1) {
                                buffer.append("Runny nose \n");
                            }
                            if (result.getInt(11) == 1) {
                                buffer.append("Flu-like syndrome \n");
                            }
                            if (result.getInt(12) == 1) {
                                buffer.append("Loss of taste or smell \n");
                            }
                            if (result.getInt(13) == 1) {
                                buffer.append("Fatigue (chronic exhaustion) \n");
                            }
                            if (result.getInt(14) == 1) {
                                buffer.append("Symptom worsening following exertion \n");
                            }
                            if (result.getInt(15) == 1) {
                                buffer.append("Headache \n");
                            }
                            if (result.getInt(16) == 1) {
                                buffer.append("Dizziness \n");
                            }
                            if (result.getInt(17) == 1) {
                                buffer.append("Difficulty concentrating \n");
                            }
                            if (result.getInt(18) == 1) {
                                buffer.append("Memory lapses \n");
                            }
                            if (result.getInt(19) == 1) {
                                buffer.append("Low mood or sadness \n");
                            }
                            if (result.getInt(20) == 1) {
                                buffer.append("Fear or anxiety \n");
                            }
                            if (result.getInt(21) == 1) {
                                buffer.append("Difficulty sleeping \n");
                            }
                            if (result.getInt(22) == 1) {
                                buffer.append("Tinnitus \n");
                            }
                            if (result.getInt(23) == 1) {
                                buffer.append("Earache \n");
                            }
                            if (result.getInt(24) == 1) {
                                buffer.append("Pins and needles, or numbness, in the arms or legs \n");
                            }
                            if (result.getInt(25) == 1) {
                                buffer.append("Heart palpitations \n");
                            }
                            if (result.getInt(26) == 1) {
                                buffer.append("Chest pain \n");
                            }
                            if (result.getInt(27) == 1) {
                                buffer.append("Abdominal pain \n");
                            }
                            if (result.getInt(28) == 1) {
                                buffer.append("Loss of appetite \n");
                            }
                            if (result.getInt(29) == 1) {
                                buffer.append("Meal skipped \n");
                            }
                            if (result.getInt(30) == 1) {
                                buffer.append("Diarrhea \n");
                            }
                            if (result.getInt(31) == 1) {
                                buffer.append("Skin rash \n\n");
                            }
                            buffer.append("Other symptoms or notes: " + result.getString(32) + "\n\n");
                            buffer.append("DATE SELECTED \n\n");
                            buffer.append("First day: " + result.getInt(33) + "/" + result.getInt(34) + "/" + result.getInt(35) + "\n");
                            buffer.append("Last day: " + result.getInt(36) + "/" + result.getInt(37) + "/" + result.getInt(38) + "\n");
//                            buffer.append("Symptom ID: " + result.getInt(0) + "\n");
//                            buffer.append("Fever: " + result.getInt(3) + "\n");
//                            buffer.append("Chills: " + result.getInt(4) + "\n");
//                            buffer.append("Bodyache: " + result.getInt(5) + "\n\n");


                        }
                        tvSymptom.setText(buffer.toString());

                        //Show all data
                        Toast.makeText(HealthSummary.this, "Data displayed", Toast.LENGTH_LONG).show();
                    }
//                }
//        );
//    }

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
    public void ClickHealthTips(View view){ HomeActivity.redirectActivity(this,HealthTips.class); }
    public void ClickHelp(View view){
        HomeActivity.redirectActivity(this,Help.class);
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