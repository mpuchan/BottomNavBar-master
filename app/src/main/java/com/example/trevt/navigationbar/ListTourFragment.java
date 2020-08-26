package com.example.trevt.navigationbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trevt.navigationbar.API_LOGIN.APIList;
import com.example.trevt.navigationbar.API_LOGIN.WisatawanListt;
import com.example.trevt.navigationbar.Adapter.Wisata_adapter;
import com.example.trevt.navigationbar.DetailWisata.Detail_wisata;
import com.example.trevt.navigationbar.Login.activity_signinn;
import com.example.trevt.navigationbar.Login.activity_signup;
import com.example.trevt.navigationbar.ModelWisata.Wisata;
import com.example.trevt.navigationbar.ModelWisata.WisataList;
import com.example.trevt.navigationbar.isidata.Datawisata;
import com.example.trevt.navigationbar.isidata.isi;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListTourFragment extends Fragment {

//    private TextView mTextViewEmpty;
//    private ProgressBar mProgressBarLoading;
//    private ImageView mImageViewEmpty;
    private Wisata_adapter wisata_adapter;
    private List<Wisata> data = new ArrayList<>();
    private RecyclerView mRecyclerView;
    Context mContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listtour, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        mTextViewEmpty = (TextView) view.findViewById(R.id.textViewEmpty);
//        mImageViewEmpty = (ImageView) view.findViewById(R.id.imageViewEmpty);
//        mProgressBarLoading = (ProgressBar) view.findViewById(R.id.progressBarLoading);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        getallwisata();
        ArrayList data = new ArrayList<Datawisata>();
        for (int i = 0; i < isi.nawawisata.length; i++) {
            data.add(
                    new Datawisata
                            (
                                    isi.nawawisata[i],
                                    isi.deskripsi[i],
                                    isi.gambar[i]
                            ));
        }
//        mListadapter = new ListAdapter(data);
//        mRecyclerView.setAdapter(mListadapter);
//
        return view;

    }

    private void getallwisata() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIList.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIList api = retrofit.create(APIList.class);
        Call<WisataList> call = api.getallWisata();
        call.enqueue(new Callback<WisataList>() {
            @Override
            public void onResponse(Call<WisataList> call, Response<WisataList> response) {
//                        Integer status = response.body().getStatus();
//                        boolean error = response.body().isError();
//                        String message = response.body().getMessage();

                //progress.dismiss();
//                        Log.d("test", "Errronya " + error);
                if (response.code() == 200){
                    data = response.body().getWisata();
                    wisata_adapter = new Wisata_adapter(getActivity(), data);
                    mRecyclerView.setAdapter(wisata_adapter);
                } else {

                }
            }

//


            @Override
            public void onFailure(Call<WisataList> call, Throwable t) {
                //progress.dismiss();
                //progress.dismiss();
                //progress.dismiss();
            }
        });
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        private ArrayList<Wisata> dataList;

        public ListAdapter(ArrayList<Wisata> data) {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtViewnamawisata,
                    txtViewdeskripsi;
            ImageView imageViewGambar;

            public ViewHolder(View itemView) {
                super(itemView);
                this.txtViewnamawisata = (TextView) itemView.findViewById(R.id.namawisata);
                this.txtViewdeskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
                this.imageViewGambar = (ImageView) itemView.findViewById(R.id.gambar);

            }

        }

        @NonNull
        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bakal_list, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
            holder.txtViewnamawisata.setText(dataList.get(position).getNamaWisata());
            holder.txtViewdeskripsi.setText(dataList.get(position).getAlamatWisata());
//            holder.imageViewGambar.setImageResource(dataList.get(position).getFotoWisata());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detail = new Intent(getActivity(), Detail_wisata.class);
                    detail.putExtra("id", position);
                    startActivity(detail);

                }
            });

        }

        @Override
        public int getItemCount() {

            return dataList.size();
        }

        //        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
    //    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_listtour, container, false);
//    }

