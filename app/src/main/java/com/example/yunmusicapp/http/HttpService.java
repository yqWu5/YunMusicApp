package com.example.yunmusicapp.http;

import com.example.yunmusicapp.entity.CommentMusic;
import com.example.yunmusicapp.entity.DiscoveryCalendar;
import com.example.yunmusicapp.entity.Level;
import com.example.yunmusicapp.entity.Login;
import com.example.yunmusicapp.entity.Lyric;
import com.example.yunmusicapp.entity.MsgPrivate;
import com.example.yunmusicapp.entity.MusicBanner;
import com.example.yunmusicapp.entity.MvAll;
import com.example.yunmusicapp.entity.PlayListDetail;
import com.example.yunmusicapp.entity.RecommendPlayList;
import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.entity.SearchHot;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.SongUrl;
import com.example.yunmusicapp.entity.TopArtists;
import com.example.yunmusicapp.entity.UserAccount;
import com.example.yunmusicapp.entity.UserCloud;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.UserFolloweds;
import com.example.yunmusicapp.entity.UserFollows;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpService {
    //登陆接口
    @POST("login/cellphone")
    Call<Login> Login(@Query("phone") String phone, @Query("password") String password);
    //用户账号信息
    @POST("user/account")
    Call<UserAccount> userAccount(@Query("cookie") String cookie);
    //用户信息
    @POST("user/detail")
    Call<UserDetail> userDetail(@Query("uid") String uid, @Query("cookie") String cookie);
    //用户歌单
    @POST("user/playlist")
    Call<SingList> playList(@Query("uid") String uid, @Query("cookie") String cookie);
    //登陆状态
    @POST("login/status")
    Call<ResponseBody> isLogin(@Query("cookie") String cookie);
    //用户等级
    @GET("user/level")
    Call<Level> getLevel(@Query("cookie") String cookie);
    //用户关注列表
    @GET("user/follows")
    Call<UserFollows> userFollows(@Query("uid") String uid);
    //用户粉丝列表
    @GET("user/followeds")
    Call<UserFolloweds> userFolloweds(@Query("uid") String uid);
    //歌单具体内容
    @POST("playlist/detail")
    Call<PlayListDetail> playListDetail(@Query("id") String id, @Query("cookie") String cookie);
    //歌单具体内容
    @GET("playlist/detail")
    Call<ResponseBody> playListDetailBody(@Query("id") String id);
    //轮播图片
    @GET("banner")
    Call<MusicBanner> musicBanner(@Query("type") String type);
    //每日推荐歌单
    @POST("recommend/resource")
    Call<RecommendPlayList> recommendPlayList(@Query("cookie") String cookie);
    //每日推荐视频
    @POST("video/timeline/recommend")
    Call<RecommendVideos> recommendVideos(@Query("offset") String offset, @Query("cookie") String cookie);
    //音乐日历
    @POST("calendar")
    Call<DiscoveryCalendar> discoveryCalendar(@Query("cookie") String cookie);
    //通知-私信
    @POST("msg/private")
    Call<MsgPrivate> msgPrivate(@Query("cookie") String cookie);
    //个人云盘
    @POST("user/cloud")
    Call<UserCloud> userCloud(@Query("cookie") String cookie);
    //歌曲url
    @POST("song/url")
    Call<SongUrl> songUrl(@Query("id") String id, @Query("br") String br, @Query("cookie") String cookie);
    //歌词
    @GET("lyric")
    Call<Lyric> lyric(@Query("id") String id);
    //热搜榜
    @GET("search/hot/detail")
    Call<SearchHot> searchHot();
    //热门歌手
    @GET("top/artists")
    Call<TopArtists> topArtists(@Query("limit") String limit);
    //歌曲评论
    @GET("comment/music")
    Call<CommentMusic> commentMusic(@Query("id") String id);
    //MV
    @POST("mv/all")
    Call<MvAll> mvAll(@Query("limit") String limit, @Query("offset") String offset, @Query("cookie") String cookie);

}
