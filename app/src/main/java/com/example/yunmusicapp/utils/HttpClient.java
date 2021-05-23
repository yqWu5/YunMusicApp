package com.example.yunmusicapp.utils;

import com.example.yunmusicapp.factory.NullOnEmptyConverterFactory;
import com.example.yunmusicapp.http.HttpService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    public static final String url = "https://autumnfish.cn/";
    //获得实体类的http请求
    public static Retrofit pojoRetrofit = new Retrofit.Builder()
            .baseUrl(url).addConverterFactory(new NullOnEmptyConverterFactory()).addConverterFactory(GsonConverterFactory.create()).build();
    public static HttpService pojoService = pojoRetrofit.create(HttpService.class);

    //获得json数据的http请求
    public static Retrofit jsonRetrofit = new Retrofit.Builder()
            .baseUrl(url).addConverterFactory(new NullOnEmptyConverterFactory()).build();
    public static HttpService jsonService = jsonRetrofit.create(HttpService.class);
}
