package com.example.yunmusicapp.adapter.clickUserInfo;

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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class ClickUserInfoCreateRecyclerAdapter extends RecyclerView.Adapter<ClickUserInfoCreateRecyclerAdapter.ClickUserInfoCreateRecyclerAdapterHolder> {
    private Context context;
    private List<SingList.PlaylistBean> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public ClickUserInfoCreateRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<SingList.PlaylistBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClickUserInfoCreateRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mine_createlist, parent, false);
        return new ClickUserInfoCreateRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClickUserInfoCreateRecyclerAdapterHolder holder, int position) {
        Glide.with(context).load(list.get(position).getCoverImgUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.CreateList_Img);
        holder.CreateList_Name.setText(list.get(position).getName());
        holder.CreateList_Total.setText(list.get(position).getTrackCount() + "首");
        //点击事件
        holder.CreateList.setOnClickListener(new View.OnClickListener() {
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

    class ClickUserInfoCreateRecyclerAdapterHolder extends RecyclerView.ViewHolder{
        private ImageView CreateList_Img;
        private TextView CreateList_Name;
        private TextView CreateList_Total;
        private ConstraintLayout CreateList;
        public ClickUserInfoCreateRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            CreateList_Img = itemView.findViewById(R.id.CreateList_Img);
            CreateList_Name = itemView.findViewById(R.id.CreateList_Name);
            CreateList_Total = itemView.findViewById(R.id.CreateList_Total);
            CreateList = itemView.findViewById(R.id.CreateList);

        }
    }
}
