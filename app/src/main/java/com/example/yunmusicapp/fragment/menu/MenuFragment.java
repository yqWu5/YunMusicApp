package com.example.yunmusicapp.fragment.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.yunmusicapp.MessageActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.menu.MenuRecyclerMessageAdapter;
import com.example.yunmusicapp.entity.tmp.MenuMessage;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.mineView.CustomRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_menu, container, false);
        initRecyclerMessage();
        initRecyclerService();
        initRecyclerOther();
        initRecyclerEnd();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    //初始化消息
    public void initRecyclerMessage(){
        CustomRecyclerView Menu_recycler_Message = view.findViewById(R.id.Menu_recycler_Message);
        Menu_recycler_Message.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        MenuRecyclerMessageAdapter adapter = new MenuRecyclerMessageAdapter(getContext());
        Menu_recycler_Message.setAdapter(adapter);

        List<MenuMessage> list = new ArrayList<>();

        MenuMessage message = new MenuMessage(); message.setImg(R.mipmap.menu_messge); message.setTitle("我的消息");
        MenuMessage cloudBei = new MenuMessage(); cloudBei.setImg(R.mipmap.menu_cloudbei); cloudBei.setTitle("云贝中心");
        MenuMessage creator = new MenuMessage(); creator.setImg(R.mipmap.menu_creator); creator.setTitle("创作中心");

        list.add(message);
        list.add(cloudBei);
        list.add(creator);

        adapter.setData(list);

        adapter.setBaseOnClickListener(new BaseOnclickListener() {
            @Override
            public void click(int position) {
                if(position == 0){ //我的消息转跳
                    Intent intent = new Intent(getContext(), MessageActivity.class);
                    intent.putExtra("type", String.valueOf(position));
                    startActivity(intent);
                }
            }
        });
    }

    //初始化音乐服务
    public void initRecyclerService(){
        CustomRecyclerView Menu_recycler_Service = view.findViewById(R.id.Menu_recycler_Service);
        Menu_recycler_Service.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        MenuRecyclerMessageAdapter adapter = new MenuRecyclerMessageAdapter(getContext());
        Menu_recycler_Service.setAdapter(adapter);

        List<MenuMessage> list = new ArrayList<>();

        MenuMessage ticket = new MenuMessage(); ticket.setImg(R.mipmap.menu_service_ticket); ticket.setTitle("云村有票");
        MenuMessage market = new MenuMessage(); market.setImg(R.mipmap.menu_service_markit); market.setTitle("商城");
        MenuMessage music = new MenuMessage(); music.setImg(R.mipmap.menu_service_music); music.setTitle("口袋彩铃");

        list.add(ticket);
        list.add(market);
        list.add(music);

        adapter.setData(list);
    }

    //初始化其他
    public void initRecyclerOther(){
        CustomRecyclerView Menu_recycler_Other = view.findViewById(R.id.Menu_recycler_Other);
        Menu_recycler_Other.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        MenuRecyclerMessageAdapter adapter = new MenuRecyclerMessageAdapter(getContext());
        Menu_recycler_Other.setAdapter(adapter);

        List<MenuMessage> list = new ArrayList<>();

        MenuMessage setting = new MenuMessage(); setting.setImg(R.mipmap.menu_other_setting); setting.setTitle("设置");
        MenuMessage night = new MenuMessage(); night.setImg(R.mipmap.menu_other_night); night.setTitle("夜间模式");
        MenuMessage timeClose = new MenuMessage(); timeClose.setImg(R.mipmap.menu_other_timeclose); timeClose.setTitle("定时关闭");
        MenuMessage dressUp =  new MenuMessage(); dressUp.setImg(R.mipmap.menu_other_dressup); dressUp.setTitle("个性装扮");
        MenuMessage meanWhile = new MenuMessage(); meanWhile.setImg(R.mipmap.menu_other_meanwhile); meanWhile.setTitle("边听边存");
        MenuMessage onlineFree = new MenuMessage(); onlineFree.setImg(R.mipmap.menu_other_onlinefree); onlineFree.setTitle("在线听歌免流量");
        MenuMessage blackList = new MenuMessage(); blackList.setImg(R.mipmap.menu_other_blacklist); blackList.setTitle("音乐黑名单");
        MenuMessage teenagers = new MenuMessage(); teenagers.setImg(R.mipmap.menu_other_teenagers); teenagers.setTitle("青少年模式");
        MenuMessage alarmClock = new MenuMessage(); alarmClock.setImg(R.mipmap.menu_other_timeclose); alarmClock.setTitle("音乐闹钟");

        list.add(setting);
        list.add(night);
        list.add(timeClose);
        list.add(dressUp);
        list.add(meanWhile);
        list.add(onlineFree);
        list.add(blackList);
        list.add(teenagers);
        list.add(alarmClock);

        adapter.setData(list);
    }

    //初始化结尾
    public void initRecyclerEnd(){
        CustomRecyclerView Menu_recycler_End = view.findViewById(R.id.Menu_recycler_End);
        Menu_recycler_End.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        MenuRecyclerMessageAdapter adapter = new MenuRecyclerMessageAdapter(getContext());
        Menu_recycler_End.setAdapter(adapter);

        List<MenuMessage> list = new ArrayList<>();

        MenuMessage orders = new MenuMessage(); orders.setImg(R.mipmap.menu_end_orders); orders.setTitle("我的订单");
        MenuMessage customService = new MenuMessage(); customService.setImg(R.mipmap.menu_end_customservice); customService.setTitle("我的客服");
        MenuMessage share = new MenuMessage(); share.setImg(R.mipmap.menu_end_share); share.setTitle("分享网易云音乐");
        MenuMessage about = new MenuMessage(); about.setImg(R.mipmap.menu_end_about); about.setTitle("关于");

        list.add(orders);
        list.add(customService);
        list.add(share);
        list.add(about);

        adapter.setData(list);
    }
}
