package com.example.yunmusicapp.fragment.userInfo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.PlayListDetailActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.mine.CreateListRecycleAdapter;
import com.example.yunmusicapp.adapter.mine.KeepListRecycleAdapter;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.UnixTime2Date;

import java.util.ArrayList;
import java.util.List;

//用户信息页面-Fragment
public class UserInfoFragment extends Fragment {
    private RecyclerView UserInfo_Recycle_createList;
    private RecyclerView UserInfo_Recycle_keepList;
    private TextView UserInfo_Year;
    private TextView UserInfo_villageYear;
    private TextView UserInfo_gender;
    private TextView UserInfo_listenedTotal;
    private TextView UserInfo_likeMusic;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.userinfo_recycle_viewpager_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        //收藏的歌单、创建的歌单
        UserInfo_Recycle_keepList = view.findViewById(R.id.UserInfo_Recycle_keepList);
        UserInfo_Recycle_createList = view.findViewById(R.id.UserInfo_Recycle_createList);

        CreateListRecycleAdapter createListRecycleAdapter = new CreateListRecycleAdapter(getContext(), getParentFragmentManager());
        KeepListRecycleAdapter keepListRecycleAdapter = new KeepListRecycleAdapter(getContext(), getParentFragmentManager());

        UserInfo_Recycle_keepList.setLayoutManager(new LinearLayoutManager(getContext()));
        UserInfo_Recycle_createList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<SingList.PlaylistBean> createPlayList = InfoTmp.getCreatePlayList();
        List<SingList.PlaylistBean> keepPlayList = InfoTmp.getKeepPlayList();
        Log.e("keepPlayList Size", String.valueOf(InfoTmp.getKeepPlayList().get(0).getTrackCount()));
        List<SingList.PlaylistBean> createPlayList1 = new ArrayList<>();
        if(createPlayList != null){
            for(int i=1; i<createPlayList.size(); i++){
                createPlayList1.add(createPlayList.get(i));
            }
        }

        createListRecycleAdapter.setData(createPlayList1);
        keepListRecycleAdapter.setData(keepPlayList);

        //点击转跳到具体歌单里面
        createListRecycleAdapter.setBaseOnClickListener(new BaseOnclickListener() {
            @Override
            public void click(int position) {
                PlayListTmp tmp = new PlayListTmp();
                tmp.setId(createPlayList1.get(position).getId());
                tmp.setName(createPlayList1.get(position).getName());
                tmp.setImgUrl(createPlayList1.get(position).getCoverImgUrl());
                Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                intent.putExtra("playListTmp", tmp);
                startActivity(intent);
            }
        });
        keepListRecycleAdapter.setBaseOnClickListener(new BaseOnclickListener() {
            @Override
            public void click(int position) {
                PlayListTmp tmp = new PlayListTmp();
                tmp.setId(keepPlayList.get(position).getId());
                tmp.setName(keepPlayList.get(position).getName());
                tmp.setImgUrl(keepPlayList.get(position).getCoverImgUrl());
                Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                intent.putExtra("playListTmp", tmp);
                startActivity(intent);
            }
        });
        UserInfo_Recycle_keepList.setAdapter(keepListRecycleAdapter);
        UserInfo_Recycle_createList.setAdapter(createListRecycleAdapter);

        //年龄
        UserInfo_Year = view.findViewById(R.id.UserInfo_Year);
        //村龄
        UserInfo_villageYear = view.findViewById(R.id.UserInfo_villageYear);
        //性别
        UserInfo_gender = view.findViewById(R.id.UserInfo_gender);
        //累计听歌次数
        UserInfo_listenedTotal = view.findViewById(R.id.UserInfo_listenedTotal);
        if(InfoTmp.getUserDetail() != null){
            UserInfo_listenedTotal.setText("累计听歌" + InfoTmp.getUserDetail().getListenSongs() + "首");
            UserInfo_gender.setText(InfoTmp.getUserDetail().getProfile().getGender() == 1 ? "男" : "女");
            //时间转换-然后对村龄text赋值
            String birYear = UnixTime2Date.TimeStamp2Date(String.valueOf(InfoTmp.getUserDetail().getProfile().getBirthday() / 1000), "yyyy");
            Log.e("birYear", birYear);
            String regYear = UnixTime2Date.TimeStamp2Date(String.valueOf(InfoTmp.getUserDetail().getProfile().getCreateTime() / 1000), "yyyy");
            String regMm = UnixTime2Date.TimeStamp2Date(String.valueOf(InfoTmp.getUserDetail().getProfile().getCreateTime() / 1000), "MM");
            String curYear = UnixTime2Date.TimeStamp2Date(String.valueOf(System.currentTimeMillis() / 1000), "yyyy");
            UserInfo_villageYear.setText((Integer.valueOf(curYear) - Integer.valueOf(regYear) + 1) + "年（" + regYear + "年" + regMm + "月注册）");
            UserInfo_Year.setText(String.valueOf(Integer.valueOf(curYear) - Integer.valueOf(birYear)) + "岁");
        }
        //我喜欢的音乐
        UserInfo_likeMusic = view.findViewById(R.id.UserInfo_likeMusic);
        if(InfoTmp.getLikePlayList() != null){
            UserInfo_likeMusic.setText(InfoTmp.getLikePlayList().getTrackCount() + "首，" + "播放" + InfoTmp.getLikePlayList().getPlayCount()  + "次");
        }
    }
}
