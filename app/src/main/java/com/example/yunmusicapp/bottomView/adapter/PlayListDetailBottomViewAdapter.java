package com.example.yunmusicapp.bottomView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;

public class  PlayListDetailBottomViewAdapter extends RecyclerView.Adapter {
    private Context context;

    public PlayListDetailBottomViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.playlistdetail_bottom_view_recycler, parent, false);
        return new PlayListDetailBottomViewAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class PlayListDetailBottomViewAdapterHolder extends RecyclerView.ViewHolder{
        public PlayListDetailBottomViewAdapterHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
