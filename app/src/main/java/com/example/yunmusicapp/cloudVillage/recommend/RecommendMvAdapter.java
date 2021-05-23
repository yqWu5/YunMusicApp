package com.example.yunmusicapp.cloudVillage.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.MvAll;

import java.util.List;

public class RecommendMvAdapter extends RecyclerView.Adapter<RecommendMvAdapter.RecommendMvAdapterHolder> {
    private Context context;
    private List<MvAll.DataBean> list = null;

    public void setData(List<MvAll.DataBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void loadMore(List<MvAll.DataBean> newList){
        int size = newList.size();
        for(int i=0; i<size; i++){
            list.add(newList.get(i));
        }
        notifyDataSetChanged();
    }

    public RecommendMvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecommendMvAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cloudvillage_mv_recycler, parent, false);
        return new RecommendMvAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendMvAdapterHolder holder, int position) {
        Glide.with(context).load(list.get(position).getCover()).
                apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).
                diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).
                into(holder.CloudVillage_Mv_Img);
        holder.CloudVillage_Mv_Title.setText(list.get(position).getName());
        holder.CloudVillage_Mv_People.setText(list.get(position).getPlayCount() + "");
        holder.CloudVillage_Mv_Likes.setText(list.get(position).getDuration() / 10000 + "万");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class RecommendMvAdapterHolder extends RecyclerView.ViewHolder{
        private ImageView CloudVillage_Mv_Img;
        private TextView CloudVillage_Mv_Title;
        private TextView CloudVillage_Mv_People;
        private TextView CloudVillage_Mv_Likes;

        public RecommendMvAdapterHolder(@NonNull View itemView) {
            super(itemView);
            CloudVillage_Mv_Img = itemView.findViewById(R.id.CloudVillage_Mv_Img);
            CloudVillage_Mv_Title = itemView.findViewById(R.id.CloudVillage_Mv_Title);
            CloudVillage_Mv_People = itemView.findViewById(R.id.CloudVillage_Mv_People);
            CloudVillage_Mv_Likes = itemView.findViewById(R.id.CloudVillage_Mv_Likes);
        }
    }
}
