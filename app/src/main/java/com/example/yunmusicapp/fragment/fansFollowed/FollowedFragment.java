package com.example.yunmusicapp.fragment.fansFollowed;

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

import com.example.yunmusicapp.ClickUserInfoActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.fansFollowed.FollowedRecycleAdapter;
import com.example.yunmusicapp.entity.UserFollows;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.HttpClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//关注列表
public class FollowedFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fansfollowed_followed_fragment, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        RecyclerView Followed_Fragment_Recycle = view.findViewById(R.id.Followed_Fragment_Recycle);

        Call<UserFollows> call = HttpClient.pojoService.userFollows(String.valueOf(Cookie.getUserId()));
        call.enqueue(new Callback<UserFollows>() {
            @Override
            public void onResponse(Call<UserFollows> call, Response<UserFollows> response) {
                if(response.isSuccessful()){
                    FollowedRecycleAdapter adapter = new FollowedRecycleAdapter(getContext());
                    Followed_Fragment_Recycle.setLayoutManager(new LinearLayoutManager(getContext()));
                    Followed_Fragment_Recycle.setAdapter(adapter);
                    adapter.setData(response.body().getFollow());
                    adapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            Intent intent = new Intent(getContext(), ClickUserInfoActivity.class);
//                            intent.putExtra("UserId", String.valueOf(response.body().getFollow().get(position).getUserId()));
                            InfoTmp.setClickUserId(String.valueOf(response.body().getFollow().get(position).getUserId()));
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<UserFollows> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
