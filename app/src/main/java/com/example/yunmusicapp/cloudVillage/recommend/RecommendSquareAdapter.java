package com.example.yunmusicapp.cloudVillage.recommend;

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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.like.IconType;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.List;

public class RecommendSquareAdapter extends RecyclerView.Adapter<RecommendSquareAdapter.RecommendSquareAdapterHolder> {
    private Context context;
    private List<RecommendVideos.DatasBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public RecommendSquareAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<RecommendVideos.DatasBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public void loadMore(List<RecommendVideos.DatasBean> newList){
        int size = newList.size();
        for(int i=0; i<size; i++){
            this.list.add(newList.get(i));
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecommendSquareAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cloudvillage_square_fragment_recycler, parent, false);
        return new RecommendSquareAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendSquareAdapterHolder holder, int position) {
        Glide.with(context).load(list.get(position).getData().getCoverUrl()).
                apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).
                diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).
                into(holder.Square_Recycler_Img);
        holder.Square_Recycler_Title.setText(list.get(position).getData().getTitle());
        holder.Square_Recycler_Likes.setText((list.get(position).getData().getPraisedCount()) + "");
        holder.Square_Recycler_People.setText((list.get(position).getData().getShareCount() + list.get(position).getData().getCommentCount()) + "");
        holder.CloudVillage_Square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onclickListener != null){
                    onclickListener.click(position);
                }
            }
        });
        holder.Square_Recycler_LikeImg.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                holder.Square_Recycler_Likes.setText(Integer.valueOf(holder.Square_Recycler_Likes.getText().toString()) + 1 + "");
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                holder.Square_Recycler_Likes.setText(Integer.valueOf(holder.Square_Recycler_Likes.getText().toString()) - 1 + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 :list.size();
    }

    class RecommendSquareAdapterHolder extends RecyclerView.ViewHolder{
        private LikeButton Square_Recycler_LikeImg;
        private ConstraintLayout CloudVillage_Square;
        private ImageView Square_Recycler_UserImg;
        private ImageView Square_Recycler_Img;
        private TextView Square_Recycler_Title;
        private TextView Square_Recycler_People;
        private TextView Square_Recycler_Likes;

        public RecommendSquareAdapterHolder(@NonNull View itemView) {
            super(itemView);
            Square_Recycler_LikeImg = itemView.findViewById(R.id.Square_Recycler_LikeImg);
            CloudVillage_Square = itemView.findViewById(R.id.CloudVillage_Square);
            Square_Recycler_UserImg = itemView.findViewById(R.id.Square_Recycler_UserImg);
            Square_Recycler_Img = itemView.findViewById(R.id.Square_Recycler_Img);
            Square_Recycler_Title = itemView.findViewById(R.id.Square_Recycler_Title);
            Square_Recycler_People = itemView.findViewById(R.id.Square_Recycler_People);
            Square_Recycler_Likes = itemView.findViewById(R.id.Square_Recycler_Likes);
        }
    }
}
