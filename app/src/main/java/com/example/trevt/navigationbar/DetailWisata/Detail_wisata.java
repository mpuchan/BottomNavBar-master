package com.example.trevt.navigationbar.DetailWisata;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trevt.navigationbar.R;
import com.example.trevt.navigationbar.isidata.isi;
import com.example.trevt.navigationbar.tampilan360;

public class Detail_wisata extends AppCompatActivity {
    TextView namawisata, deskripsi;
    ImageView gambar;
    Button btn360;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        namawisata=(TextView)findViewById(R.id.namawisata);
        deskripsi=(TextView)findViewById(R.id.deskripsi);
        gambar=(ImageView)findViewById(R.id.gambar);
        btn360=(Button)findViewById(R.id.button360);

        namawisata.setText(isi.nawawisata[getIntent().getExtras().getInt("id")]);
        deskripsi.setText(isi.deskripsi[getIntent().getExtras().getInt("id")]);
        gambar.setImageResource(isi.gambar[getIntent().getExtras().getInt("id")]);
        btn360.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tampilandetail = new Intent(Detail_wisata.this, tampilan360.class);
                tampilandetail.putExtra("posisi", getIntent().getExtras().getInt("id"));
                startActivity(tampilandetail);

            }
        });

    }
}
