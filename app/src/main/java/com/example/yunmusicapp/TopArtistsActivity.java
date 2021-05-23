package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.yunmusicapp.adapter.topArtists.TopArtistsRecyclerAdapter;
import com.example.yunmusicapp.entity.TopArtists;
import com.example.yunmusicapp.entity.tmp.SingerDetailTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.utils.HttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class TopArtistsActivity extends AppCompatActivity {
    private RecyclerView TopArtists_Recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artists);

        TopArtists_Recycler = findViewById(R.id.TopArtists_Recycler);
        TopArtists_Recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Call<TopArtists> call = HttpClient.pojoService.topArtists("30");
        call.enqueue(new Callback<TopArtists>() {
            @Override
            public void onResponse(Call<TopArtists> call, Response<TopArtists> response) {
                if(response.isSuccessful()){
                    TopArtistsRecyclerAdapter adapter = new TopArtistsRecyclerAdapter(getApplicationContext());
                    TopArtists_Recycler.setAdapter(adapter);
                    adapter.setData(response.body().getArtists());
                    adapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            Intent intent = new Intent(getApplicationContext(), SingerDetailActivity.class);
                            SingerDetailTmp tmp = new SingerDetailTmp();
                            tmp.setId(String.valueOf(response.body().getArtists().get(position).getId()));
                            tmp.setUrl(response.body().getArtists().get(position).getImg1v1Url());
                            tmp.setName(response.body().getArtists().get(position).getName());
                            intent.putExtra("SingerDetail", tmp);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<TopArtists> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}