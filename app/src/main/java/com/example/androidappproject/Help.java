package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    TextView tvCall, tvEmail, tvAddress;
    public CardView cardView1, cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        drawerLayout = findViewById(R.id.drawer_layout);

        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);

        tvCall = findViewById(R.id.tvCall);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);
        String location = "National University-Manila, M.F. Jhocson Street, Sampaloc, Manila, Metro Manila";

        tvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:09999999999"));
                startActivity(intent);

            }
        });

        tvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:covidifyph@gmail.com"));
                startActivity(intent);

            }
        });

        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + location));
                startActivity(intent);

            }
        });


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
    public void ClickHelp(View view){ recreate(); }
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

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()){
            case R.id.cardView1:
                intent = new Intent(this, FAQProfile.class);
                startActivity(intent);
                break;

            case R.id.cardView2:
                intent = new Intent(this, FAQSymptomTracker.class);
                startActivity(intent);
                break;
        }
    }
}