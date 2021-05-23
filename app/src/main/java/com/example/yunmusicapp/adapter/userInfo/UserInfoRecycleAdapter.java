package com.example.yunmusicapp.adapter.userInfo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.FansFollowedActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.UserInfoActivity;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.UserFolloweds;
import com.example.yunmusicapp.entity.UserFollows;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.mineView.VerticalViewPager;
import com.example.yunmusicapp.utils.HttpClient;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInfoRecycleAdapter extends RecyclerView.Adapter {
    private ImageButton UserInfo_Back;
    private TextView UserInfo_Name;
    private ImageButton UserInfo_Setting;
    private ImageView UserInfo_Img;
    private TextView UserInfo_fans;
    private TextView UserInfo_fansTotal;
    private TextView UserInfo_care;
    private TextView UserInfo_careTotal;
    private TextView UserInfo_lv;
    private TextView UserInfo_lvDetail;
    private TextView UserInfo_edit;
    private Context context;
    private ConstraintLayout userInfo_Constrain;
    private View view;
    private FragmentManager fm;
    public UserInfoRecycleAdapter(Context context, FragmentManager fm) {
        this.context = context;
        this.fm = fm;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.userinfo_recycle, parent, false);
        init(parent);
        return new userInfoRecycleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class userInfoRecycleHolder extends RecyclerView.ViewHolder{
        public userInfoRecycleHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void init(@NonNull ViewGroup parent){
        //返回按钮
        UserInfo_Back = view.findViewById(R.id.UserInfo_Back);
        UserInfo_Img = view.findViewById(R.id.UserInfo_Img);
        UserInfo_fans = view.findViewById(R.id.UserInfo_fans);
        UserInfo_fansTotal = view.findViewById(R.id.UserInfo_fansTotal);
        UserInfo_care = view.findViewById(R.id.UserInfo_care);
        UserInfo_careTotal = view.findViewById(R.id.UserInfo_careTotal);
        UserInfo_lv = view.findViewById(R.id.UserInfo_lv);
        UserInfo_lvDetail = view.findViewById(R.id.UserInfo_lvDetail);
        UserInfo_edit = view.findViewById(R.id.UserInfo_edit);
        userInfo_Constrain = view.findViewById(R.id.userInfo_Constrain);
        TabLayout userInfo_recycle_TabLayout = view.findViewById(R.id.userInfo_recycle_TabLayout);
        VerticalViewPager userInfo_recycle_ViewPager = view.findViewById(R.id.userInfo_recycle_ViewPager);

        userInfo_Constrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FansFollowedActivity.class);
                context.startActivity(intent);
            }
        });

        //设置等级、头像、标题栏名称
        if(InfoTmp.getUserDetail() != null){
            UserInfo_lvDetail.setText("Lv." + InfoTmp.getUserDetail().getLevel());
            Glide.with(context).load(InfoTmp.getUserDetail().getProfile().getAvatarUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(UserInfo_Img);
        }
        //关注列表
        if(InfoTmp.getUserFollowsList() != null){
            UserInfo_careTotal.setText(String.valueOf(InfoTmp.getUserFollowsList().size()));
        }else{
            Call<UserFollows> call = HttpClient.pojoService.userFollows(String.valueOf(Cookie.getUserId()));
            call.enqueue(new Callback<UserFollows>() {
                @Override
                public void onResponse(Call<UserFollows> call, Response<UserFollows> response) {
                    if(response.isSuccessful()){
                        InfoTmp.setUserFollowsList(response.body().getFollow());
                        UserInfo_careTotal.setText(String.valueOf(InfoTmp.getUserFollowsList().size()));
                    }
                }
                @Override
                public void onFailure(Call<UserFollows> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        //粉丝列表
        if(InfoTmp.getUserFollowedsList() != null){
            UserInfo_fansTotal.setText(String.valueOf(InfoTmp.getUserFollowedsList().size()));
        }else{
            Call<UserFolloweds> call = HttpClient.pojoService.userFolloweds(String.valueOf(Cookie.getUserId()));
            call.enqueue(new Callback<UserFolloweds>() {
                @Override
                public void onResponse(Call<UserFolloweds> call, Response<UserFolloweds> response) {
                    if(response.isSuccessful()){
                        InfoTmp.setUserFollowedsList(response.body().getFolloweds());
                        UserInfo_fansTotal.setText(String.valueOf(InfoTmp.getUserFollowedsList().size()));
                    }
                }
                @Override
                public void onFailure(Call<UserFolloweds> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        //ViewPager
        userInfo_recycle_ViewPager.setAdapter(new UserInfoRecycleViewPagerAdapter(fm));
        userInfo_recycle_TabLayout.setupWithViewPager(userInfo_recycle_ViewPager);
        List<SingList.PlaylistBean> list = InfoTmp.getSingList().getPlaylist();
    }
}
