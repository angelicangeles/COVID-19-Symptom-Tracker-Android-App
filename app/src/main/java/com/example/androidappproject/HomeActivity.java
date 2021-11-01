package com.example.androidappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private static String username;
    private static String password;
    DrawerLayout drawerLayout;

    RecyclerView covidifyInfo, covidsymptoms_recycleviewer, covidsprevention_recycleviewer;
    RecyclerView.Adapter adapter, adapter2, adapter3;

    TextView tvCases, tvRecovered, tvActive, tvTotalDeaths;
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvActive = findViewById(R.id.tvActive);
        tvTotalDeaths =findViewById(R.id.tvTotalDeaths);

        covidifyInfo = findViewById(R.id.covidifyInfo);
        covidifyInfo();

        covidsymptoms_recycleviewer = findViewById(R.id.covidsymptoms_recycleviewer);
        covidsymptoms_recycleviewer();

        covidsprevention_recycleviewer = findViewById(R.id.covidsprevention_recycleviewer);
        covidsprevention_recycleviewer();

        pieChart = findViewById(R.id.piechart);

        fetchData();


        Bundle extras = getIntent().getExtras();
        username="sample";
        password="sample";
        if (extras != null) {
            username = extras.getString("username");
            password = extras.getString("password");
        }

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void covidsprevention_recycleviewer() {
        covidsprevention_recycleviewer.setHasFixedSize(true);
        covidsprevention_recycleviewer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<cvdpreventionHelperClass> featuredLocations2 = new ArrayList<>();

        featuredLocations2.add(new cvdpreventionHelperClass(R.drawable.self_isolate, "If you have Covid- 19 with symptoms, or a positive test result without symptoms, you will be asked to self- isolate at home or in health care facility."));
        featuredLocations2.add(new cvdpreventionHelperClass(R.drawable.call_healthauthority, "Contact your local public health authority. They may be able to help you to notify your contacts and inform them about next steps."));
        featuredLocations2.add(new cvdpreventionHelperClass(R.drawable.clock3, "Think back to 48hrs before you started to feel unwell, and before you took your Covid- 19 test until you began self- isolation. Consider where you went and who you might have spent time with."));
        featuredLocations2.add(new cvdpreventionHelperClass(R.drawable.avoid_crowd, "Contact people with whom you had physical contact or spent 15 minutes at a distance closer than one meter, and let them know you're positive test result."));
        featuredLocations2.add(new cvdpreventionHelperClass(R.drawable.nav, "If you visited a store, health facility, or other closed and crowded establishments, please call and let them know the day and time that you were present"));

        adapter3 = new cvdpreventionAdapter(featuredLocations2);
        covidsprevention_recycleviewer.setAdapter(adapter3);
    }


    private void covidsymptoms_recycleviewer() {
        covidsymptoms_recycleviewer.setHasFixedSize(true);
        covidsymptoms_recycleviewer.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<cvdsymptomsHelperClass> featuredLocations1 = new ArrayList<>();
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.fever2,"An abnormally high body temperature, usually accompanied by shivering, headache, and in severe instances, delirium.","Fever"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.cough2,"A dry cough is one that does not produce phlegm or mucus.","Dry Cough"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.difficultyofbreathing,"An intense tightening in the chest, air hunger, difficulty breathing, breathlessness or a feeling of suffocation.","Difficulty of Breathing"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.tiredness,"Extreme tiredness resulting from mental or physical exertion or illness.","Tiredness"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.achesandpains,"Minor pains and discomforts, typically in the muscles.","Aches and Pains"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.lossoftasteandsmell,"Loss of smell can occur suddenly in people with COVID-19 and is often accompanied by loss of taste.","Loss of Taste and Smell"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.sorethroat,"A pain, scratchiness or irritation of the throat that often worsens when you swallow.","Sore Throat"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.runnynose,"Excess nasal drainage. It may be a thin clear fluid, thick mucus or something in between.","Runny Nose"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.vommiting,"An uneasiness of the stomach that often accompanies the urge to vomit.","Nausea or Vommiting"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.diarrhoea,"A condition in which feces are discharged from the bowels frequently and in a liquid form.\n","Diarrhea"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.headache,"A continuous pain in the head.","Headache"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.discolorationoffingers,"A person will experience discoloration on their hands and toes, which will turn into painful blisters or lesions.","Discoloration of Fingers"));
        featuredLocations1.add(new cvdsymptomsHelperClass(R.drawable.chestpain,"A squeezing pain or pressure on the chest. It occurs when not enough blood is getting to the heart.","Chest Pain or Pressure"));


        adapter2 = new cvdsymptomsAdapter(featuredLocations1);
        covidsymptoms_recycleviewer.setAdapter(adapter2);
    }

    private void covidifyInfo() {
        covidifyInfo.setHasFixedSize(true);
        covidifyInfo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<HomeHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new HomeHelperClass(R.drawable.time, "It takes a minute per day"));
        featuredLocations.add(new HomeHelperClass(R.drawable.encrypted, "Data is Encrypted and Private"));
        featuredLocations.add(new HomeHelperClass(R.drawable.homeprofile, "Create an Account in few Steps"));
        featuredLocations.add(new HomeHelperClass(R.drawable.list, "Answer few questions"));
        featuredLocations.add(new HomeHelperClass(R.drawable.doctor2, "Easy to show to your Doctor"));


        adapter = new covidinfoAdapter(featuredLocations);
        covidifyInfo.setAdapter(adapter);
    }

    private void fetchData() {
        String url = "https://corona.lmao.ninja/v2/all";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvCases.setText(jsonObject.getString("cases"));
                    tvRecovered.setText(jsonObject.getString("recovered"));
                    tvActive.setText(jsonObject.getString("active"));
                    tvTotalDeaths.setText(jsonObject.getString("deaths"));



                    pieChart.addPieSlice(new PieModel("Cases", Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                    pieChart.addPieSlice(new PieModel("Recovered", Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                    pieChart.addPieSlice(new PieModel("Active", Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                    pieChart.addPieSlice(new PieModel("Deaths", Integer.parseInt(tvTotalDeaths.getText().toString()), Color.parseColor("#EF5350")));

                    pieChart.startAnimation();



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(HomeActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View View){
        closedrawer(drawerLayout);
    }

    public static void closedrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickProfile(View view){
        redirectActivity(this, ProfileActivity.class);
    }
    public void ClickSymptomTracker(View view){ redirectActivity(this,StartSymptom.class); }
    public void ClickHealthHistory(View view){ HomeActivity.redirectActivity(this, HealthHistory.class); }
    public void ClickHealthTips(View view){ redirectActivity(this,HealthTips.class); }
    public void ClickHelp(View view){
        redirectActivity(this,Help.class);
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

    public static void redirectActivity(Activity activity, Class aClass) {

        Intent intent = new Intent(activity, aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("username",username+"");
        intent.putExtra("password",password+"");
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        closedrawer(drawerLayout);
    }

    public void trackCountriesHome(View view) {
        startActivity(new Intent(getApplicationContext(), TrackAffectedCountries.class));
    }
}