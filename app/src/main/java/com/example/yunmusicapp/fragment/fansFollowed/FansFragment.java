package com.example.yunmusicapp.fragment.fansFollowed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.ClickUserInfoActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.fansFollowed.FansRecycleAdapter;
import com.example.yunmusicapp.entity.UserFolloweds;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FansFragment extends Fragment {
    private Context context;
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

        Call<UserFolloweds> call = HttpClient.pojoService.userFolloweds(String.valueOf(Cookie.getUserId()));
        call.enqueue(new Callback<UserFolloweds>() {
            @Override
            public void onResponse(Call<UserFolloweds> call, Response<UserFolloweds> response) {
                if(response.isSuccessful()){
                    Followed_Fragment_Recycle.setLayoutManager(new LinearLayoutManager(getContext()));
                    FansRecycleAdapter adapter = new FansRecycleAdapter(getContext());
                    Followed_Fragment_Recycle.setAdapter(adapter);
                    adapter.setData(response.body().getFolloweds());
                    adapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            Intent intent = new Intent(getContext(), ClickUserInfoActivity.class);
//                            intent.putExtra("UserId", String.valueOf(response.body().getFolloweds().get(position).getUserId()));
                            InfoTmp.setClickUserId(String.valueOf(response.body().getFolloweds().get(position).getUserId()));
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<UserFolloweds> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
