package com.example.yunmusicapp.entity;

import java.util.List;

public class CommentMusic {
    private boolean isMusician;
    private int cnum;
    private long userId;
    private boolean moreHot;
    private Object commentBanner;
    private int code;
    private int total;
    private boolean more;
    private List<?> topComments;
    private List<HotCommentsBean> hotComments;
    private List<CommentsBean> comments;

    public boolean isIsMusician() {
        return isMusician;
    }

    public void setIsMusician(boolean isMusician) {
        this.isMusician = isMusician;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isMoreHot() {
        return moreHot;
    }

    public void setMoreHot(boolean moreHot) {
        this.moreHot = moreHot;
    }

    public Object getCommentBanner() {
        return commentBanner;
    }

    public void setCommentBanner(Object commentBanner) {
        this.commentBanner = commentBanner;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public List<?> getTopComments() {
        return topComments;
    }

    public void setTopComments(List<?> topComments) {
        this.topComments = topComments;
    }

    public List<HotCommentsBean> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<HotCommentsBean> hotComments) {
        this.hotComments = hotComments;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class HotCommentsBean {
        private UserBean user;
        private Object pendantData;
        private Object showFloorComment;
        private int status;
        private long commentId;
        private String content;
        private long time;
        private int likedCount;
        private Object expressionUrl;
        private int commentLocationType;
        private long parentCommentId;
        private Object decoration;
        private Object repliedMark;
        private boolean liked;
        private List<?> beReplied;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public Object getPendantData() {
            return pendantData;
        }

        public void setPendantData(Object pendantData) {
            this.pendantData = pendantData;
        }

        public Object getShowFloorComment() {
            return showFloorComment;
        }

        public void setShowFloorComment(Object showFloorComment) {
            this.showFloorComment = showFloorComment;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getCommentId() {
            return commentId;
        }

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public int getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(int commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public long getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(long parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public Object getDecoration() {
            return decoration;
        }

        public void setDecoration(Object decoration) {
            this.decoration = decoration;
        }

        public Object getRepliedMark() {
            return repliedMark;
        }

        public void setRepliedMark(Object repliedMark) {
            this.repliedMark = repliedMark;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public List<?> getBeReplied() {
            return beReplied;
        }

        public void setBeReplied(List<?> beReplied) {
            this.beReplied = beReplied;
        }

        public static class UserBean {
            private Object locationInfo;
            private Object liveInfo;
            private int anonym;
            private Object commonIdentity;
            private long userId;
            private int userType;
            private Object avatarDetail;
            private boolean followed;
            private boolean mutual;
            private Object remarkName;
            private Object vipRights;
            private String nickname;
            private String avatarUrl;
            private int authStatus;
            private Object expertTags;
            private Object experts;
            private int vipType;

            public Object getLocationInfo() {
                return locationInfo;
            }

            public void setLocationInfo(Object locationInfo) {
                this.locationInfo = locationInfo;
            }

            public Object getLiveInfo() {
                return liveInfo;
            }

            public void setLiveInfo(Object liveInfo) {
                this.liveInfo = liveInfo;
            }

            public int getAnonym() {
                return anonym;
            }

            public void setAnonym(int anonym) {
                this.anonym = anonym;
            }

            public Object getCommonIdentity() {
                return commonIdentity;
            }

            public void setCommonIdentity(Object commonIdentity) {
                this.commonIdentity = commonIdentity;
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

            public Object getAvatarDetail() {
                return avatarDetail;
            }

            public void setAvatarDetail(Object avatarDetail) {
                this.avatarDetail = avatarDetail;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public Object getVipRights() {
                return vipRights;
            }

            public void setVipRights(Object vipRights) {
                this.vipRights = vipRights;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }
        }
    }

    public static class CommentsBean {

        private UserBeanX user;
        private Object pendantData;
        private Object showFloorComment;
        private int status;
        private long commentId;
        private String content;
        private long time;
        private int likedCount;
        private Object expressionUrl;
        private int commentLocationType;
        private long parentCommentId;
        private DecorationBean decoration;
        private Object repliedMark;
        private boolean liked;
        private List<?> beReplied;

        public UserBeanX getUser() {
            return user;
        }

        public void setUser(UserBeanX user) {
            this.user = user;
        }

        public Object getPendantData() {
            return pendantData;
        }

        public void setPendantData(Object pendantData) {
            this.pendantData = pendantData;
        }

        public Object getShowFloorComment() {
            return showFloorComment;
        }

        public void setShowFloorComment(Object showFloorComment) {
            this.showFloorComment = showFloorComment;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getCommentId() {
            return commentId;
        }

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public Object getExpressionUrl() {
            return expressionUrl;
        }

        public void setExpressionUrl(Object expressionUrl) {
            this.expressionUrl = expressionUrl;
        }

        public int getCommentLocationType() {
            return commentLocationType;
        }

        public void setCommentLocationType(int commentLocationType) {
            this.commentLocationType = commentLocationType;
        }

        public long getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(long parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        public DecorationBean getDecoration() {
            return decoration;
        }

        public void setDecoration(DecorationBean decoration) {
            this.decoration = decoration;
        }

        public Object getRepliedMark() {
            return repliedMark;
        }

        public void setRepliedMark(Object repliedMark) {
            this.repliedMark = repliedMark;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public List<?> getBeReplied() {
            return beReplied;
        }

        public void setBeReplied(List<?> beReplied) {
            this.beReplied = beReplied;
        }

        public static class UserBeanX {
            public static class VipRightsBean {
                public static class AssociatorBean {
                }
            }
        }

        public static class DecorationBean {
        }
    }
}
