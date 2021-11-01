package com.example.androidappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cvdsymptomsAdapter extends RecyclerView.Adapter <cvdsymptomsAdapter.SymptomsViewHolder> {

    ArrayList<cvdsymptomsHelperClass> featuredLocations1;

    public cvdsymptomsAdapter(ArrayList<cvdsymptomsHelperClass> featuredLocations1) {
        this.featuredLocations1 = featuredLocations1;
    }

    @NonNull
    @Override
    public SymptomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid19_symptoms_design, parent, false);
        SymptomsViewHolder symptomsViewHolder = new SymptomsViewHolder(view);
        return symptomsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomsViewHolder holder, int position) {
        cvdsymptomsHelperClass cvdsymptomshelperclass = featuredLocations1.get(position);
        holder.image.setImageResource(cvdsymptomshelperclass.getImage());
        holder.title.setText(cvdsymptomshelperclass.getTitle());
        holder.desc.setText(cvdsymptomshelperclass.getDesc());

    }

    @Override
    public int getItemCount() {
        return featuredLocations1.size();
    }

    public static class SymptomsViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView desc,title;
        public SymptomsViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.cvdsymptoms_image);
            title = itemView.findViewById(R.id.cvdsymptoms_title);
            desc = itemView.findViewById(R.id.cvdsymptoms_description);


        }
    }


}
