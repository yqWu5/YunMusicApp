package com.example.yunmusicapp.adapter.mine;

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
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//我喜欢的音乐
public class MineLikeMusicAdapter extends RecyclerView.Adapter<MineLikeMusicAdapter.LikeMusicAdapter> {
    public String cookie;
    private Context context;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public MineLikeMusicAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LikeMusicAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_likemusic, parent, false);
        return new LikeMusicAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LikeMusicAdapter holder, int position) {
        SingList.PlaylistBean likePlayList = InfoTmp.getLikePlayList();
        //绑定数据
        if(likePlayList != null){
            Glide.with(context).load(likePlayList.getCoverImgUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.LikeMusic_Img);
            holder.LikeMusic_Name.setText(likePlayList.getName());
            holder.LikeMusic_Total.setText(likePlayList.getTrackCount() + "首");
            holder.LikeMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onclickListener != null)
                    {
                        onclickListener.click(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class LikeMusicAdapter extends RecyclerView.ViewHolder{
        private ImageView LikeMusic_Img;
        private TextView LikeMusic_Name;
        private TextView LikeMusic_Total;
        private ConstraintLayout LikeMusic;
        public LikeMusicAdapter(@NonNull View itemView) {
            super(itemView);
            LikeMusic_Img = itemView.findViewById(R.id.LikeMusic_Img);
            LikeMusic_Name = itemView.findViewById(R.id.LikeMusic_Name);
            LikeMusic_Total = itemView.findViewById(R.id.LikeMusic_Total);
            LikeMusic = itemView.findViewById(R.id.LikeMusic);
        }
    }
}
