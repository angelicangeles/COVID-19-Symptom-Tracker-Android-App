package com.example.androidappproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class covidinfoAdapter extends RecyclerView.Adapter<covidinfoAdapter.HomeViewHolder> {

    ArrayList<HomeHelperClass> featuredLocations;

    public covidinfoAdapter(ArrayList<HomeHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.covidify_info_design, parent, false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        HomeHelperClass homeHelperClass = featuredLocations.get(position);
        holder.image.setImageResource(homeHelperClass.getImage());
        holder.desc.setText(homeHelperClass.getDesc());

    }

    @Override
    public int getItemCount() {

        return featuredLocations.size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView desc;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.time_image);
            desc = itemView.findViewById(R.id.time_text);
        }
    }
}
