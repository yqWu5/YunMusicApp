package com.example.yunmusicapp.fragment.cloudVillage.recommend;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.PlayVideoActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.cloudVillage.recommend.RecommendSquareAdapter;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.HttpClient;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.io.IOException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//广场Fragment
public class RecommendSquareFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cloudvillage_square_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        TwinklingRefreshLayout Square_RefreshLayout = view.findViewById(R.id.Square_RefreshLayout);
        RecyclerView Square_RecyclerView = view.findViewById(R.id.Square_RecyclerView);

        Square_RecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecommendSquareAdapter adapter = new RecommendSquareAdapter(getContext());

        Call<RecommendVideos> call = HttpClient.pojoService.recommendVideos("1", Cookie.getCookie());
        call.enqueue(new Callback<RecommendVideos>() {
            @Override
            public void onResponse(Call<RecommendVideos> call, Response<RecommendVideos> response) {
                if(response.isSuccessful()){
                    Square_RecyclerView.setAdapter(adapter);
                    adapter.setData(response.body().getDatas());
                    adapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            InfoTmp.setRecommendVideosDataBean(response.body().getDatas().get(position).getData());
                            Intent intent = new Intent(getContext(), PlayVideoActivity.class);
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


        //刷新数据监听
        Square_RefreshLayout.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Call<RecommendVideos> call = HttpClient.pojoService.recommendVideos(String.valueOf(new Random().nextInt(10)), Cookie.getCookie());
                        try {
                            Response<RecommendVideos> response = call.execute();
                            adapter.setData(response.body().getDatas());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        refreshLayout.finishRefreshing();
                        Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_LONG);
                    }
                },2000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Call<RecommendVideos> call = HttpClient.pojoService.recommendVideos(String.valueOf(new Random().nextInt(10) + 10), Cookie.getCookie());
                        try {
                            Response<RecommendVideos> response = call.execute();
                            adapter.loadMore(response.body().getDatas());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        refreshLayout.finishLoadmore();
                    }
                },2000);
            }
        });
    }
}
