package com.example.yunmusicapp.adapter.musicComment;

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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.CommentMusic;
import com.like.IconType;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.List;

public class MusicCommentRecyclerViewPagerRecyclerAdapter extends RecyclerView.Adapter<MusicCommentRecyclerViewPagerRecyclerAdapter.MusicCommentViewPagerRecyclerAdapterHolder> {
    private Context context;
    private List<CommentMusic.HotCommentsBean> list = null;

    public MusicCommentRecyclerViewPagerRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<CommentMusic.HotCommentsBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MusicCommentViewPagerRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.musiccomment_recycler_viewpager_recycler, parent ,false);
        return new MusicCommentViewPagerRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicCommentViewPagerRecyclerAdapterHolder holder, int position) {
        Glide.with(context).load(list.get(position).getUser().getAvatarUrl()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).
                apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.MusicComment_ViewPager_Img);
        holder.MusicComment_ViewPager_Comment.setText(list.get(position).getContent());
        holder.MusicComment_ViewPager_LikeCount.setText(list.get(position).getLikedCount() + "");
        holder.MusicComment_ViewPager_Name.setText(list.get(position).getUser().getNickname());
        holder.MusicComment_ViewPager_LikeImg.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                holder.MusicComment_ViewPager_LikeCount.setText(Integer.valueOf(holder.MusicComment_ViewPager_LikeCount.getText().toString()) + 1 + "");
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                holder.MusicComment_ViewPager_LikeCount.setText(Integer.valueOf(holder.MusicComment_ViewPager_LikeCount.getText().toString()) - 1 + "");
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MusicCommentViewPagerRecyclerAdapterHolder extends RecyclerView.ViewHolder{
        private LikeButton MusicComment_ViewPager_LikeImg;
        private ImageView MusicComment_ViewPager_Img;
        private TextView MusicComment_ViewPager_Name;
        private TextView MusicComment_ViewPager_Time;
        private TextView MusicComment_ViewPager_LikeCount;
        private TextView MusicComment_ViewPager_Comment;
        private TextView MusicComment_ViewPager_Followed;

        public MusicCommentViewPagerRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            MusicComment_ViewPager_LikeImg = itemView.findViewById(R.id.MusicComment_ViewPager_LikeImg);
            MusicComment_ViewPager_Img = itemView.findViewById(R.id.MusicComment_ViewPager_Img);
            MusicComment_ViewPager_Name = itemView.findViewById(R.id.MusicComment_ViewPager_Name);
            MusicComment_ViewPager_Time = itemView.findViewById(R.id.MusicComment_ViewPager_Time);
            MusicComment_ViewPager_LikeCount = itemView.findViewById(R.id.MusicComment_ViewPager_LikeCount);
            MusicComment_ViewPager_Comment = itemView.findViewById(R.id.MusicComment_ViewPager_Comment);
            MusicComment_ViewPager_Followed = itemView.findViewById(R.id.MusicComment_ViewPager_Followed);

        }
    }
}
