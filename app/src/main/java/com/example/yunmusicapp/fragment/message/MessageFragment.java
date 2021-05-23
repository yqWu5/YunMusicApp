package com.example.yunmusicapp.fragment.message;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.yunmusicapp.FansFollowedActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.message.MessageRecyclerAdapter;
import com.example.yunmusicapp.entity.MsgPrivate;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.mineView.CustomRecyclerView;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.message_viewpager_fragment, container, false);
        initRecyclerView();
        toOtherActivity();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //初始化一些跳转功能
    public void toOtherActivity(){
        //转跳到 FansFollowedActivity
        ImageView Message_Fans = view.findViewById(R.id.Message_Fans);
        Message_Fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FansFollowedActivity.class);
                startActivity(intent);
            }
        });
    }

    //初始化私信对话
    public void initRecyclerView(){
        CustomRecyclerView Message_Recycler = view.findViewById(R.id.Message_Recycler);
        Message_Recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        MessageRecyclerAdapter adapter = new MessageRecyclerAdapter(getContext());


        Call<MsgPrivate> call = HttpClient.pojoService.msgPrivate(Cookie.getCookie());
        call.enqueue(new Callback<MsgPrivate>() {
            @Override
            public void onResponse(Call<MsgPrivate> call, Response<MsgPrivate> response) {
                if(response.isSuccessful()){
                    Message_Recycler.setAdapter(adapter);
                    adapter.setData(response.body().getMsgs());
                }
            }

            @Override
            public void onFailure(Call<MsgPrivate> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
