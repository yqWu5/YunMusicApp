package com.example.yunmusicapp.adapter.mine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.tmp.MusicApp;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class MusicAppAdapter extends RecyclerView.Adapter<MusicAppAdapter.MusicAppHolder> {
    private Context context;
    private List<MusicApp> list = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public MusicAppAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<MusicApp> list){
        this.list = list;
    }



    @NonNull
    @Override
    public MusicAppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_musicapp, parent, false);
        return new MusicAppHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAppHolder holder, int position) {
        holder.MusicApp_Img.setImageResource(list.get(position).getMusic_Img());
        holder.MusicApp_Name.setText(list.get(position).getMusic_Name());

        holder.MusicApp_Img.setOnClickListener(new View.OnClickListener() {
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

    class MusicAppHolder extends RecyclerView.ViewHolder{
        private ImageView MusicApp_Img;
        private TextView MusicApp_Name;
        public MusicAppHolder(@NonNull View itemView) {
            super(itemView);
            MusicApp_Img = itemView.findViewById(R.id.MusicApp_Img);
            MusicApp_Name = itemView.findViewById(R.id.MusicApp_Name);
        }
    }
}
