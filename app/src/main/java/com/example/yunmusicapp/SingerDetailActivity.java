package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.example.yunmusicapp.adapter.singerDetail.SingerDetailViewPagerAdapter;
import com.example.yunmusicapp.entity.tmp.SingerDetailTmp;
import com.example.yunmusicapp.mineView.CustomViewPager;
import com.gavin.view.flexible.FlexibleLayout;
import com.gavin.view.flexible.callback.OnReadyPullListener;
import com.google.android.material.tabs.TabLayout;

public class SingerDetailActivity extends AppCompatActivity {
    private CustomViewPager SingerDetail_ViewPager;
    private TabLayout SingerDetail_TabLayout;
    private FlexibleLayout FlexibleLayout_All;
    private ImageView SingerDetail_Img;
    private ScrollView FlexibleLayout_ScrollView;
    private ConstraintLayout SingerDetail_About;
    private TextView SingerDetail_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singer_detail);

        SingerDetail_TabLayout = findViewById(R.id.SingerDetail_TabLayout);
        SingerDetail_ViewPager = findViewById(R.id.SingerDetail_ViewPager);
        SingerDetail_Name = findViewById(R.id.SingerDetail_Name);
        SingerDetail_About = findViewById(R.id.SingerDetail_About);
        FlexibleLayout_ScrollView = findViewById(R.id.FlexibleLayout_ScrollView);
        SingerDetail_Img = findViewById(R.id.SingerDetail_Img);
        FlexibleLayout_All = findViewById(R.id.FlexibleLayout_All);

        //View总在最上层显示
        SingerDetail_About.bringToFront();

        //加载数据
        Intent intent = getIntent();
        SingerDetailTmp tmp = intent.getParcelableExtra("SingerDetail");
        if(tmp != null){
            Log.e("SingerId", tmp.getId());
            //加载图片
            Glide.with(getApplicationContext()).load(tmp.getUrl()).
                    override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).
                    centerCrop().fitCenter().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).
                    into(SingerDetail_Img);
            //歌手名字
            SingerDetail_Name.setText(tmp.getName());
        }

        //图片下拉放大
        FlexibleLayout_All.setHeader(SingerDetail_Img)
                .setReadyListener(new OnReadyPullListener() {
                    @Override
                    public boolean isReady() {
                        //下拉放大的条件
                        return FlexibleLayout_ScrollView.getScrollY() == 0;
                    }
                });

        SingerDetail_ViewPager.setAdapter(new SingerDetailViewPagerAdapter(getSupportFragmentManager()));
        SingerDetail_TabLayout.setupWithViewPager(SingerDetail_ViewPager);
        }
}
