package com.example.yunmusicapp.adapter.playList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.bottomView.PlayListDetailBottomView;
import com.example.yunmusicapp.entity.PlayListDetail;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class PlayListDetailRecycleListRecycleAdapter extends RecyclerView.Adapter<PlayListDetailRecycleListRecycleAdapter.PlayListDetailRecycleListRecycleHolder> {
    private Context context;
    private View view;
    private PlayListDetail data;
    private FragmentManager fm;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public PlayListDetailRecycleListRecycleAdapter(Context context, FragmentManager fm) {
        this.fm = fm;
        this.context = context;
    }

    public void setData(PlayListDetail data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayListDetailRecycleListRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.playlistdetail_recycle_listrecycle, parent, false);
        return new PlayListDetailRecycleListRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayListDetailRecycleListRecycleHolder holder, int position) {
        List<PlayListDetail.PlaylistBean.TracksBean> list = data.getPlaylist().getTracks();
        holder.playListDetail_listRecycle_Num.setText(String.valueOf(position + 1));
        holder.playListDetail_listRecycle_Name.setText(list.get(position).getName());
        if(list.get(position).getPc() != null){
            holder.playListDetail_listRecycle_who.setText(list.get(position).getPc().getAr().trim());
            holder.playListDetail_listRecycle_album.setText("- " + list.get(position).getPc().getAlb());
        }else{
            holder.playListDetail_listRecycle_who.setText(String.valueOf(list.get(position).getAr().get(0).getName()));
            holder.playListDetail_listRecycle_album.setText("- " + String.valueOf(list.get(position).getAl().getName()));
        }
        holder.PlayListDetail_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclickListener != null)
                {
                    onclickListener.click(position);
                }
            }
        });
        //歌曲细节底部栏弹出
        holder.playListDetail_listRecycle_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayListDetailBottomView.getPlayListDetailBottomView().show(fm);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.getPlaylist().getTracks() == null ? 0 : data.getPlaylist().getTracks().size();
    }

    class PlayListDetailRecycleListRecycleHolder extends RecyclerView.ViewHolder{
        private TextView playListDetail_listRecycle_Num;
        private TextView playListDetail_listRecycle_Name;
        private TextView playListDetail_listRecycle_who;
        private TextView playListDetail_listRecycle_album;
        private ImageView playListDetail_listRecycle_setting;
        private ConstraintLayout PlayListDetail_All;
        public PlayListDetailRecycleListRecycleHolder(@NonNull View itemView) {
            super(itemView);
            playListDetail_listRecycle_Num = view.findViewById(R.id.playListDetail_listRecycle_Num);
            playListDetail_listRecycle_Name = view.findViewById(R.id.playListDetail_listRecycle_Name);
            playListDetail_listRecycle_who = view.findViewById(R.id.playListDetail_listRecycle_who);
            playListDetail_listRecycle_album = view.findViewById(R.id.playListDetail_listRecycle_album);
            PlayListDetail_All = view.findViewById(R.id.PlayListDetail_All);
            playListDetail_listRecycle_setting = itemView.findViewById(R.id.playListDetail_listRecycle_setting);
        }
    }


}
