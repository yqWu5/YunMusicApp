package com.example.yunmusicapp.adapter.search;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.SearchHot;

import java.util.List;

public class SearchRecyclerAdapter extends RecyclerView.Adapter<SearchRecyclerAdapter.SearchRecyclerAdapterHolder> {
    private Context context;
    private List<SearchHot.DataBean> list = null;

    public void setData(List<SearchHot.DataBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public SearchRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SearchRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_recycler, parent, false);
        return new SearchRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchRecyclerAdapterHolder holder, int position) {
        holder.Search_Recycler_Num.setText(String.valueOf(position + 1));
        holder.Search_Recycler_Title.setText(list.get(position).getSearchWord());
        if(list.get(position).getIconUrl() != null){
            Glide.with(context).load(list.get(position).getIconUrl()).into(holder.Search_Recycler_Signal);
            holder.Search_Recycler_Title.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class SearchRecyclerAdapterHolder extends RecyclerView.ViewHolder{
        private TextView Search_Recycler_Num;
        private TextView Search_Recycler_Title;
        private ImageView Search_Recycler_Signal;

        public SearchRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            Search_Recycler_Num = itemView.findViewById(R.id.Search_Recycler_Num);
            Search_Recycler_Title = itemView.findViewById(R.id.Search_Recycler_Title);
            Search_Recycler_Signal = itemView.findViewById(R.id.Search_Recycler_Signal);
        }
    }
}
