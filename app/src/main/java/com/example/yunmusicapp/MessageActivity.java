package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.yunmusicapp.adapter.message.MessageViewPagerAdapter;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.BarTransparent;

public class MessageActivity extends AppCompatActivity {
    private VerticalViewPager Message_ViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        BarTransparent.makeStatusBarTransparent(MessageActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(MessageActivity.this, true);

        Message_ViewPager = findViewById(R.id.Message_ViewPager);
        Message_ViewPager.setAdapter(new MessageViewPagerAdapter(getSupportFragmentManager()));

    }
}