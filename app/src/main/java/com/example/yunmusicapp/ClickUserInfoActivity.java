package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.example.yunmusicapp.adapter.clickUserInfo.ClickUserInfoRecyclerAdapter;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.mineView.CustomRecyclerView;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.utils.HttpClient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClickUserInfoActivity extends AppCompatActivity {
    private RecyclerView ClickUserInfo_Recycler;
    private TextView ClickUserInfo_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_user_info);
        //强制在主线程中执行http请求，而不是异步请求
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        BarTransparent.makeStatusBarTransparent(ClickUserInfoActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(ClickUserInfoActivity.this, true);
        //设置标题的姓名
        ClickUserInfo_Name = findViewById(R.id.ClickUserInfo_Name);
        Call<UserDetail> call = HttpClient.pojoService.userDetail(InfoTmp.getClickUserId(), Cookie.getCookie());
        //同步
        try {
            Response<UserDetail> response = call.execute();
            ClickUserInfo_Name.setText(response.body().getProfile().getNickname());
            InfoTmp.setClickUserDetail(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //RecyclerView初始化
        ClickUserInfo_Recycler = findViewById(R.id.ClickUserInfo_Recycler);
        ClickUserInfo_Recycler.setLayoutManager(new LinearLayoutManager(this));
        ClickUserInfoRecyclerAdapter adapter = new ClickUserInfoRecyclerAdapter(this, getSupportFragmentManager());
        ClickUserInfo_Recycler.setAdapter(adapter);
    }
}