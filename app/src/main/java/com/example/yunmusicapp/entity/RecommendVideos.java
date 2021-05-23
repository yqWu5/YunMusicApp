package com.example.yunmusicapp.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecommendVideos {
    private String msg;
    private boolean hasmore;
    private int code;
    private List<DatasBean> datas;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private int type;
        private boolean displayed;
        private String alg;
        private Object extAlg;
        private DataBean data;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean isDisplayed() {
            return displayed;
        }

        public void setDisplayed(boolean displayed) {
            this.displayed = displayed;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public Object getExtAlg() {
            return extAlg;
        }

        public void setExtAlg(Object extAlg) {
            this.extAlg = extAlg;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {

            private String alg;
            private String scm;
            private String threadId;
            private String coverUrl;
            private int height;
            private int width;
            private String title;
            private String description;
            private int commentCount;
            private int shareCount;
            private CreatorBean creator;
            private UrlInfoBean urlInfo;
            private Object videoGroup;
            private Object previewUrl;
            private int previewDurationms;
            private boolean hasRelatedGameAd;
            private Object markTypes;
            private Object relatedInfo;
            private Object videoUserLiveInfo;
            private String vid;
            private int durationms;
            private long playTime;
            private int praisedCount;
            private boolean praised;
            private boolean subscribed;
            private List<ResolutionsBean> resolutions;
            private List<?> relateSong;

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getThreadId() {
                return threadId;
            }

            public void setThreadId(String threadId) {
                this.threadId = threadId;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public CreatorBean getCreator() {
                return creator;
            }

            public void setCreator(CreatorBean creator) {
                this.creator = creator;
            }

            public UrlInfoBean getUrlInfo() {
                return urlInfo;
            }

            public void setUrlInfo(UrlInfoBean urlInfo) {
                this.urlInfo = urlInfo;
            }

            public Object getVideoGroup() {
                return videoGroup;
            }

            public void setVideoGroup(Object videoGroup) {
                this.videoGroup = videoGroup;
            }

            public Object getPreviewUrl() {
                return previewUrl;
            }

            public void setPreviewUrl(Object previewUrl) {
                this.previewUrl = previewUrl;
            }

            public int getPreviewDurationms() {
                return previewDurationms;
            }

            public void setPreviewDurationms(int previewDurationms) {
                this.previewDurationms = previewDurationms;
            }

            public boolean isHasRelatedGameAd() {
                return hasRelatedGameAd;
            }

            public void setHasRelatedGameAd(boolean hasRelatedGameAd) {
                this.hasRelatedGameAd = hasRelatedGameAd;
            }

            public Object getMarkTypes() {
                return markTypes;
            }

            public void setMarkTypes(Object markTypes) {
                this.markTypes = markTypes;
            }

            public Object getRelatedInfo() {
                return relatedInfo;
            }

            public void setRelatedInfo(Object relatedInfo) {
                this.relatedInfo = relatedInfo;
            }

            public Object getVideoUserLiveInfo() {
                return videoUserLiveInfo;
            }

            public void setVideoUserLiveInfo(Object videoUserLiveInfo) {
                this.videoUserLiveInfo = videoUserLiveInfo;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public int getDurationms() {
                return durationms;
            }

            public void setDurationms(int durationms) {
                this.durationms = durationms;
            }

            public long getPlayTime() {
                return playTime;
            }

            public void setPlayTime(long playTime) {
                this.playTime = playTime;
            }

            public int getPraisedCount() {
                return praisedCount;
            }

            public void setPraisedCount(int praisedCount) {
                this.praisedCount = praisedCount;
            }

            public boolean isPraised() {
                return praised;
            }

            public void setPraised(boolean praised) {
                this.praised = praised;
            }

            public boolean isSubscribed() {
                return subscribed;
            }

            public void setSubscribed(boolean subscribed) {
                this.subscribed = subscribed;
            }

            public List<ResolutionsBean> getResolutions() {
                return resolutions;
            }

            public void setResolutions(List<ResolutionsBean> resolutions) {
                this.resolutions = resolutions;
            }

            public List<?> getRelateSong() {
                return relateSong;
            }

            public void setRelateSong(List<?> relateSong) {
                this.relateSong = relateSong;
            }
            public static class CreatorBean {
                private boolean defaultAvatar;
                private int province;
                private int authStatus;
                private boolean followed;
                private String avatarUrl;
                private int accountStatus;
                private int gender;
                private int city;
                private long birthday;
                private long userId;
                private int userType;
                private String nickname;
                private String signature;
                private String description;
                private String detailDescription;
                private long avatarImgId;
                private long backgroundImgId;
                private String backgroundUrl;
                private int authority;
                private boolean mutual;
                private Object expertTags;
                private ExpertsBean experts;
                private int djStatus;
                private int vipType;
                private Object remarkName;
                private String backgroundImgIdStr;
                private String avatarImgIdStr;

                public boolean isDefaultAvatar() {
                    return defaultAvatar;
                }

                public void setDefaultAvatar(boolean defaultAvatar) {
                    this.defaultAvatar = defaultAvatar;
                }

                public int getProvince() {
                    return province;
                }

                public void setProvince(int province) {
                    this.province = province;
                }

                public int getAuthStatus() {
                    return authStatus;
                }

                public void setAuthStatus(int authStatus) {
                    this.authStatus = authStatus;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }

                public String getAvatarUrl() {
                    return avatarUrl;
                }

                public void setAvatarUrl(String avatarUrl) {
                    this.avatarUrl = avatarUrl;
                }

                public int getAccountStatus() {
                    return accountStatus;
                }

                public void setAccountStatus(int accountStatus) {
                    this.accountStatus = accountStatus;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public int getCity() {
                    return city;
                }

                public void setCity(int city) {
                    this.city = city;
                }

                public long getBirthday() {
                    return birthday;
                }

                public void setBirthday(long birthday) {
                    this.birthday = birthday;
                }

                public long getUserId() {
                    return userId;
                }

                public void setUserId(long userId) {
                    this.userId = userId;
                }

                public int getUserType() {
                    return userType;
                }

                public void setUserType(int userType) {
                    this.userType = userType;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getDetailDescription() {
                    return detailDescription;
                }

                public void setDetailDescription(String detailDescription) {
                    this.detailDescription = detailDescription;
                }

                public long getAvatarImgId() {
                    return avatarImgId;
                }

                public void setAvatarImgId(long avatarImgId) {
                    this.avatarImgId = avatarImgId;
                }

                public long getBackgroundImgId() {
                    return backgroundImgId;
                }

                public void setBackgroundImgId(long backgroundImgId) {
                    this.backgroundImgId = backgroundImgId;
                }

                public String getBackgroundUrl() {
                    return backgroundUrl;
                }

                public void setBackgroundUrl(String backgroundUrl) {
                    this.backgroundUrl = backgroundUrl;
                }

                public int getAuthority() {
                    return authority;
                }

                public void setAuthority(int authority) {
                    this.authority = authority;
                }

                public boolean isMutual() {
                    return mutual;
                }

                public void setMutual(boolean mutual) {
                    this.mutual = mutual;
                }

                public Object getExpertTags() {
                    return expertTags;
                }

                public void setExpertTags(Object expertTags) {
                    this.expertTags = expertTags;
                }

                public ExpertsBean getExperts() {
                    return experts;
                }

                public void setExperts(ExpertsBean experts) {
                    this.experts = experts;
                }

                public int getDjStatus() {
                    return djStatus;
                }

                public void setDjStatus(int djStatus) {
                    this.djStatus = djStatus;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }

                public Object getRemarkName() {
                    return remarkName;
                }

                public void setRemarkName(Object remarkName) {
                    this.remarkName = remarkName;
                }

                public String getBackgroundImgIdStr() {
                    return backgroundImgIdStr;
                }

                public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                    this.backgroundImgIdStr = backgroundImgIdStr;
                }

                public String getAvatarImgIdStr() {
                    return avatarImgIdStr;
                }

                public void setAvatarImgIdStr(String avatarImgIdStr) {
                    this.avatarImgIdStr = avatarImgIdStr;
                }

                public static class ExpertsBean {
                    /**
                     * 1 : 音乐视频达人
                     */

                    @SerializedName("1")
                    private String _$1;

                    public String get_$1() {
                        return _$1;
                    }

                    public void set_$1(String _$1) {
                        this._$1 = _$1;
                    }
                }
            }

            public static class UrlInfoBean {
                private String id;
                private String url;
                private int size;
                private int validityTime;
                private boolean needPay;
                private Object payInfo;
                private int r;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getValidityTime() {
                    return validityTime;
                }

                public void setValidityTime(int validityTime) {
                    this.validityTime = validityTime;
                }

                public boolean isNeedPay() {
                    return needPay;
                }

                public void setNeedPay(boolean needPay) {
                    this.needPay = needPay;
                }

                public Object getPayInfo() {
                    return payInfo;
                }

                public void setPayInfo(Object payInfo) {
                    this.payInfo = payInfo;
                }

                public int getR() {
                    return r;
                }

                public void setR(int r) {
                    this.r = r;
                }
            }

            public static class ResolutionsBean {
                private int resolution;
                private int size;

                public int getResolution() {
                    return resolution;
                }

                public void setResolution(int resolution) {
                    this.resolution = resolution;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }
            }
        }
    }
}
