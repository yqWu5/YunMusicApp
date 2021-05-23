package com.example.yunmusicapp.adapter.mine;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;

//创建歌单
public class MineCreateListAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_createlistrecycle, parent, false);
        return new CreateListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class CreateListHolder extends RecyclerView.ViewHolder{

        public CreateListHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
