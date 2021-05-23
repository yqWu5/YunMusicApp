package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.yunmusicapp.adapter.userCloud.UserCloudViewPagerAdapter;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.BarTransparent;

//云盘
public class UserCloudActivity extends AppCompatActivity {
    private VerticalViewPager UserCloud_ViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_cloud);

        BarTransparent.makeStatusBarTransparent(UserCloudActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(UserCloudActivity.this, true);

        UserCloud_ViewPager = findViewById(R.id.UserCloud_ViewPager);
        UserCloud_ViewPager.setAdapter(new UserCloudViewPagerAdapter(getSupportFragmentManager()));
    }
}