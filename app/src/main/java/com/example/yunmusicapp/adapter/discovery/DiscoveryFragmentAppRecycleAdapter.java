package com.example.yunmusicapp.adapter.discovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.tmp.DiscoveryApp;

import java.util.List;

public class DiscoveryFragmentAppRecycleAdapter extends RecyclerView.Adapter<DiscoveryFragmentAppRecycleAdapter.DiscoveryFragmentAppRecycleHolder> {
    private Context context;
    private List<DiscoveryApp> list = null;
    public DiscoveryFragmentAppRecycleAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<DiscoveryApp> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DiscoveryFragmentAppRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discovery_fragment_app, parent, false);
        return new DiscoveryFragmentAppRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryFragmentAppRecycleHolder holder, int position) {
        holder.DiscoveryFragment_App_Img.setImageResource(list.get(position).getDiscoveryApp_Img());
        holder.DiscoveryFragment_App_Name.setText(list.get(position).getDiscoveryApp_Name());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class DiscoveryFragmentAppRecycleHolder extends RecyclerView.ViewHolder{
        private ImageView DiscoveryFragment_App_Img;
        private TextView DiscoveryFragment_App_Name;
        public DiscoveryFragmentAppRecycleHolder(@NonNull View itemView) {
            super(itemView);
            DiscoveryFragment_App_Img = itemView.findViewById(R.id.DiscoveryFragment_App_Img);
            DiscoveryFragment_App_Name = itemView.findViewById(R.id.DiscoveryFragment_App_Name);
        }
    }
}
