package com.example.yunmusicapp.fragment.clickUserInfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.PlayListDetailActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.clickUserInfo.ClickUserInfoCreateRecyclerAdapter;
import com.example.yunmusicapp.adapter.mine.CreateListRecycleAdapter;
import com.example.yunmusicapp.adapter.mine.KeepListRecycleAdapter;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.HttpClient;
import com.example.yunmusicapp.utils.UnixTime2Date;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClickUserInfoFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.clickuserinfo_recycler_viewpager, container, false);
        initMusic();
        initCreateRecycler();
        initVillageYears();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    //村龄 初始化
    public void initVillageYears(){
        TextView ClickUserInfo_Years = view.findViewById(R.id.ClickUserInfo_Years);
        //时间转换-然后对村龄text赋值
        if(InfoTmp.getClickUserDetail() != null){
            String birYear = UnixTime2Date.TimeStamp2Date(String.valueOf(InfoTmp.getClickUserDetail().getProfile().getBirthday() / 1000), "yyyy");
            String regYear = UnixTime2Date.TimeStamp2Date(String.valueOf(InfoTmp.getClickUserDetail().getProfile().getCreateTime() / 1000), "yyyy");
            String regMm = UnixTime2Date.TimeStamp2Date(String.valueOf(InfoTmp.getClickUserDetail().getProfile().getCreateTime() / 1000), "MM");
            String curYear = UnixTime2Date.TimeStamp2Date(String.valueOf(System.currentTimeMillis() / 1000), "yyyy");
            ClickUserInfo_Years.setText((Integer.valueOf(curYear) - Integer.valueOf(regYear) + 1) + "年（" + regYear + "年" + regMm + "月注册）");
        }

    }
    //创建的歌单 初始化
    public void initCreateRecycler(){
        //喜欢的歌单
        RecyclerView ClickUserInfo_CreateRecycler = view.findViewById(R.id.ClickUserInfo_CreateRecycler);
        ClickUserInfo_CreateRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        //收藏的歌单
        RecyclerView ClickUserInfo_KeepRecycler = view.findViewById(R.id.ClickUserInfo_KeepRecycler);
        ClickUserInfo_KeepRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<SingList> call = HttpClient.pojoService.playList(InfoTmp.getClickUserId(), Cookie.getCookie());
        call.enqueue(new Callback<SingList>() {
            @Override
            public void onResponse(Call<SingList> call, Response<SingList> response) {
                if(response.isSuccessful()){
                    CreateListRecycleAdapter createListAdapter = new CreateListRecycleAdapter(getContext(), getParentFragmentManager());
                    KeepListRecycleAdapter keepListAdapter = new KeepListRecycleAdapter(getContext(), getParentFragmentManager());

                    ClickUserInfo_CreateRecycler.setAdapter(createListAdapter);
                    ClickUserInfo_KeepRecycler.setAdapter(keepListAdapter);

                    List<SingList.PlaylistBean> playlist = response.body().getPlaylist();
                    //创建的歌单
                    List<SingList.PlaylistBean> createList = new ArrayList<>();
                    //收藏的歌单
                    List<SingList.PlaylistBean> keepList = new ArrayList<>();
                    for(int i=0; i<playlist.size(); i++){
                        if(playlist.get(i).getUserId() == Long.valueOf(InfoTmp.getClickUserId())){
                            createList.add(playlist.get(i));
                        }else{
                            keepList.add(playlist.get(i));
                        }
                    }
                    createListAdapter.setData(createList);
                    keepListAdapter.setData(keepList);
                    //设置点击转跳到歌单信息页面
                    createListAdapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            PlayListTmp tmp = new PlayListTmp();
                            tmp.setId(createList.get(position).getId());
                            tmp.setName(createList.get(position).getName());
                            tmp.setImgUrl(createList.get(position).getCoverImgUrl());
                            tmp.setCreator_Name(createList.get(position).getCreator().getNickname());
                            tmp.setCreator_ImgUrl(createList.get(position).getCreator().getAvatarUrl());
                            Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                            intent.putExtra("playListTmp", tmp);
                            startActivity(intent);
                        }
                    });

                    keepListAdapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            PlayListTmp tmp = new PlayListTmp();
                            tmp.setId(keepList.get(position).getId());
                            tmp.setName(keepList.get(position).getName());
                            tmp.setImgUrl(keepList.get(position).getCoverImgUrl());
                            tmp.setCreator_Name(keepList.get(position).getCreator().getNickname());
                            tmp.setCreator_ImgUrl(keepList.get(position).getCreator().getAvatarUrl());
                            Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                            intent.putExtra("playListTmp", tmp);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<SingList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //初始化音乐品味
    public void initMusic(){
        TextView ClickUserInfo_RankTotal = view.findViewById(R.id.ClickUserInfo_RankTotal);
        TextView ClickUserInfo_LikeMusicTotal = view.findViewById(R.id.ClickUserInfo_LikeMusicTotal);

        //注意判空
        if(InfoTmp.getClickUserDetail() != null){
            ClickUserInfo_RankTotal.setText("累计听歌" + InfoTmp.getClickUserDetail().getListenSongs() + "首");
        }

        Call<SingList> call1 = HttpClient.pojoService.playList(InfoTmp.getClickUserId(), Cookie.getCookie());
        call1.enqueue(new Callback<SingList>() {
            @Override
            public void onResponse(Call<SingList> call, Response<SingList> response) {
                if(response.isSuccessful()){
                    ClickUserInfo_LikeMusicTotal.setText("累计听歌" + response.body().getPlaylist().get(0).getPlayCount() + "首");
                }
            }

            @Override
            public void onFailure(Call<SingList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
