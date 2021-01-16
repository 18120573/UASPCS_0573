package com.example.uaspcs_0573.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uaspcs_0573.Models.AkanDatang;
import com.example.uaspcs_0573.R;

import java.util.ArrayList;

public class AkanDatangAdapter extends RecyclerView.Adapter<AkanDatangAdapter.MyViewHolder> {

    Context context;
    ArrayList<AkanDatang> data;

    public AkanDatangAdapter(Context context, ArrayList<AkanDatang> data){
        this.context=context;
        this.data=data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_akandatang, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.matchTitle.setText(data.get(position).getMatchTitle());
        holder.matchDescription.setText(data.get(position).getMatchDescription());


        Glide.with(context).load(data.get(position).getImage()).into(holder.gambarMatch);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView matchTitle, awayScore, homeScore, matchDescription;
        ImageView gambarMatch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            matchTitle = itemView.findViewById(R.id.titleMatch);
            matchDescription = itemView.findViewById(R.id.descriptionMatch);
            gambarMatch = itemView.findViewById(R.id.gambarMatch);
        }
    }
}
