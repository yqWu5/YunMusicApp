package com.example.yunmusicapp.fragment.userCloud;

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

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.userCloud.UserCloudRecyclerAdapter;
import com.example.yunmusicapp.entity.UserCloud;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserCloudFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.usercloud_viewpager, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //初始化
    public void initView(){
        TextView UserCloud_ViewPager_Total = view.findViewById(R.id.UserCloud_ViewPager_Total);
        RecyclerView UserCloud_ViewPager_Recycler = view.findViewById(R.id.UserCloud_ViewPager_Recycler);

        Call<UserCloud> call = HttpClient.pojoService.userCloud(Cookie.getCookie());
        call.enqueue(new Callback<UserCloud>() {
            @Override
            public void onResponse(Call<UserCloud> call, Response<UserCloud> response) {
                if(response.isSuccessful()){
                    UserCloud_ViewPager_Total.setText("(" + response.body().getCount() + ")");

                    UserCloud_ViewPager_Recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    UserCloudRecyclerAdapter adapter = new UserCloudRecyclerAdapter(getContext());
                    UserCloud_ViewPager_Recycler.setAdapter(adapter);
                    adapter.setData(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<UserCloud> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
