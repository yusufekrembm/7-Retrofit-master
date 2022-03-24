package com.macelitech.retrofitjava.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.macelitech.retrofitjava.R;
import com.macelitech.retrofitjava.model.CryptoModel;

import java.util.ArrayList;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.RowHolder> {
    private ArrayList<CryptoModel> cryptoList;
    private String[] colors = {"#dda15e","#fcf87f","#1dd7ee","#bdc29b","#758fce","#ebbdac","#8c4959","#d10374"};

    public RecylerViewAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyler_row,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(cryptoList.get(position),colors,position);
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textPrice;
        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(CryptoModel cryptoModel,String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position%8]));
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
            textPrice.setText(cryptoModel.price);
            textName.setText(cryptoModel.currency);
        }

    }
}
