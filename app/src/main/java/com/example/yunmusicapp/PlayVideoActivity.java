package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.utils.SetColor;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class PlayVideoActivity extends AppCompatActivity {
    private ImageView PlayVideo_Img;
    private ImageView PlayVideo_Like;
    private ImageView PlayVideo_Chat;
    private ImageView PlayVideo_Share;
    private ImageView PlayVideo_Keep;
    private TextView PlayVideo_Name;
    private TextView PlayVideo_Title;
    private TextView PlayVideo_LikeTotal;
    private TextView PlayVideo_ChatTotal;
    private TextView PlayVideo_ShareTotal;
    private JzvdStd PlayVideo_Media;
    private ConstraintLayout PlayVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        PlayVideo_Img = findViewById(R.id.PlayVideo_Img);
        PlayVideo_Name = findViewById(R.id.PlayVideo_Name);
        PlayVideo_Title = findViewById(R.id.PlayVideo_Title);
        PlayVideo_LikeTotal = findViewById(R.id.PlayVideo_LikeTotal);
        PlayVideo_ChatTotal = findViewById(R.id.PlayVideo_ChatTotal);
        PlayVideo_ShareTotal = findViewById(R.id.PlayVideo_ShareTotal);
        PlayVideo = findViewById(R.id.PlayVideo);
        PlayVideo_Media = findViewById(R.id.PlayVideo_Media);

        //沉浸式菜单栏
        BarTransparent.makeStatusBarTransparent(PlayVideoActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(PlayVideoActivity.this, true);

        //绑定数据-视频、信息、点赞数等等初始化
        RecommendVideos.DatasBean.DataBean dataBean = InfoTmp.getRecommendVideosDataBean();
        if(dataBean != null){
            //视频初始化
            PlayVideo_Media.setUp(dataBean.getUrlInfo().getUrl(), dataBean.getTitle());
            Glide.with(getApplicationContext()).load(dataBean.getCoverUrl()).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).into(PlayVideo_Media.posterImageView);

            Glide.with(getApplicationContext()).load(dataBean.getCreator().getAvatarUrl()).
                    diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(PlayVideo_Img);
            PlayVideo_Name.setText(dataBean.getCreator().getNickname());
            PlayVideo_Title.setText(dataBean.getTitle());
            PlayVideo_ChatTotal.setText(dataBean.getCommentCount() + "");
            PlayVideo_ShareTotal.setText(dataBean.getShareCount() + "");
            PlayVideo_LikeTotal.setText(dataBean.getPraisedCount() + "");

        }
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}