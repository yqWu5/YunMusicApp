package com.example.yunmusicapp.fragment.mine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.PlayListDetailActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.UserCloudActivity;
import com.example.yunmusicapp.UserInfoActivity;
import com.example.yunmusicapp.adapter.mine.CreateListAdapterViewPager;
import com.example.yunmusicapp.adapter.mine.MineLikeMusicAdapter;
import com.example.yunmusicapp.adapter.mine.MusicAppAdapter;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.MusicApp;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.mineView.CustomViewPager;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.HttpClient;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MineFragment extends Fragment {
    public View view;
    private RecyclerView Mine_MusicApp;
    private RecyclerView Mine_LikeMusic;
    private ImageView Mine_Img;
    private TextView Mine_Name;
    private TextView Mine_Lv;
    private TabLayout Mine_TabLayout;
    private CustomViewPager Mine_ViewPager;
    private ImageView Mine_More;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mine_recycle, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        //个人信息转跳
        Mine_More = view.findViewById(R.id.Mine_More);
        Mine_More.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), UserInfoActivity.class);
                startActivity(intent);
            }
        });
        //音乐应用RecycleView
        Mine_MusicApp = view.findViewById(R.id.Mine_MusicApp);
        Mine_MusicApp.setLayoutManager(new GridLayoutManager(getContext(), 4){ //网格布局
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        MusicAppAdapter musicAppAdapter = new MusicAppAdapter(getContext());
        musicAppAdapter.setBaseOnClickListener(new BaseOnclickListener() { //添加跳转按钮
            @Override
            public void click(int position) {
                //云盘跳转
                if(position == 1){
                    Intent intent = new Intent(getContext(), UserCloudActivity.class);
                    startActivity(intent);
                }
            }
        });
        Mine_MusicApp.setAdapter(musicAppAdapter);
        List<MusicApp> list = setMusicAppList();
        musicAppAdapter.setData(list);
        //设置头像姓名等级等等
        Mine_Img = view.findViewById(R.id.Mine_Img);

        Mine_Name = view.findViewById(R.id.Mine_Name);
        Mine_Lv = view.findViewById(R.id.Mine_Lv);

        UserDetail userDetail = InfoTmp.getUserDetail();
        if(userDetail != null){
            Mine_Name.setText(userDetail.getProfile().getNickname());
            Mine_Lv.setText("Lv." + userDetail.getLevel());
            Glide.with(getContext()).load(userDetail.getProfile().getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(Mine_Img);
        }

        //我喜欢的音乐
        Mine_LikeMusic = view.findViewById(R.id.Mine_LikeMusic);
        MineLikeMusicAdapter likeMusicAdapter = new MineLikeMusicAdapter(getContext());
        Mine_LikeMusic.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        likeMusicAdapter.setBaseOnClickListener(new BaseOnclickListener() {
            @Override
            public void click(int position) {
                PlayListTmp tmp = new PlayListTmp();
                tmp.setId(InfoTmp.getLikePlayList().getId());
                tmp.setName(InfoTmp.getLikePlayList().getName());
                tmp.setImgUrl(InfoTmp.getLikePlayList().getCoverImgUrl());
                Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                intent.putExtra("playListTmp", tmp);
                startActivity(intent);
            }
        });
        Mine_LikeMusic.setAdapter(likeMusicAdapter);
        //歌单ViewPager
        Mine_TabLayout = view.findViewById(R.id.Mine_TabLayout);
        Mine_ViewPager = view.findViewById(R.id.Mine_ViewPager);

        CreateListAdapterViewPager createListAdapterViewPagerAdapter = new CreateListAdapterViewPager(getParentFragmentManager());
        Mine_ViewPager.setAdapter(createListAdapterViewPagerAdapter);
        createListAdapterViewPagerAdapter.notifyDataSetChanged();
        Mine_TabLayout.setupWithViewPager(Mine_ViewPager);

    }
    //音乐应用初始化
    public List<MusicApp> setMusicAppList(){
        List<MusicApp> musciAppList = new ArrayList<>();
        //本地音乐
        MusicApp local = new MusicApp(); local.setMusic_Img(R.mipmap.musicappa0); local.setMusic_Name("本地音乐");
        //音乐云盘
        MusicApp cloud = new MusicApp(); cloud.setMusic_Img(R.mipmap.musicappa1); cloud.setMusic_Name("音乐云盘");
        //已购
        MusicApp buy = new MusicApp(); buy.setMusic_Img(R.mipmap.musicappa2); buy.setMusic_Name("已购商品");
        //最近播放
        MusicApp recent = new MusicApp(); recent.setMusic_Img(R.mipmap.musicappa3); recent.setMusic_Name("最近播放");
        //我的好友
        MusicApp friend = new MusicApp(); friend.setMusic_Img(R.mipmap.musicappa4); friend.setMusic_Name("我的好友");
        //收藏和赞
        MusicApp keep = new MusicApp(); keep.setMusic_Img(R.mipmap.musicappa5); keep.setMusic_Name("收藏和赞");
        //我的博客
        MusicApp blog = new MusicApp(); blog.setMusic_Img(R.mipmap.musicappa6); blog.setMusic_Name("我的播客");
        //古典专区
        MusicApp classic = new MusicApp(); classic.setMusic_Img(R.mipmap.musicappa7); classic.setMusic_Name("古典专区");

        musciAppList.add(local);
        musciAppList.add(cloud);
        musciAppList.add(buy);
        musciAppList.add(recent);
        musciAppList.add(friend);
        musciAppList.add(keep);
        musciAppList.add(blog);
        musciAppList.add(classic);
        return musciAppList;
    }
}
