package com.example.trevt.navigationbar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.trevt.navigationbar.DetailWisata.Detail_wisata;
import com.example.trevt.navigationbar.ListTourFragment;
import com.example.trevt.navigationbar.ModelWisata.Wisata;
import com.example.trevt.navigationbar.ModelWisata.WisataList;
import com.example.trevt.navigationbar.R;

import java.util.List;

public class Wisata_adapter extends RecyclerView.Adapter<Wisata_adapter.ViewHolder> {
    private Context context;
    private List<Wisata> wisatas;

    public Wisata_adapter(Context context, List<Wisata> wisatas){
        this.context=context;
        this.wisatas = wisatas;

    }


    @NonNull
    @Override
    public Wisata_adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bakal_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Wisata_adapter.ViewHolder viewHolder, final int i) {

        final Wisata WisataModel = wisatas.get(i);
        final String WisataID = String.valueOf(wisatas.get(i));
        final String Idwisata = String.valueOf(wisatas.get(i).getIdWisata());
        final String NamaWisata = String.valueOf(wisatas.get(i).getNamaWisata());
        final String FotoWisata = String.valueOf(wisatas.get(i).getFotoWisata());
        final String AlamatWisata = String.valueOf(wisatas.get(i).getAlamatWisata());
        final String Photo360 = String.valueOf(wisatas.get(i).getPhoto360());

        viewHolder.Nama.setText(NamaWisata);
        viewHolder.Alamat.setText(AlamatWisata);
        String image= FotoWisata;

        Glide.with(context).load(image).into(viewHolder.Image);

        viewHolder.listviewwisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(context, Detail_wisata.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle setData = new Bundle();
                setData.putString("id", WisataID);
                setData.putString("idwisata",Idwisata);
                setData.putString("namawisata",NamaWisata);
                setData.putString("fotowisata",FotoWisata);
                setData.putString("alamatwisata",AlamatWisata);
                setData.putString("photo360",Photo360);
                detail.putExtras(setData);
                context.startActivity(detail);
            }
        });

    }


    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Nama,Alamat;
        private ImageView Image;
        private CardView listviewwisata;
        public ViewHolder(View itemView) {

            super(itemView);
            Nama = (TextView)itemView.findViewById(R.id.namawisata);
            Image = (ImageView)itemView.findViewById(R.id.gambar);
            Alamat = (TextView)itemView.findViewById(R.id.deskripsi);
            listviewwisata = itemView.findViewById(R.id.listwisata);
        }
    }
}

