 package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.entity.Lyric;
import com.example.yunmusicapp.entity.SongUrl;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.entity.tmp.SongUrlTmp;
import com.example.yunmusicapp.utils.HttpClient;
import com.example.yunmusicapp.utils.SetColor;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import me.zhengken.lyricview.LyricView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayMusicActivity extends AppCompatActivity {
    private TextView PlayMusic_showImg;
    //歌词控件
    private LyricView PlayMusic_lrcView;
    //
    private ConstraintLayout PlayMusic_Background;
    //返回按钮
    private ImageView PlayMusic_Down;
    //标题
    private TextView PlayMusic_Title;
    //分享按钮
    private ImageView PlayMusic_Share;
    //旋转图片
    private ImageView PlayMusic_Img;
    //评论
    private ImageView PlayMusic_Chat;
    //设置
    private ImageView PlayMusic_Setting;
    //进度条
    private SeekBar PlayMusic_SeekBar;
    //开始时间
    private TextView PlayMusic_StartTime;
    //结束时间
    private TextView PlayMusic_EndTime;
    //播放状态
    private ImageView PlayMusic_State;
    //播放菜单
    private ImageView PlayMusic_PlayList;
    //播放状态
    public static final int STATE_PLAYING =1;//正在播放
    public static final int STATE_PAUSE =2;//暂停
    public static final int STATE_STOP =3;//停止
    public int state = STATE_STOP;
    //播放器
    private MediaPlayer mediaPlayer;
    private ObjectAnimator objectAnimator;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        BarTransparent.makeStatusBarTransparent(PlayMusicActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(PlayMusicActivity.this, true);

        Intent intent = getIntent();
        //歌曲实体类
        SongUrlTmp tmp = intent.getParcelableExtra("SongUrl");
        //初始化view
        initView();

        PlayMusic_lrcView.setVisibility(View.INVISIBLE);
        PlayMusic_showImg.setVisibility(View.INVISIBLE);

        //播放器初始化、加载歌词
        if(tmp != null){
            PlayMusic_Title.setText(tmp.getName());
            SetColor.asBitmap(tmp.getImgUrl(), this, PlayMusic_Background);
            Glide.with(getApplicationContext()).load(tmp.getImgUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(PlayMusic_Img);
            //初始化播放器
            Call<SongUrl> songUrlCall = HttpClient.pojoService.songUrl(tmp.getId(), "320000", Cookie.getCookie());
            songUrlCall.enqueue(new Callback<SongUrl>() {
                @Override
                public void onResponse(Call<SongUrl> call, Response<SongUrl> response) {
                    if(response.isSuccessful()){
                        initMediaPlayer(response.body().getData().get(0).getUrl());
                    }
                }

                @Override
                public void onFailure(Call<SongUrl> call, Throwable t) {
                    t.printStackTrace();
                }
            });
            //初始化歌词
            Call<Lyric> lyricCall = HttpClient.pojoService.lyric(tmp.getId());
            lyricCall.enqueue(new Callback<Lyric>() {
                @Override
                public void onResponse(Call<Lyric> call, Response<Lyric> response) {
                    if(response.isSuccessful()){
                        String filePath = getApplicationContext().getFilesDir().getPath().toString() + "/song.lrc";
                        //IO流写入歌词
                        try {
                            File file = new File(filePath);
                            if(!file.exists()){
                                file.createNewFile();
                            }
                            file.delete();
                            file.createNewFile();
                            FileWriter fw = new FileWriter(file.getAbsoluteFile());
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(response.body().getLrc().getLyric());
                            bw.close();
                            fw.close();
                            //存歌词
                            PlayMusic_lrcView.setLyricFile(file);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                @Override
                public void onFailure(Call<Lyric> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }

        //音乐评论转跳
        PlayMusic_Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MusicCommentActivity.class);
                if(tmp != null){
                    InfoTmp.setSongUrlTmp(tmp);
                }
                startActivity(intent);
            }
        });

    }

    private void initView(){
        PlayMusic_showImg = findViewById(R.id.PlayMusic_showImg);
        PlayMusic_lrcView = findViewById(R.id.PlayMusic_lrcView);
        PlayMusic_Background = findViewById(R.id.PlayMusic_Background);
        PlayMusic_Down = findViewById(R.id.PlayMusic_Down);
        PlayMusic_Title = findViewById(R.id.PlayMusic_Title);
        PlayMusic_Share = findViewById(R.id.PlayMusic_Share);
        PlayMusic_Img = findViewById(R.id.PlayMusic_Img);
        PlayMusic_Chat = findViewById(R.id.PlayMusic_Chat);
        PlayMusic_Setting = findViewById(R.id.PlayMusic_Setting);
        PlayMusic_SeekBar = findViewById(R.id.PlayMusic_SeekBar);
        PlayMusic_StartTime = findViewById(R.id.PlayMusic_StartTime);
        PlayMusic_EndTime = findViewById(R.id.PlayMusic_EndTime);
        PlayMusic_State = findViewById(R.id.PlayMusic_State);
        PlayMusic_PlayList = findViewById(R.id.PlayMusic_PlayList);
        PlayMusic_State.setOnClickListener(this::onClick);

        mediaPlayer = new MediaPlayer();
        PlayMusic_SeekBar.setOnSeekBarChangeListener(new MySeekBar());

        //图片旋转
        objectAnimator = ObjectAnimator.ofFloat(PlayMusic_Img, "rotation", 0f, 360f);
        objectAnimator.setDuration(35000);//设定转一圈的时间
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);//设定无限循环
        objectAnimator.setRepeatMode(ObjectAnimator.RESTART);

        //监听图片点击，如果点了就显示歌词隐藏图片
        PlayMusic_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayMusic_Img.setVisibility(View.INVISIBLE);
                PlayMusic_lrcView.setVisibility(View.VISIBLE);
                PlayMusic_showImg.setVisibility(View.VISIBLE);
                PlayMusic_lrcView.bringToFront();

            }
        });
        //监听歌词点击，如果点了就显示图片隐藏歌词
        PlayMusic_showImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayMusic_Img.setVisibility(View.VISIBLE);
                PlayMusic_lrcView.setVisibility(View.INVISIBLE);
                PlayMusic_showImg.setVisibility(View.INVISIBLE);
            }
        });
        //歌词转跳
        PlayMusic_lrcView.setOnPlayerClickListener(new LyricView.OnPlayerClickListener() {
            @Override
            public void onPlayerClicked(long progress, String content) {
                mediaPlayer.seekTo((int) progress);
            }
        });
    }

    //初始化播放器
    private void initMediaPlayer(String mp3url) {
        try {
            if(mp3url==null){
                mp3url = "http://m8.music.126.net/20210507211457/783c4c69a62064ffdc56cc17e2ca149b/ymusic/0fd6/4f65/43ed/a8772889f38dfcb91c04da915b301617.mp3";
            }
            mediaPlayer.setDataSource(mp3url);
            mediaPlayer.prepare();
            PlayMusic_SeekBar.setMax(mediaPlayer.getDuration());
            int s = mediaPlayer.getDuration() / 1000;
            String total = s / 60 + ":" + s % 60;
            PlayMusic_EndTime.setText(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        objectAnimator.end();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        if(timer!=null)
            timer.cancel();
    }

    public void onClick(View v) {
        if(state == STATE_STOP){
            objectAnimator.start();//动画开始
            state = STATE_PLAYING;
        }
        else if(state == STATE_PAUSE){
            objectAnimator.resume();//动画重新开始
            state = STATE_PLAYING;
        }
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            PlayMusic_State.setImageResource(R.mipmap.playmusic_stop);
            //定时器每秒钟更改进度条
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    PlayMusic_SeekBar.setProgress(mediaPlayer.getCurrentPosition());

                }
            },0,1000);
        }
        else{
            mediaPlayer.pause();
            PlayMusic_State.setImageResource(R.mipmap.playmusic_play);
            timer.cancel();
            if(state == STATE_PLAYING){
                objectAnimator.pause();//动画暂停
                state = STATE_PAUSE;
            }
        }
    }

    public class MySeekBar implements SeekBar.OnSeekBarChangeListener {

        //进度条改变时
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int s = mediaPlayer.getCurrentPosition() / 1000;
            String total = s / 60 + ":" + s % 60;
            PlayMusic_StartTime.setText(total);
            //歌词跟随进度
            PlayMusic_lrcView.setCurrentTimeMillis(mediaPlayer.getCurrentPosition());
            //处理音乐播放结束时
            if(progress>=seekBar.getMax() && mediaPlayer.isPlaying()){
                timer.cancel();
                objectAnimator.pause();//动画暂停
                state = STATE_PAUSE;
                PlayMusic_State.setImageResource(R.mipmap.playmusic_stop);
                seekBar.setProgress(0);
                PlayMusic_StartTime.setText("0:0");
            }
        }

        //接触进度条时
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        /*滑动结束后，重新设置值*/
        public void onStopTrackingTouch(SeekBar seekBar) {
            mediaPlayer.seekTo(seekBar.getProgress());
            int s = mediaPlayer.getCurrentPosition() / 1000;
            String total = s / 60 + ":" + s % 60;
            PlayMusic_StartTime.setText(total);
        }
    }

}