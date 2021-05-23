package com.example.yunmusicapp.fragment.discovery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.PlayListDetailActivity;
import com.example.yunmusicapp.PlayVideoActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.discovery.DiscoveryFragmentAppRecycleAdapter;
import com.example.yunmusicapp.adapter.discovery.DiscoveryFragmentCalendarAdapter;
import com.example.yunmusicapp.adapter.discovery.DiscoveryFragmentRecommendPlayListAdapter;
import com.example.yunmusicapp.adapter.discovery.DiscoveryFragmentVideosAdapter;
import com.example.yunmusicapp.adapter.discovery.ImgBannerAdapter;
import com.example.yunmusicapp.entity.DataBean;
import com.example.yunmusicapp.entity.DiscoveryCalendar;
import com.example.yunmusicapp.entity.RecommendPlayList;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.DiscoveryApp;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.mineView.CustomRecyclerView;
import com.example.yunmusicapp.utils.HttpClient;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.transformer.RotateYTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoveryFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.discovery_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        //轮播图
        Banner DiscoveryFragment_Recycle_Banner;
        DiscoveryFragment_Recycle_Banner = view.findViewById(R.id.DiscoveryFragment_Banner);
        ImgBannerAdapter adapter = new ImgBannerAdapter(DataBean.getTestData3());
        DiscoveryFragment_Recycle_Banner.setAdapter(adapter).addBannerLifecycleObserver(this)
                .setCurrentItem(1, false)
                .setBannerRound(BannerUtils.dp2px(15))
                .addPageTransformer(new RotateYTransformer())
                .setIndicator(new CircleIndicator(getContext()));//设置指示器

        //发现-应用Recycle
        CustomRecyclerView DiscoveryFragment_AppRecycle = view.findViewById(R.id.DiscoveryFragment_AppRecycle);
        DiscoveryFragment_AppRecycle.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        DiscoveryFragmentAppRecycleAdapter adapter1 = new DiscoveryFragmentAppRecycleAdapter(getContext());
        DiscoveryFragment_AppRecycle.setAdapter(adapter1);
        adapter1.setData(initAppList());

        //推荐歌单
        CustomRecyclerView DiscoveryFragment_RecommendPlayList = view.findViewById(R.id.DiscoveryFragment_RecommendPlayList);
        DiscoveryFragment_RecommendPlayList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        DiscoveryFragmentRecommendPlayListAdapter adapter2 = new DiscoveryFragmentRecommendPlayListAdapter(getContext());
        Call<RecommendPlayList> call = HttpClient.pojoService.recommendPlayList(Cookie.getCookie());
        call.enqueue(new Callback<RecommendPlayList>() {
            @Override
            public void onResponse(Call<RecommendPlayList> call, Response<RecommendPlayList> response) {
                if(response.isSuccessful()){
                    DiscoveryFragment_RecommendPlayList.setAdapter(adapter2);
                    adapter2.setData(response.body().getRecommend());
                    adapter2.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            PlayListTmp tmp = new PlayListTmp();
                            tmp.setId(response.body().getRecommend().get(position).getId());
                            tmp.setName(response.body().getRecommend().get(position).getCreator().getNickname());
                            tmp.setImgUrl(response.body().getRecommend().get(position).getPicUrl());
                            tmp.setCreator_Name(response.body().getRecommend().get(position).getCreator().getNickname());
                            tmp.setCreator_ImgUrl(response.body().getRecommend().get(position).getCreator().getAvatarUrl());
                            Intent intent = new Intent(getContext(), PlayListDetailActivity.class);
                            intent.putExtra("playListTmp", tmp);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<RecommendPlayList> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //精选视频
        CustomRecyclerView DiscoveryFragment_Videos = view.findViewById(R.id.DiscoveryFragment_Videos);
        DiscoveryFragment_Videos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        DiscoveryFragmentVideosAdapter videosAdapter = new DiscoveryFragmentVideosAdapter(getContext());
        Call<RecommendVideos> videosCall = HttpClient.pojoService.recommendVideos("0", Cookie.getCookie());
        videosCall.enqueue(new Callback<RecommendVideos>() {
            @Override
            public void onResponse(Call<RecommendVideos> call, Response<RecommendVideos> response) {
                Log.e("success", String.valueOf(response.isSuccessful() == true ? true : false));
                if(response.isSuccessful()){
                    DiscoveryFragment_Videos.setAdapter(videosAdapter);
                    videosAdapter.setData(response.body().getDatas());
                    videosAdapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            Intent intent = new Intent(getContext(), PlayVideoActivity.class);
                            InfoTmp.setRecommendVideosDataBean(response.body().getDatas().get(position).getData());
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<RecommendVideos> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //音乐日历
        RecyclerView DiscoveryFragment_Calendar = view.findViewById(R.id.DiscoveryFragment_Calendar);
        DiscoveryFragment_Calendar.setLayoutManager(new LinearLayoutManager(getContext()));
        DiscoveryFragmentCalendarAdapter calendarAdapter = new DiscoveryFragmentCalendarAdapter(getContext());
        Call<DiscoveryCalendar> calendarCall = HttpClient.pojoService.discoveryCalendar(Cookie.getCookie());
        calendarCall.enqueue(new Callback<DiscoveryCalendar>() {
            @Override
            public void onResponse(Call<DiscoveryCalendar> call, Response<DiscoveryCalendar> response) {
                if(response.isSuccessful()){
                    DiscoveryFragment_Calendar.setAdapter(calendarAdapter);
                    calendarAdapter.setData(response.body().getData().getCalendarEvents());
                }
            }

            @Override
            public void onFailure(Call<DiscoveryCalendar> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    //初始化发现-APP应用
    public List<DiscoveryApp> initAppList(){
        List<DiscoveryApp> list = new ArrayList<>();
        //每日推荐
        DiscoveryApp local = new DiscoveryApp(); local.setDiscoveryApp_Img(R.mipmap.discovery_recommend); local.setDiscoveryApp_Name("每日推荐");
        //私人FM
        DiscoveryApp cloud = new DiscoveryApp(); cloud.setDiscoveryApp_Img(R.mipmap.discovery_fm); cloud.setDiscoveryApp_Name("私人FM");
        //歌单广场
        DiscoveryApp buy = new DiscoveryApp(); buy.setDiscoveryApp_Img(R.mipmap.discovery_playlist); buy.setDiscoveryApp_Name("歌单广场");
        //排行榜
        DiscoveryApp recent = new DiscoveryApp(); recent.setDiscoveryApp_Img(R.mipmap.discovery_rank); recent.setDiscoveryApp_Name("排行榜");
        //直播
        DiscoveryApp friend = new DiscoveryApp(); friend.setDiscoveryApp_Img(R.mipmap.discovery_now); friend.setDiscoveryApp_Name("直播");
        //专注冥想
        DiscoveryApp keep = new DiscoveryApp(); keep.setDiscoveryApp_Img(R.mipmap.discovery_careful); keep.setDiscoveryApp_Name("专注冥想");
        //数字专辑
        DiscoveryApp digit = new DiscoveryApp(); digit.setDiscoveryApp_Img(R.mipmap.discovery_digit); digit.setDiscoveryApp_Name("数字专辑");
        //歌房
        DiscoveryApp blog = new DiscoveryApp(); blog.setDiscoveryApp_Img(R.mipmap.discovery_house); blog.setDiscoveryApp_Name("歌房");
        //游戏专区
        DiscoveryApp classic = new DiscoveryApp(); classic.setDiscoveryApp_Img(R.mipmap.discovery_game); classic.setDiscoveryApp_Name("游戏专区");

        list.add(local);
        list.add(cloud);
        list.add(buy);
        list.add(recent);
        list.add(friend);
        list.add(keep);
        list.add(digit);
        list.add(blog);
        list.add(classic);
        return list;
    }

}
