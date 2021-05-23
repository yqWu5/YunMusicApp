package com.example.yunmusicapp.adapter.clickUserInfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.HttpClient;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClickUserInfoRecyclerAdapter extends RecyclerView.Adapter<ClickUserInfoRecyclerAdapter.ClickUserInfoRecyclerAdapterHolder> {
    private Context context;
    private FragmentManager fm;
    private View view;
    public ClickUserInfoRecyclerAdapter(Context context, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
    }

    @NonNull
    @Override
    public ClickUserInfoRecyclerAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.clicksuerinfo_recycler, parent, false);
        initInfo();
        initViewPager();
        return new ClickUserInfoRecyclerAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClickUserInfoRecyclerAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ClickUserInfoRecyclerAdapterHolder extends RecyclerView.ViewHolder{

        public ClickUserInfoRecyclerAdapterHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    //初始化个人信息
    public void initInfo(){
        ImageView ClickUserInfo_Recycler_Img = view.findViewById(R.id.ClickUserInfo_Recycler_Img);
        TextView ClickUserInfo_FansTotal = view.findViewById(R.id.ClickUserInfo_FansTotal);
        TextView ClickUserInfo_CareTotal = view.findViewById(R.id.ClickUserInfo_CareTotal);
        TextView ClickUserInfo_Lv = view.findViewById(R.id.ClickUserInfo_Lv);

        Call<UserDetail> userDetailCall = HttpClient.pojoService.userDetail(InfoTmp.getClickUserId(), Cookie.getCookie());
        userDetailCall.enqueue(new Callback<UserDetail>() {
            @Override
            public void onResponse(Call<UserDetail> call, Response<UserDetail> response) {
                if(response.isSuccessful()){
                    ClickUserInfo_FansTotal.setText(String.valueOf(response.body().getProfile().getFolloweds()));
                    ClickUserInfo_CareTotal.setText(String.valueOf(response.body().getProfile().getFollows()));
                    ClickUserInfo_Lv.setText("Lv." + response.body().getLevel());
                    Glide.with(context).load(response.body().getProfile().getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(ClickUserInfo_Recycler_Img);
                }
            }

            @Override
            public void onFailure(Call<UserDetail> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //初始化ViewPager
    public void initViewPager(){
        VerticalViewPager ClickUserInfo_ViewPager = view.findViewById(R.id.ClickUserInfo_ViewPager);
        TabLayout ClickUserInfo_Recycler_TabLayout = view.findViewById(R.id.ClickUserInfo_Recycler_TabLayout);

        ClickUserInfo_ViewPager.setAdapter(new ClickUserInfoViewPagerAdapter(fm));
        ClickUserInfo_Recycler_TabLayout.setupWithViewPager(ClickUserInfo_ViewPager);
    }
}
