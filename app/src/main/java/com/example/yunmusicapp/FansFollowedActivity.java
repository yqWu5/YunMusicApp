package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.yunmusicapp.adapter.fansFollowed.FansFollowedViewPagerAdapter;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.BarTransparent;
import com.google.android.material.tabs.TabLayout;

//粉丝 关注 Activity
public class FansFollowedActivity extends AppCompatActivity {
    private TabLayout FansFollowed_TabLayout;
    private ViewPager FansFollowed_ViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans_followed);

        BarTransparent.makeStatusBarTransparent(FansFollowedActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(FansFollowedActivity.this, true);

        FansFollowed_TabLayout = findViewById(R.id.FansFollowed_TabLayout);
        FansFollowed_ViewPager = findViewById(R.id.FansFollowed_ViewPager);

        FansFollowed_ViewPager.setAdapter(new FansFollowedViewPagerAdapter(getSupportFragmentManager()));
        FansFollowed_TabLayout.setupWithViewPager(FansFollowed_ViewPager);
    }
}