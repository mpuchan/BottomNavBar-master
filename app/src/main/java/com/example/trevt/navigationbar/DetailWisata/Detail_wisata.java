package com.example.trevt.navigationbar.DetailWisata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.trevt.navigationbar.HomeFragment;
import com.example.trevt.navigationbar.ListTourFragment;
import com.example.trevt.navigationbar.Profil.profile;
import com.example.trevt.navigationbar.R;
import com.example.trevt.navigationbar.StatsFragment;
import com.example.trevt.navigationbar.VrPanoramicView.ImageLoaderTask;
import com.example.trevt.navigationbar.isidata.isi;
import com.example.trevt.navigationbar.VrPanoramicView.tampilan360;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class Detail_wisata extends AppCompatActivity {
    TextView namawisata, deskripsi,alamat;
    ImageView gambar,imagesample360;
    CardView card;

    Button btn360;
    String idwis,namawis,fotowis,alamatwis,desk;
    String nama1,id,photo360;

    int id2 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        idwis = bundle.getString("idwisata");
        photo360 = bundle.getString("photo360");
        id2 = Integer.parseInt(idwis);
        int jum = (id2-1);
        namawis = bundle.getString("namawisata");
        fotowis= bundle.getString("fotowisata");
        alamatwis= bundle.getString("alamatwisata");
        namawisata=(TextView)findViewById(R.id.namawisata);
        imagesample360 = findViewById(R.id.imagesample360);
        card = findViewById(R.id.card);
        alamat = findViewById(R.id.alamat);

        //bakal_list
        gambar=(ImageView)findViewById(R.id.gambar);
        deskripsi=(TextView)findViewById(R.id.deskripsi);
        btn360=(Button)findViewById(R.id.button360);
        namawisata.setText(namawis);
        Glide.with(this).load(fotowis).into(gambar);
        nama1= (isi.nawawisata[jum]);
//        Toast.makeText(Detail_wisata.this,
//                "Ini "+jum,
//                Toast.LENGTH_LONG).show();
      if (namawis.equalsIgnoreCase(nama1)){
       deskripsi.setText(isi.deskripsi[jum]);
       alamat.setText(alamatwis);
          loadPanoImage();
          card.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  Intent tampilandetail = (new Intent(Detail_wisata.this, tampilan360.class)
                          .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                  Bundle setData = new Bundle();
                  setData.putString("photo360",photo360);
                  tampilandetail.putExtras(setData);
                  startActivity(tampilandetail);

              }
          });
      }else{
          deskripsi.setText("null");
          alamat.setText(alamatwis);
         card.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent tampilandetail = (new Intent(Detail_wisata.this, tampilan360.class)
                          .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                  Bundle setData = new Bundle();
                  setData.putString("photo360",photo360);
                  tampilandetail.putExtras(setData);
                  startActivity(tampilandetail);

              }
          });
      }









//        gambar.setImageResource(isi.gambar[getIntent().getExtras().getInt("id")]);


    }

    private void loadPanoImage() {
        String panoImageName = "https://1.bp.blogspot.com/"+photo360;
        Glide.with(this).load(panoImageName).into(imagesample360);

    }
    }

