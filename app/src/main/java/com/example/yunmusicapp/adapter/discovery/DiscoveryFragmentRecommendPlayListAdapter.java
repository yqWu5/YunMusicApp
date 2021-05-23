package com.example.yunmusicapp.adapter.discovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.RecommendPlayList;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class DiscoveryFragmentRecommendPlayListAdapter extends RecyclerView.Adapter<DiscoveryFragmentRecommendPlayListAdapter.RecommendPlayListHolder> {
    private Context context;
    private List<RecommendPlayList.RecommendBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public DiscoveryFragmentRecommendPlayListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<RecommendPlayList.RecommendBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecommendPlayListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discovery_fragment_recommendplaylist, parent, false);
        return new RecommendPlayListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendPlayListHolder holder, int position) {
        holder.recommendPlayList_Title.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getPicUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.recommendPlayList_Img);
        //点击事件
        holder.RecommendPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclickListener != null)
                {
                    onclickListener.click(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class RecommendPlayListHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout RecommendPlayList;
        private ImageView recommendPlayList_Img;
        private TextView recommendPlayList_Title;
        public RecommendPlayListHolder(@NonNull View itemView) {
            super(itemView);
            recommendPlayList_Img = itemView.findViewById(R.id.recommendPlayList_Img);
            recommendPlayList_Title = itemView.findViewById(R.id.recommendPlayList_Title);
            RecommendPlayList = itemView.findViewById(R.id.RecommendPlayList);
        }
    }
}
