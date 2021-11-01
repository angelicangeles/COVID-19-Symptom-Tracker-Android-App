package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HealthTips extends AppCompatActivity implements View.OnClickListener{
    private DrawerLayout drawerLayout;
    public CardView cardView1, cardView2, cardView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        drawerLayout = findViewById(R.id.drawer_layout);

        cardView1 = findViewById(R.id.cardView1);
        cardView2 = findViewById(R.id.cardView2);
        cardView3 = findViewById(R.id.cardView3);
        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);

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
    public void ClickHealthTips(View view){ recreate();  }
    public void ClickHelp(View view){ HomeActivity.redirectActivity(this, Help.class); }
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
                intent = new Intent(this, HealthTip1.class);
                startActivity(intent);
                break;

            case R.id.cardView2:
                intent = new Intent(this, HealthTip2.class);
                startActivity(intent);
                break;

            case R.id.cardView3:
                intent = new Intent(this, HealthTip3.class);
                startActivity(intent);
                break;
        }
    }
}