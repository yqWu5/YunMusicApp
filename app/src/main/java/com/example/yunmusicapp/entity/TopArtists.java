package com.example.yunmusicapp.entity;

import java.util.List;

//热门歌手
public class TopArtists {

    private int code;
    private boolean more;
    private List<ArtistsBean> artists;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public List<ArtistsBean> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsBean> artists) {
        this.artists = artists;
    }

    public static class ArtistsBean {

        private String name;
        private int id;
        private long picId;
        private long img1v1Id;
        private String briefDesc;
        private String picUrl;
        private String img1v1Url;
        private int albumSize;
        private String trans;
        private int musicSize;
        private int topicPerson;
        private Object showPrivateMsg;
        private Object isSubed;
        private Object accountId;
        private String picId_str;
        private String img1v1Id_str;
        private Object transNames;
        private boolean followed;
        private Object mvSize;
        private Object publishTime;
        private Object identifyTag;
        private List<String> alias;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public long getImg1v1Id() {
            return img1v1Id;
        }

        public void setImg1v1Id(long img1v1Id) {
            this.img1v1Id = img1v1Id;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getImg1v1Url() {
            return img1v1Url;
        }

        public void setImg1v1Url(String img1v1Url) {
            this.img1v1Url = img1v1Url;
        }

        public int getAlbumSize() {
            return albumSize;
        }

        public void setAlbumSize(int albumSize) {
            this.albumSize = albumSize;
        }

        public String getTrans() {
            return trans;
        }

        public void setTrans(String trans) {
            this.trans = trans;
        }

        public int getMusicSize() {
            return musicSize;
        }

        public void setMusicSize(int musicSize) {
            this.musicSize = musicSize;
        }

        public int getTopicPerson() {
            return topicPerson;
        }

        public void setTopicPerson(int topicPerson) {
            this.topicPerson = topicPerson;
        }

        public Object getShowPrivateMsg() {
            return showPrivateMsg;
        }

        public void setShowPrivateMsg(Object showPrivateMsg) {
            this.showPrivateMsg = showPrivateMsg;
        }

        public Object getIsSubed() {
            return isSubed;
        }

        public void setIsSubed(Object isSubed) {
            this.isSubed = isSubed;
        }

        public Object getAccountId() {
            return accountId;
        }

        public void setAccountId(Object accountId) {
            this.accountId = accountId;
        }

        public String getPicId_str() {
            return picId_str;
        }

        public void setPicId_str(String picId_str) {
            this.picId_str = picId_str;
        }

        public String getImg1v1Id_str() {
            return img1v1Id_str;
        }

        public void setImg1v1Id_str(String img1v1Id_str) {
            this.img1v1Id_str = img1v1Id_str;
        }

        public Object getTransNames() {
            return transNames;
        }

        public void setTransNames(Object transNames) {
            this.transNames = transNames;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public Object getMvSize() {
            return mvSize;
        }

        public void setMvSize(Object mvSize) {
            this.mvSize = mvSize;
        }

        public Object getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(Object publishTime) {
            this.publishTime = publishTime;
        }

        public Object getIdentifyTag() {
            return identifyTag;
        }

        public void setIdentifyTag(Object identifyTag) {
            this.identifyTag = identifyTag;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }
    }
}
