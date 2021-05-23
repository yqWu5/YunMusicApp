package com.example.yunmusicapp.adapter.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.tmp.MenuMessage;
import com.example.yunmusicapp.interf.BaseOnclickListener;

import java.util.List;

public class MenuRecyclerMessageAdapter extends RecyclerView.Adapter<MenuRecyclerMessageAdapter.RecyclerMessageAdapterHolder> {
    private Context context;
    private List<MenuMessage> list;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public void setData(List<MenuMessage> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public MenuRecyclerMessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerMessageAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_recycler_message, parent, false);
        return new RecyclerMessageAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMessageAdapterHolder holder, int position) {
        holder.Menu_Message_Img.setImageResource(list.get(position).getImg());
        holder.Menu_Message_Title.setText(list.get(position).getTitle());
        //点击事件
        holder.MenuRecycler_Click.setOnClickListener(new View.OnClickListener() {
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

    class RecyclerMessageAdapterHolder extends RecyclerView.ViewHolder{
        private ImageView Menu_Message_Img;
        private TextView Menu_Message_Title;
        private ConstraintLayout MenuRecycler_Click;
        public RecyclerMessageAdapterHolder(@NonNull View itemView) {
            super(itemView);
            Menu_Message_Img = itemView.findViewById(R.id.Menu_Message_Img);
            Menu_Message_Title = itemView.findViewById(R.id.Menu_Message_Title);
            MenuRecycler_Click = itemView.findViewById(R.id.MenuRecycler_Click);
        }
    }

}
