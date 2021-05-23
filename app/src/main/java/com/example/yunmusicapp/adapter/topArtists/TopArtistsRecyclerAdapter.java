package com.example.yunmusicapp.adapter.topArtists;

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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.TopArtists;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class TopArtistsRecyclerAdapter extends RecyclerView.Adapter<TopArtistsRecyclerAdapter.TopArtistsRecyclerAdapterHolder> {
    private Context context;
    private List<TopArtists.ArtistsBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public void setData(List<TopArtists.ArtistsBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public TopArtistsRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TopArtistsRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.topartists_recycler, parent, false);
        return new TopArtistsRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopArtistsRecyclerAdapterHolder holder, int position) {
        if(list.get(position).getImg1v1Url() != null){
            Glide.with(context).load(list.get(position).getImg1v1Url()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.TopArtists_Recycler_Img);
        }
        holder.TopArtists_Recycler_Name.setText(list.get(position).getName());

        //点击事件
        holder.TopArtists_Recycler_All.setOnClickListener(new View.OnClickListener() {
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

    class TopArtistsRecyclerAdapterHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout TopArtists_Recycler_All;
        private ImageView TopArtists_Recycler_Img;
        private TextView TopArtists_Recycler_Name;
        public TopArtistsRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            TopArtists_Recycler_Img = itemView.findViewById(R.id.TopArtists_Recycler_Img);
            TopArtists_Recycler_Name = itemView.findViewById(R.id.TopArtists_Recycler_Name);
            TopArtists_Recycler_All = itemView.findViewById(R.id.TopArtists_Recycler_All);
        }
    }
}
