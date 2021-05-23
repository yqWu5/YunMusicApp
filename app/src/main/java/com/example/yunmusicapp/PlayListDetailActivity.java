package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.yunmusicapp.adapter.playList.PlayListDetailViewPagerAdapter;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.utils.SetColor;

public class PlayListDetailActivity extends AppCompatActivity {
    private TextView PlayListDetail_Name;
    private VerticalViewPager PlayListDetail_ViewPager;
    private ConstraintLayout playList_Detail_Activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_detail);

        BarTransparent.makeStatusBarTransparent(PlayListDetailActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(PlayListDetailActivity.this, true);

        PlayListDetail_Name = findViewById(R.id.PlayListDetail_Name);
        PlayListDetail_ViewPager = findViewById(R.id.PlayListDetail_ViewPager);
        playList_Detail_Activity = findViewById(R.id.playList_Detail_Activity);

        Intent intent = getIntent();
        PlayListTmp tmp = intent.getParcelableExtra("playListTmp");
        SetColor.asBitmap(tmp.getImgUrl(), this, playList_Detail_Activity);
        //设置歌单名字
        if(tmp != null){
            PlayListDetail_Name.setText(tmp.getName());
        }
        PlayListDetailViewPagerAdapter adapter = new PlayListDetailViewPagerAdapter(getSupportFragmentManager());
        adapter.setTmp(tmp);
        PlayListDetail_ViewPager.setAdapter(adapter);
    }
}