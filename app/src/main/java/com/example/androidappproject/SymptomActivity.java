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
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class SymptomActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private DBHelper DB;
    private Button btnSaveSymptoms;
    private CheckBox checkBox, checkBox2, checkBox3, checkBox4, checkBox5,
            checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11,
            checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17,
            checkBox18, checkBox19, checkBox20, checkBox21, checkBox22, checkBox23,
            checkBox24, checkBox25, checkBox26, checkBox27, checkBox28, checkBox29;
    private EditText etOtherSymptoms;
    private DatePicker datePicker1, datePicker2;

    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);

        drawerLayout = findViewById(R.id.drawer_layout);
        DB = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        username="sample";
        password="sample";
        if (extras != null) {
            username = extras.getString("username");
            password = extras.getString("password");
        }



        btnSaveSymptoms = findViewById(R.id.btnSaveSymptoms);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox14 = findViewById(R.id.checkBox14);
        checkBox15 = findViewById(R.id.checkBox15);
        checkBox16 = findViewById(R.id.checkBox16);
        checkBox17 = findViewById(R.id.checkBox17);
        checkBox18 = findViewById(R.id.checkBox18);
        checkBox19 = findViewById(R.id.checkBox19);
        checkBox20 = findViewById(R.id.checkBox20);
        checkBox21 = findViewById(R.id.checkBox21);
        checkBox22 = findViewById(R.id.checkBox22);
        checkBox23 = findViewById(R.id.checkBox23);
        checkBox24 = findViewById(R.id.checkBox24);
        checkBox25 = findViewById(R.id.checkBox25);
        checkBox26 = findViewById(R.id.checkBox26);
        checkBox27 = findViewById(R.id.checkBox27);
        checkBox28 = findViewById(R.id.checkBox28);
        checkBox29 = findViewById(R.id.checkBox29);


        etOtherSymptoms = findViewById(R.id.etOtherSymptoms);

        datePicker1 = findViewById(R.id.datePicker1);
        datePicker2 = findViewById(R.id.datePicker2);

        insertSymptoms();


//        btnSaveSymptoms.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SymptomDate.class);
//                startActivity(intent);
//            }
//        });
    }

    public void insertSymptoms(){
        btnSaveSymptoms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = DB.insertSymptoms(username, password,
                                checkBox.isChecked()?1:0,
                                checkBox2.isChecked()?1:0,
                                checkBox3.isChecked()?1:0,
                                checkBox4.isChecked()?1:0,
                                checkBox5.isChecked()?1:0,
                                checkBox6.isChecked()?1:0,
                                checkBox7.isChecked()?1:0,
                                checkBox8.isChecked()?1:0,
                                checkBox9.isChecked()?1:0,
                                checkBox10.isChecked()?1:0,
                                checkBox11.isChecked()?1:0,
                                checkBox12.isChecked()?1:0,
                                checkBox13.isChecked()?1:0,
                                checkBox14.isChecked()?1:0,
                                checkBox15.isChecked()?1:0,
                                checkBox16.isChecked()?1:0,
                                checkBox17.isChecked()?1:0,
                                checkBox18.isChecked()?1:0,
                                checkBox19.isChecked()?1:0,
                                checkBox20.isChecked()?1:0,
                                checkBox21.isChecked()?1:0,
                                checkBox22.isChecked()?1:0,
                                checkBox23.isChecked()?1:0,
                                checkBox24.isChecked()?1:0,
                                checkBox25.isChecked()?1:0,
                                checkBox26.isChecked()?1:0,
                                checkBox27.isChecked()?1:0,
                                checkBox28.isChecked()?1:0,
                                checkBox29.isChecked()?1:0,
                                etOtherSymptoms.getText().toString(),
                                datePicker1.getMonth()+1,
                                datePicker1.getDayOfMonth(),
                                datePicker1.getYear(),
                                datePicker2.getMonth()+1,
                                datePicker2.getDayOfMonth(),
                                datePicker2.getYear());
                        if (isInserted == true){
                            Toast.makeText(SymptomActivity.this, "Symptom report was successfully saved", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HealthSummary.class);
                            intent.putExtra("username",username+"");
                            intent.putExtra("password",password+"");
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SymptomActivity.this, "Symptom report was not saved", Toast.LENGTH_SHORT).show();
                        }

//                        StringBuffer result = new StringBuffer();
//                        result.append("Fever: ").append(checkBox.isChecked()?1:0);
//                        result.append("Chills: ").append(checkBox2.isChecked()?1:0);
//                        result.append("Bodyache: ").append(checkBox3.isChecked()?1:0);
//                        Toast.makeText(SymptomActivity.this, result.toString(),Toast.LENGTH_LONG).show();
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