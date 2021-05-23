package com.example.yunmusicapp.adapter.fansFollowed;

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
import com.example.yunmusicapp.entity.UserFollows;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class FollowedRecycleAdapter extends RecyclerView.Adapter<FollowedRecycleAdapter.FollowedRecycleHolder> {
    private Context context;
    private List<UserFollows.FollowBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public void setData(List<UserFollows.FollowBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public FollowedRecycleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FollowedRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fansfollowed_followed_recycle, parent, false);
        return new FollowedRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowedRecycleHolder holder, int position) {
        holder.followed_Name.setText(list.get(position).getNickname());
        Glide.with(context).load(list.get(position).getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.followed_Img);
        holder.FansFollowed.setOnClickListener(new View.OnClickListener() {
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

    class FollowedRecycleHolder extends RecyclerView.ViewHolder{
        private ImageView followed_Img;
        private TextView followed_Name;
        private ConstraintLayout FansFollowed;
        public FollowedRecycleHolder(@NonNull View itemView) {
            super(itemView);
            followed_Img = itemView.findViewById(R.id.followed_Img);
            followed_Name = itemView.findViewById(R.id.followed_Name);
            FansFollowed = itemView.findViewById(R.id.FansFollowed);
        }
    }
}
