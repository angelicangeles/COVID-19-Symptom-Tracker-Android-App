package com.example.androidappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cvdpreventionAdapter extends RecyclerView.Adapter<cvdpreventionAdapter.PreventionViewHolder> {

    ArrayList<cvdpreventionHelperClass> featuredLocations2;

    public cvdpreventionAdapter(ArrayList<cvdpreventionHelperClass> featuredLocations2) {
        this.featuredLocations2 = featuredLocations2;
    }

    @NonNull
    @Override
    public PreventionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid19_prevention_design,parent,false);
        PreventionViewHolder preventionViewHolder = new PreventionViewHolder(view);
        return preventionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PreventionViewHolder holder, int position) {
        cvdpreventionHelperClass cvdpreventionHelperClass = featuredLocations2.get(position);
        holder.image.setImageResource(cvdpreventionHelperClass.getImage());
        holder.desc.setText(cvdpreventionHelperClass.getDesc());
    }

    @Override
    public int getItemCount() {
        return featuredLocations2.size();
    }

    public static class PreventionViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView desc;

        public PreventionViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.covidPrevention_image);
            desc = itemView.findViewById(R.id.covidPrevention_description);
        }
    }





}
