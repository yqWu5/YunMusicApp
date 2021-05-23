package com.example.yunmusicapp.fragment.playList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.PlayMusicActivity;
import com.example.yunmusicapp.R;
import com.example.yunmusicapp.adapter.playList.PlayListDetailRecycleListRecycleAdapter;
import com.example.yunmusicapp.entity.PlayListDetail;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.PlayListTmp;
import com.example.yunmusicapp.entity.tmp.SongUrlTmp;
import com.example.yunmusicapp.interf.BaseOnclickListener;
import com.example.yunmusicapp.mineView.MeasureLinearLayoutManager;
import com.example.yunmusicapp.utils.HttpClient;
import com.example.yunmusicapp.utils.SetColor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayListFragment extends Fragment {
    private PlayListTmp tmp;
    private View view;

    public void setTmp(PlayListTmp tmp){
        this.tmp = tmp;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.playlistdetail_recycle, container, false);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        TextView playListDetail_Recycle_Name;
        TextView playListDetail_Recycle_UserName;
        ImageView playListDetail_Recycle_UserImg;
        ImageView playListDetail_Recycle_Img;
        RecyclerView playListDetail_Recycle_Recycle;
        ConstraintLayout PlayListDetail_Info;

        PlayListDetail_Info = view.findViewById(R.id.PlayListDetail_Info);
        playListDetail_Recycle_Name = view.findViewById(R.id.playListDetail_Recycle_Name);
        playListDetail_Recycle_UserName = view.findViewById(R.id.playListDetail_Recycle_UserName);
        playListDetail_Recycle_UserImg = view.findViewById(R.id.playListDetail_Recycle_UserImg);
        playListDetail_Recycle_Img = view.findViewById(R.id.playListDetail_Recycle_Img);
        playListDetail_Recycle_Recycle = view.findViewById(R.id.playListDetail_Recycle_Recycle);

        SetColor.asBitmap(tmp.getImgUrl(), getContext(), PlayListDetail_Info);

        playListDetail_Recycle_Name.setText(tmp.getName());
        playListDetail_Recycle_UserName.setText(tmp.getCreator_Name());
        Glide.with(getContext()).load(tmp.getImgUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(playListDetail_Recycle_Img);
        Glide.with(getContext()).load(tmp.getCreator_ImgUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(playListDetail_Recycle_UserImg);
        //Recycle适配
        Call<PlayListDetail> call = HttpClient.pojoService.playListDetail(String.valueOf(tmp.getId()), Cookie.getCookie());
        call.enqueue(new Callback<PlayListDetail>() {
            @Override
            public void onResponse(Call<PlayListDetail> call, Response<PlayListDetail> response) {
                if(response.isSuccessful()){
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    playListDetail_Recycle_Recycle.setLayoutManager(layoutManager);
                    PlayListDetailRecycleListRecycleAdapter adapter = new PlayListDetailRecycleListRecycleAdapter(getContext(), getParentFragmentManager());
                    playListDetail_Recycle_Recycle.setAdapter(adapter);
                    adapter.setData(response.body());
                    //转跳到去听歌
                    adapter.setBaseOnClickListener(new BaseOnclickListener() {
                        @Override
                        public void click(int position) {
                            Log.e("SingId", String.valueOf(response.body().getPlaylist().getTracks().get(position).getId()));
                            Intent intent = new Intent(getContext(), PlayMusicActivity.class);
                            SongUrlTmp tmp = new SongUrlTmp();
                            tmp.setId(String.valueOf(response.body().getPlaylist().getTracks().get(position).getId()));
                            tmp.setName(response.body().getPlaylist().getTracks().get(position).getName());
                            tmp.setSingerName(String.valueOf(response.body().getPlaylist().getTracks().get(position).getAr().get(0).getName()));
                            tmp.setImgUrl(response.body().getPlaylist().getTracks().get(position).getAl().getPicUrl());
                            intent.putExtra("SongUrl", tmp);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<PlayListDetail> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
