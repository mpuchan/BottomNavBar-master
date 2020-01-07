package com.example.trevt.navigationbar;

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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.trevt.navigationbar.DetailWisata.Detail_wisata;
import com.example.trevt.navigationbar.isidata.Datawisata;
import com.example.trevt.navigationbar.isidata.isi;

import java.util.ArrayList;
import java.util.List;

public class ListTourFragment extends Fragment {

    private TextView mTextViewEmpty;
    private ProgressBar mProgressBarLoading;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listtour, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mTextViewEmpty = (TextView) view.findViewById(R.id.textViewEmpty);
        mImageViewEmpty = (ImageView) view.findViewById(R.id.imageViewEmpty);
        mProgressBarLoading = (ProgressBar) view.findViewById(R.id.progressBarLoading);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

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
        mListadapter = new ListAdapter(data);
        mRecyclerView.setAdapter(mListadapter);

        return view;

    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        private ArrayList<Datawisata> dataList;

        public ListAdapter(ArrayList<Datawisata> data) {
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
            holder.txtViewnamawisata.setText(dataList.get(position).getNamawisata());
            holder.txtViewdeskripsi.setText(dataList.get(position).getDeskripsi());
            holder.imageViewGambar.setImageResource(dataList.get(position).getGambar());

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

