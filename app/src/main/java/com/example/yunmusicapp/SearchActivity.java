package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.yunmusicapp.adapter.search.SearchRecyclerAdapter;
import com.example.yunmusicapp.entity.SearchHot;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView Search_Recycler;
    private ImageView Search_Singer;
    private ImageView Search_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //防止EditText打开的键盘把布局往上顶
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //沉浸式菜單欄
        BarTransparent.makeStatusBarTransparent(SearchActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(SearchActivity.this, true);

        //热搜榜初始化
        Search_Recycler = findViewById(R.id.Search_Recycler);
        Search_Recycler.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2){ //禁用滑动的RecyclerView
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        Call<SearchHot> call = HttpClient.pojoService.searchHot();
        call.enqueue(new Callback<SearchHot>() {
            @Override
            public void onResponse(Call<SearchHot> call, Response<SearchHot> response) {
                Log.e("Search is Success?", String.valueOf(response.isSuccessful() == true ? true : false));
                if(response.isSuccessful()){
                    Log.e("Data size", String.valueOf(response.body().getData().size()));
                    SearchRecyclerAdapter adapter = new SearchRecyclerAdapter(getApplicationContext());
                    Search_Recycler.setAdapter(adapter);
                    adapter.setData(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<SearchHot> call, Throwable t) {
                t.printStackTrace();
            }
        });

        //热门歌手转跳
        Search_Singer = findViewById(R.id.Search_Singer);
        Search_Singer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TopArtistsActivity.class);
                startActivity(intent);
            }
        });
    }
}