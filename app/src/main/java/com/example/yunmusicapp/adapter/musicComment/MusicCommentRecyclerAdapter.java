package com.example.yunmusicapp.adapter.musicComment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.tmp.SongUrlTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.mineView.CustomViewPager;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.google.android.material.tabs.TabLayout;

public class MusicCommentRecyclerAdapter extends RecyclerView.Adapter<MusicCommentRecyclerAdapter.MusicCommentRecyclerAdapterHolder> {
    private View view;
    private Context context;
    private FragmentManager fm = null;
    private SongUrlTmp tmp = null;
    private BaseOnclickListener onclickListener;

    public void setBaseOnClickListener(BaseOnclickListener onClickListener)
    {
        this.onclickListener = onClickListener;
    }

    public MusicCommentRecyclerAdapter(Context context, FragmentManager fm, SongUrlTmp tmp) {
        this.context = context;
        this.fm = fm;
        this.tmp = tmp;
    }



    @NonNull
    @Override
    public MusicCommentRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.musiccomment_recycler, parent, false);
        initViewPager();
        return new MusicCommentRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicCommentRecyclerAdapterHolder holder, int position) {
        Glide.with(context).load(tmp.getImgUrl()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.MusicComment_Recycler_Img);
        holder.MusicComment_Recycler_SongName.setText(tmp.getName());
        holder.MusicComment_Recycler_SingerName.setText(tmp.getSingerName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MusicCommentRecyclerAdapterHolder extends RecyclerView.ViewHolder{
        private ImageView MusicComment_Recycler_Img;
        private TextView MusicComment_Recycler_SongName;
        private TextView MusicComment_Recycler_SingerName;
        private TabLayout MusicComment_Recycler_TabLayout;
        private ViewPager MusicComment_Recycler_ViewPager;
        public MusicCommentRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
            MusicComment_Recycler_Img = itemView.findViewById(R.id.MusicComment_Recycler_Img);
            MusicComment_Recycler_SongName = itemView.findViewById(R.id.MusicComment_Recycler_SongName);
            MusicComment_Recycler_SingerName = itemView.findViewById(R.id.MusicComment_Recycler_SingerName);
            MusicComment_Recycler_TabLayout = itemView.findViewById(R.id.MusicComment_Recycler_TabLayout);
            MusicComment_Recycler_ViewPager = itemView.findViewById(R.id.MusicComment_Recycler_ViewPager);
        }
    }

    public void initViewPager(){
        TabLayout MusicComment_Recycler_TabLayout = view.findViewById(R.id.MusicComment_Recycler_TabLayout);
        VerticalViewPager MusicComment_Recycler_ViewPager = view.findViewById(R.id.MusicComment_Recycler_ViewPager);

        MusicComment_Recycler_ViewPager.setAdapter(new MusicCommentRecyclerViewPagerAdapter(fm));
        MusicComment_Recycler_TabLayout.setupWithViewPager(MusicComment_Recycler_ViewPager);
    }
}
