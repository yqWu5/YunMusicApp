package com.example.yunmusicapp.adapter.discovery;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.DiscoveryCalendar;

import java.util.List;

public class DiscoveryFragmentCalendarAdapter extends RecyclerView.Adapter<DiscoveryFragmentCalendarAdapter.DiscoveryFragmentCalendarHolder> {
    private Context context;
    private List<DiscoveryCalendar.DataBean.CalendarEventsBean> list = null;

    public void setData(List<DiscoveryCalendar.DataBean.CalendarEventsBean> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public DiscoveryFragmentCalendarAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DiscoveryFragmentCalendarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discovery_fragment_calendar, parent, false);
        return new DiscoveryFragmentCalendarHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoveryFragmentCalendarHolder holder, int position) {
        holder.calendar_day.setText("今日");
        holder.calendar_tag.setText(list.get(position).getTag());
        holder.calendar_Title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getImgUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.calendar_Img);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class DiscoveryFragmentCalendarHolder extends RecyclerView.ViewHolder{
        private TextView calendar_day;
        private TextView calendar_tag;
        private TextView calendar_Title;
        private ImageView calendar_Img;
        public DiscoveryFragmentCalendarHolder(@NonNull View itemView) {
            super(itemView);
            calendar_day = itemView.findViewById(R.id.calendar_day);
            calendar_tag = itemView.findViewById(R.id.calendar_tag);
            calendar_Title = itemView.findViewById(R.id.calendar_Title);
            calendar_Img = itemView.findViewById(R.id.calendar_Img);
        }
    }
}
