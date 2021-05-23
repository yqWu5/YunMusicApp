package com.example.yunmusicapp.fragment.cloudVillage.recommend;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.cloudVillage.recommend.RecommendMvAdapter;
import com.example.yunmusicapp.entity.MvAll;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.utils.HttpClient;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.io.IOException;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendMvFragment extends Fragment {
    private static int offset = 0;
    private static int limit = 10;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.cloudvillage_mv_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        RecyclerView CloudVillage_Mv_Recycler = view.findViewById(R.id.CloudVillage_Mv_Recycler);
        TwinklingRefreshLayout CloudVillage_Mv = view.findViewById(R.id.CloudVillage_Mv);

        CloudVillage_Mv_Recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecommendMvAdapter adapter = new RecommendMvAdapter(getContext());
        Call<MvAll> call = HttpClient.pojoService.mvAll(String.valueOf(limit), String.valueOf(offset), Cookie.getCookie());
        call.enqueue(new Callback<MvAll>() {
            @Override
            public void onResponse(Call<MvAll> call, Response<MvAll> response) {
                if(response.isSuccessful()){
                    CloudVillage_Mv_Recycler.setAdapter(adapter);
                    adapter.setData(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<MvAll> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //刷新数据
        CloudVillage_Mv.setOnRefreshListener(new RefreshListenerAdapter(){
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Call<MvAll> call = HttpClient.pojoService.mvAll(String.valueOf(limit), String.valueOf(new Random().nextInt(50)), Cookie.getCookie());
                        try {
                            Response<MvAll> response = call.execute();
                            adapter.setData(response.body().getData());
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
                        Call<MvAll> call = HttpClient.pojoService.mvAll(String.valueOf(limit), String.valueOf(new Random().nextInt(50)), Cookie.getCookie());
                        try {
                            Response<MvAll> response = call.execute();
                            adapter.loadMore(response.body().getData());
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
