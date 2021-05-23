package com.example.yunmusicapp.adapter.discovery;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yunmusicapp.entity.DataBean;
import com.example.yunmusicapp.entity.MusicBanner;
import com.example.yunmusicapp.utils.HttpClient;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImgBannerAdapter extends BannerAdapter<DataBean, ImgBannerAdapter.ImgBannerAdapterHolder> {

    public ImgBannerAdapter(List<DataBean> datas) {
        super(datas);
    }

    @Override
    public ImgBannerAdapterHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImgBannerAdapterHolder(imageView);
    }

    @Override
    public void onBindView(ImgBannerAdapterHolder holder, DataBean data, int position, int size) {
        Call<MusicBanner> call = HttpClient.pojoService.musicBanner("0");
        call.enqueue(new Callback<MusicBanner>() {
            @Override
            public void onResponse(Call<MusicBanner> call, Response<MusicBanner> response) {
                if(response.isSuccessful()){
                    Glide.with(holder.imageView.getContext()).load(response.body().getBanners().get(position).getImageUrl()).into(holder.imageView);
                }
            }

            @Override
            public void onFailure(Call<MusicBanner> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    class ImgBannerAdapterHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ImgBannerAdapterHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.imageView = itemView;
        }
    }
}
