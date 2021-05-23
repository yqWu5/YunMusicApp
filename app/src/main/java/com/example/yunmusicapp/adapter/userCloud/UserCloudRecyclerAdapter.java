package com.example.yunmusicapp.adapter.userCloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.UserCloud;

import java.util.List;

public class UserCloudRecyclerAdapter extends RecyclerView.Adapter<UserCloudRecyclerAdapter.UserCloudRecyclerAdapterHolder> {
    private Context context;
    private View view;
    private List<UserCloud.DataBean> list = null;

    public void setData(List<UserCloud.DataBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public UserCloudRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserCloudRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.playlistdetail_recycle_listrecycle, parent, false);
        return new UserCloudRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCloudRecyclerAdapterHolder holder, int position) {
        holder.playListDetail_listRecycle_Num.setText(position + 1 + "");
        holder.playListDetail_listRecycle_Name.setText(list.get(position).getSimpleSong().getName());
        holder.playListDetail_listRecycle_who.setText(list.get(position).getArtist());
        holder.playListDetail_listRecycle_album.setText(list.get(position).getAlbum());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class UserCloudRecyclerAdapterHolder extends RecyclerView.ViewHolder {
        private TextView playListDetail_listRecycle_Num;
        private TextView playListDetail_listRecycle_Name;
        private TextView playListDetail_listRecycle_who;
        private TextView playListDetail_listRecycle_album;
        private ImageView playListDetail_listRecycle_setting;
        private ConstraintLayout PlayListDetail_All;
        public UserCloudRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            playListDetail_listRecycle_Num = itemView.findViewById(R.id.playListDetail_listRecycle_Num);
            playListDetail_listRecycle_Name = itemView.findViewById(R.id.playListDetail_listRecycle_Name);
            playListDetail_listRecycle_who = itemView.findViewById(R.id.playListDetail_listRecycle_who);
            playListDetail_listRecycle_album = itemView.findViewById(R.id.playListDetail_listRecycle_album);
            PlayListDetail_All = itemView.findViewById(R.id.PlayListDetail_All);
        }
    }
}
