package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.yunmusicapp.adapter.musicComment.MusicCommentRecyclerAdapter;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.SongUrlTmp;
import com.example.yunmusicapp.mineView.CustomRecyclerView;

//音乐评论Activity
public class MusicCommentActivity extends AppCompatActivity {
    private RecyclerView MusicComment_RecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_comment);

        MusicComment_RecyclerView = findViewById(R.id.MusicComment_RecyclerView);

        SongUrlTmp tmp = InfoTmp.getSongUrlTmp();
        if(tmp != null){
            InfoTmp.setSongUrlTmp(tmp);
            MusicComment_RecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            MusicComment_RecyclerView.setAdapter(new MusicCommentRecyclerAdapter(getApplicationContext(), getSupportFragmentManager(), tmp));
        }

    }
}