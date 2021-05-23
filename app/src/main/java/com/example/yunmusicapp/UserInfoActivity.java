package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.adapter.userInfo.UserInfoRecycleAdapter;
import com.example.yunmusicapp.entity.UserFolloweds;
import com.example.yunmusicapp.entity.UserFollows;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoActivity extends AppCompatActivity {
    private RecyclerView UserInfo_Recycle;
    private TextView UserInfo_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        BarTransparent.makeStatusBarTransparent(UserInfoActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(UserInfoActivity.this, true);

        UserInfo_Recycle = findViewById(R.id.UserInfo_Recycle);
        UserInfo_Name = findViewById(R.id.UserInfo_Name);
        //Recycle布局
        UserInfoRecycleAdapter adapter = new UserInfoRecycleAdapter(this, getSupportFragmentManager());
        UserInfo_Recycle.setLayoutManager(new LinearLayoutManager(this));
        UserInfo_Recycle.setAdapter(adapter);
        UserInfo_Name.setText(InfoTmp.getUserDetail().getProfile().getNickname());

    }


}