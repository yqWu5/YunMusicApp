package com.example.yunmusicapp.entity.tmp;

import androidx.palette.graphics.Palette;

import com.example.yunmusicapp.entity.RecommendVideos;
import com.example.yunmusicapp.entity.SingList;
import com.example.yunmusicapp.entity.UserDetail;
import com.example.yunmusicapp.entity.UserFolloweds;
import com.example.yunmusicapp.entity.UserFollows;

import java.util.HashMap;
import java.util.List;

public class InfoTmp {
    //每日推荐视频单个实体
    private static RecommendVideos.DatasBean.DataBean recommendVideosDataBean = null;
    //单个歌曲实体
    private static SongUrlTmp songUrlTmp = null;
    //点击用户的信息细节
    private static UserDetail clickUserDetail = null;
    //点击用户的ID
    private static String clickUserId = null;
    //创建的歌单
    private static List<SingList.PlaylistBean> createPlayList = null;
    //收藏的歌单
    private static List<SingList.PlaylistBean> keepPlayList = null;
    //喜欢的音乐
    private static SingList.PlaylistBean likePlayList = null;
    //用户细节
    private static UserDetail userDetail = null;
    //所有歌单
    private static SingList singList = null;
    //歌单类型
    private static Integer playListType = null;
    //关注列表
    private static List<UserFollows.FollowBean> userFollowsList = null;
    //粉丝列表
    private static List<UserFolloweds.FollowedsBean> userFollowedsList = null;
    //颜色列表
    private static HashMap<Long, Palette> colorMap = new HashMap<>();

    public static RecommendVideos.DatasBean.DataBean getRecommendVideosDataBean() {
        return recommendVideosDataBean;
    }

    public static void setRecommendVideosDataBean(RecommendVideos.DatasBean.DataBean recommendVideosDataBean) {
        InfoTmp.recommendVideosDataBean = recommendVideosDataBean;
    }

    public static SongUrlTmp getSongUrlTmp() {
        return songUrlTmp;
    }

    public static void setSongUrlTmp(SongUrlTmp songUrlTmp) {
        InfoTmp.songUrlTmp = songUrlTmp;
    }

    public static HashMap<Long, Palette> getColorMap() {
        return colorMap;
    }

    public static void setColorMap(HashMap<Long, Palette> colorMap) {
        InfoTmp.colorMap = colorMap;
    }

    public static List<UserFolloweds.FollowedsBean> getUserFollowedsList() {
        return userFollowedsList;
    }

    public static UserDetail getClickUserDetail() {
        return clickUserDetail;
    }

    public static void setClickUserDetail(UserDetail clickUserDetail) {
        InfoTmp.clickUserDetail = clickUserDetail;
    }

    public static String getClickUserId() {
        return clickUserId;
    }

    public static void setClickUserId(String clickUserId) {
        InfoTmp.clickUserId = clickUserId;
    }

    public static void setUserFollowedsList(List<UserFolloweds.FollowedsBean> userFollowedsList) {
        InfoTmp.userFollowedsList = userFollowedsList;
    }

    private static Integer getPlayListType() {
        return playListType;
    }

    public static List<UserFollows.FollowBean> getUserFollowsList() {
        return userFollowsList;
    }

    public static void setUserFollowsList(List<UserFollows.FollowBean> userFollowsList) {
        InfoTmp.userFollowsList = userFollowsList;
    }

    public static void setPlayListType(Integer playListType) {
        InfoTmp.playListType = playListType;
    }

    public static SingList.PlaylistBean getLikePlayList() {
        return likePlayList;
    }

    public static void setLikePlayList(SingList.PlaylistBean likePlayList) {
        InfoTmp.likePlayList = likePlayList;
    }

    public static List<SingList.PlaylistBean> getKeepPlayList() {
        return keepPlayList;
    }

    public static void setKeepPlayList(List<SingList.PlaylistBean> keepPlayList) {
        InfoTmp.keepPlayList = keepPlayList;
    }

    public static List<SingList.PlaylistBean> getCreatePlayList() {
        return createPlayList;
    }

    public static void setCreatePlayList(List<SingList.PlaylistBean> createPlayList) {
        InfoTmp.createPlayList = createPlayList;
    }

    public static UserDetail getUserDetail() {
        return userDetail;
    }

    public static void setUserDetail(UserDetail userDetail) {
        InfoTmp.userDetail = userDetail;
    }

    public static SingList getSingList() {
        return singList;
    }

    public static void setSingList(SingList singList) {
        InfoTmp.singList = singList;
    }
}
