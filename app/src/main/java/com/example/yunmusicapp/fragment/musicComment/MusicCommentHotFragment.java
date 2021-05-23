package com.example.yunmusicapp.fragment.musicComment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.musicComment.MusicCommentRecyclerViewPagerRecyclerAdapter;
import com.example.yunmusicapp.entity.CommentMusic;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicCommentHotFragment extends Fragment {
    private View view;
    @NonNull
    @Override
    public LifecycleOwner getViewLifecycleOwner() {
        return super.getViewLifecycleOwner();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.musiccomment_recycler_viewpager, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        //评论
        RecyclerView MusicComment_Recycler_ViewPager_Recycler = view.findViewById(R.id.MusicComment_Recycler_ViewPager_Recycler);
        MusicComment_Recycler_ViewPager_Recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        MusicCommentRecyclerViewPagerRecyclerAdapter adapter = new MusicCommentRecyclerViewPagerRecyclerAdapter(getContext());

        Call<CommentMusic> call = HttpClient.pojoService.commentMusic(InfoTmp.getSongUrlTmp().getId());
        call.enqueue(new Callback<CommentMusic>() {
            @Override
            public void onResponse(Call<CommentMusic> call, Response<CommentMusic> response) {
                if(response.isSuccessful()){
                    MusicComment_Recycler_ViewPager_Recycler.setAdapter(adapter);
                    adapter.setData(response.body().getHotComments());
                }
            }

            @Override
            public void onFailure(Call<CommentMusic> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
