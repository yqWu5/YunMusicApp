package com.example.yunmusicapp.adapter.mine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.bottomView.PlayListBottomView;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class KeepListRecycleAdapter extends RecyclerView.Adapter<KeepListRecycleAdapter.KeepListRecycleHolder> {
    private Context context;
    public List<SingList.PlaylistBean> list = null;
    private BaseOnclickListener onclickListener;
    private FragmentManager fm = null;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public void setData(List<SingList.PlaylistBean> list){
        if(this.list != null){
            this.list.clear();
        }
        this.list = list;
        notifyDataSetChanged();
    }

    public KeepListRecycleAdapter(Context context, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
    }

    @NonNull
    @Override
    public KeepListRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_createlist, parent, false);
        return new KeepListRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KeepListRecycleHolder holder, int position) {
        Glide.with(context).load(list.get(position).getCoverImgUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.CreateList_Img);
        holder.CreateList_Name.setText(list.get(position).getName());
        holder.Create_Total.setText(list.get(position).getTrackCount() + "首");
        holder.CreateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onclickListener != null)
                {
                    onclickListener.click(position);
                }
            }
        });
        //底部弹出菜单栏点击事件
        holder.CreateList_Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayListBottomView.setTitle(list.get(position).getName());
                PlayListBottomView.getPlayListBottomView().show(fm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class KeepListRecycleHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout CreateList;
        private ImageView CreateList_Img;
        private TextView CreateList_Name;
        private TextView Create_Total;
        private ImageView CreateList_Setting;
        public KeepListRecycleHolder(@NonNull View itemView) {
            super(itemView);
            CreateList = itemView.findViewById(R.id.CreateList);
            CreateList_Img = itemView.findViewById(R.id.CreateList_Img);
            CreateList_Name = itemView.findViewById(R.id.CreateList_Name);
            Create_Total = itemView.findViewById(R.id.CreateList_Total);
            CreateList_Setting = itemView.findViewById(R.id.CreateList_Setting);
        }
    }
}
