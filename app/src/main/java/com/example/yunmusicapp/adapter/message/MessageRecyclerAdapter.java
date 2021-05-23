package com.example.yunmusicapp.adapter.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.MsgPrivate;
import com.example.yunmusicapp.entity.tmp.InfoTmp;

import java.util.List;

//私信对话 适配器
public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.MessageRecyclerAdapterHolder> {
    private Context context;
    private List<MsgPrivate.MsgsBean> list = null;

    public void setData(List<MsgPrivate.MsgsBean> list){
        this.list = list;
    }

    public MessageRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MessageRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_fragment_recycler, parent, false);
        return new MessageRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRecyclerAdapterHolder holder, int position) {
        Glide.with(context).load(list.get(position).getFromUser().getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.Message_Recycler_Img);
        holder.Message_Recycler_Name.setText(list.get(position).getFromUser().getNickname());
        holder.Message_Recycler_Copment.setText(list.get(position).getLastMsg());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MessageRecyclerAdapterHolder extends RecyclerView.ViewHolder{
        private ImageView Message_Recycler_Img;
        private TextView Message_Recycler_Name;
        private TextView Message_Recycler_Copment;
        private TextView Message_Recycler_Date;
        public MessageRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            Message_Recycler_Img = itemView.findViewById(R.id.Message_Recycler_Img);
            Message_Recycler_Name = itemView.findViewById(R.id.Message_Recycler_Name);
            Message_Recycler_Copment = itemView.findViewById(R.id.Message_Recycler_Copment);
            Message_Recycler_Date = itemView.findViewById(R.id.Message_Recycler_Date);
        }
    }
}
