package com.nasrul.colorgenerator.adapter;

import android.print.PrintAttributes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.nasrul.colorgenerator.R;
import com.nasrul.colorgenerator.model.GenWarna;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WarnaAdapter extends RecyclerView.Adapter<WarnaAdapter.WarnaViewHolder> {

    public WarnaAdapter(ArrayList<GenWarna> warna) {
        this.warna = warna;
    }

    private ArrayList<GenWarna> warna;
    private OnCardClickListener listener;

    public interface OnCardClickListener {
        public void onClick(View v, int posisi);
    }

    public void setListener(OnCardClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public WarnaViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View list = layoutInflater.inflate(R.layout.list_warna, parent, false);
        return new WarnaViewHolder(list);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull WarnaAdapter.WarnaViewHolder holder, int position) {
        holder.card.setCardBackgroundColor(warna.get(position).getWarna());
        holder.textView.setText("#" + warna.get(position).getTextwarna().toUpperCase());
        holder.card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (warna != null) ? warna.size() : 0;
    }

    public class WarnaViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private MaterialCardView card;
        public WarnaViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.cardcolor);
            textView = itemView.findViewById(R.id.textwarna);
        }
    }
}
