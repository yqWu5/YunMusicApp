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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class DiscoveryFragmentVideosAdapter extends RecyclerView.Adapter<DiscoveryFragmentVideosAdapter.DiscoveryFragmentVideosHolder> {
    private Context context;
    private List<RecommendVideos.DatasBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }
    public void setData(List<RecommendVideos.DatasBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public DiscoveryFragmentVideosAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DiscoveryFragmentVideosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discovery_fragment_videos, parent, false);
        return new DiscoveryFragmentVideosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryFragmentVideosHolder holder, int position) {
        holder.discovery_fragment_videos_Title.setText(list.get(position).getData().getTitle());
        Glide.with(context).load(list.get(position).getData().getCoverUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).
                diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).
                into(holder.discovery_fragment_videos_Img);
        holder.DiscoveryFragment_Videos_All.setOnClickListener(new View.OnClickListener() {
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

    class DiscoveryFragmentVideosHolder extends RecyclerView.ViewHolder {
        private ImageView discovery_fragment_videos_Img;
        private TextView discovery_fragment_videos_Title;
        private ConstraintLayout DiscoveryFragment_Videos_All;
        public DiscoveryFragmentVideosHolder(@NonNull View itemView) {
            super(itemView);
            discovery_fragment_videos_Img = itemView.findViewById(R.id.discovery_fragment_videos_Img);
            discovery_fragment_videos_Title = itemView.findViewById(R.id.discovery_fragment_videos_Title);
            DiscoveryFragment_Videos_All = itemView.findViewById(R.id.DiscoveryFragment_Videos_All);
        }
    }
}
