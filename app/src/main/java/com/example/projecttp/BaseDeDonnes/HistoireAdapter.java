package com.example.projecttp.BaseDeDonnes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projecttp.Histoire.Scène;
import com.example.projecttp.Histoire.histoire;
import com.example.projecttp.MainActivity2;
import com.example.projecttp.R;

import java.io.Serializable;
import java.util.ArrayList;
import android.widget.ImageButton;
public class HistoireAdapter extends RecyclerView.Adapter<HistoireViewHolder>{
    ArrayList<histoire> Histoires;
    ArrayList<histoire> Histoires_Favori;
    HistoireFavoriAdapter HistoireFavories;

    public HistoireAdapter(ArrayList<histoire> histoires) {
        this.Histoires=histoires;
    }
    @NonNull
    @Override
    public HistoireViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_histoire_list,null,false);
        HistoireViewHolder viewHolder = new HistoireViewHolder(v,Histoires_Favori,HistoireFavories);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoireViewHolder holder, int position) {
        histoire h=Histoires.get(position);
        holder.t1.setText(h.getTitre());
        holder.img.setImageResource(h.getImg());
        holder.favImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int backgroundColor = ((ColorDrawable) holder.favImage.getBackground()).getColor();
                if ((backgroundColor == Color.parseColor("#FFFFFFFF"))) {
                    holder.favImage.setBackgroundColor(Color.parseColor("#FF0000"));
                    holder.Histoires_Favori.add(new histoire(holder.t1.getText().toString(),h.getImg()));
                    holder.adapter.notifyItemInserted(Histoires_Favori.size()-1);
                }else{
                    holder.favImage.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    int position1 = holder.adapter.vh.getBindingAdapterPosition();
                    holder.Histoires_Favori.remove(position1);
                    holder.adapter.notifyItemRemoved(position1);
                    holder.adapter.notifyItemRangeRemoved(position1, 1);
                    holder.adapter.notifyItemRangeChanged(position1, holder.Histoires_Favori.size() - position1);
                }
            }
        });
        holder.itemView.setOnClickListener(v -> {
            ArrayList<Scène> myList=h.getLesScènes();
            Intent intent = new Intent(v.getContext(), MainActivity2.class);
            Bundle args = new Bundle();
            args.putSerializable("ARRAYLIST",(Serializable)myList);
            intent.putExtra("BUNDLE",args);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return Histoires.size();
    }

    public void setHistoires_Favori(ArrayList<histoire> histoires_Favori) {
        Histoires_Favori = histoires_Favori;
    }

    public void setHistoireFavories(HistoireFavoriAdapter histoireFavories) {
        HistoireFavories = histoireFavories;
    }

}

class HistoireViewHolder extends RecyclerView.ViewHolder{

    ImageButton favImage;
    ArrayList<histoire> Histoires_Favori;
    HistoireFavoriAdapter adapter;
    TextView t1;
    ImageView img;
    public HistoireViewHolder(@NonNull View itemView
            ,ArrayList<histoire> Histoires, HistoireFavoriAdapter adapter) {
        super(itemView);
        this.t1=itemView.findViewById(R.id.t1);
        this.img=itemView.findViewById(R.id.histoire_image);
        this.favImage=itemView.findViewById(R.id.fav);
        this.Histoires_Favori=Histoires;
        this.adapter=adapter;

    }
}

