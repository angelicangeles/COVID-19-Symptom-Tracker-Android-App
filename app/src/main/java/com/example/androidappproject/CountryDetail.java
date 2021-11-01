package com.example.androidappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class CountryDetail extends AppCompatActivity {
    private int positionCountry;
    TextView tvCountry, tvCasesDetail, tvtodayCasesDetail, tvDeathsDetail, tvtodayDeathsDetail, tvRecoveredDetail, tvActiveDetail, tvCriticalDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position", 0);
        getSupportActionBar().setTitle(TrackAffectedCountries.countryModelList.get(positionCountry).getCountry() +" Statistics");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvCountry = findViewById(R.id.tvCountry);
        tvCasesDetail = findViewById(R.id.tvCasesDetail);
        tvtodayCasesDetail = findViewById(R.id.tvtodayCasesDetail);
        tvDeathsDetail = findViewById(R.id.tvDeathsDetail);
        tvtodayDeathsDetail = findViewById(R.id.tvtodayDeathsDetail);
        tvRecoveredDetail = findViewById(R.id.tvRecoveredDetail);
        tvActiveDetail = findViewById(R.id.tvActiveDetail);
        tvCriticalDetail = findViewById(R.id.tvCriticalDetail);

        tvCountry.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvCasesDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getCases());
        tvtodayCasesDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvDeathsDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvtodayDeathsDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        tvRecoveredDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvActiveDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getActive());
        tvCriticalDetail.setText(TrackAffectedCountries.countryModelList.get(positionCountry).getCritical());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}