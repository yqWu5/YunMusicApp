package com.example.yunmusicapp.adapter.fansFollowed;

import android.content.Context;
import android.media.Image;
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
import com.example.yunmusicapp.entity.UserFolloweds;
import com.example.yunmusicapp.entity.UserFollows;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import org.w3c.dom.Text;

import java.util.List;

public class FansRecycleAdapter extends RecyclerView.Adapter<FansRecycleAdapter.FansRecycleHolder> {
    private Context context;
    private List<UserFolloweds.FollowedsBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public FansRecycleAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<UserFolloweds.FollowedsBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FansRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fansfolloweds_fans_fragment, parent, false);
        return new FansRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FansRecycleHolder holder, int position) {
        holder.fans_Name.setText(list.get(position).getNickname());
        Glide.with(context).load(list.get(position).getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.fans_Img);
        holder.FansFragment.setOnClickListener(new View.OnClickListener() {
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

    class FansRecycleHolder extends RecyclerView.ViewHolder{
        private ImageView fans_Img;
        private TextView fans_Name;
        private ConstraintLayout FansFragment;
        public FansRecycleHolder(@NonNull View itemView) {
            super(itemView);
            fans_Img = itemView.findViewById(R.id.fans_Img);
            fans_Name = itemView.findViewById(R.id.fans_Name);
            FansFragment = itemView.findViewById(R.id.FansFragment);
        }
    }
}
