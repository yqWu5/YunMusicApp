package com.example.yunmusicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.tmp.Cookie;
import com.example.yunmusicapp.entity.Login;
import com.example.yunmusicapp.entity.tmp.InfoTmp;
import com.example.yunmusicapp.utils.BarTransparent;
import com.example.yunmusicapp.utils.HttpClient;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView Login_Button;
    private EditText Login_phone;
    private EditText Login_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //防止EditText打开的键盘把布局往上顶
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        BarTransparent.makeStatusBarTransparent(LoginActivity.this);
        BarTransparent.setAndroidNativeLightStatusBar(LoginActivity.this, true);

        //强制在主线程中执行http请求，而不是异步请求
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Login_Button = findViewById(R.id.Login_Button);
        Login_phone = findViewById(R.id.Login_phone);
        Login_password = findViewById(R.id.Login_password);

        //登陆
        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //登陆
                String phone = Login_phone.getText().toString();
                String password = Login_password.getText().toString();
                Call<Login> login = HttpClient.pojoService.Login(phone, password);
                try {
                    Response<Login> response = login.execute();
                    Cookie.setCookie(response.body().getCookie());
                    Cookie.setUserId(response.body().getAccount().getId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //缓存用户信息
                Call<UserDetail> userDetail = HttpClient.pojoService.userDetail(String.valueOf(Cookie.getUserId()), Cookie.getCookie());
                try {
                    Response<UserDetail> response = userDetail.execute();
                    InfoTmp.setUserDetail(response.body());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //缓存喜欢的音乐、创建歌单、收藏歌单
                Call<SingList> singList = HttpClient.pojoService.playList(String.valueOf(Cookie.getUserId()), Cookie.getCookie());
                try {
                    Response<SingList> response = singList.execute();
                    InfoTmp.setSingList(response.body());
                    List<SingList.PlaylistBean> createPlayList = new ArrayList<>();
                    List<SingList.PlaylistBean> keepPlayList = new ArrayList<>();
                    for(SingList.PlaylistBean p:response.body().getPlaylist()){
                        if(p.getUserId() == Cookie.getUserId()){
                            createPlayList.add(p);
                        }else{
                            keepPlayList.add(p);
                        }
                    }
                    InfoTmp.setCreatePlayList(createPlayList);
                    InfoTmp.setKeepPlayList(keepPlayList);
                    InfoTmp.setLikePlayList(response.body().getPlaylist().get(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}