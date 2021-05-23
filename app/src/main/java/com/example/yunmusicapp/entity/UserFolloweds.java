package com.example.yunmusicapp.entity;

import java.util.List;

public class UserFolloweds {
    private int code;
    private boolean more;
    private List<FollowedsBean> followeds;

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

    public List<FollowedsBean> getFolloweds() {
        return followeds;
    }

    public void setFolloweds(List<FollowedsBean> followeds) {
        this.followeds = followeds;
    }

    public static class FollowedsBean {
        private String py;
        private long time;
        private long userId;
        private boolean followed;
        private Object avatarDetail;
        private int userType;
        private boolean mutual;
        private int followeds;
        private String nickname;
        private int follows;
        private Object remarkName;
        private String avatarUrl;
        private int accountStatus;
        private int authStatus;
        private int gender;
        private Object expertTags;
        private Object experts;
        private int vipType;
        private String signature;
        private VipRightsBean vipRights;
        private int eventCount;
        private int playlistCount;

        public String getPy() {
            return py;
        }

        public void setPy(String py) {
            this.py = py;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public Object getAvatarDetail() {
            return avatarDetail;
        }

        public void setAvatarDetail(Object avatarDetail) {
            this.avatarDetail = avatarDetail;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public boolean isMutual() {
            return mutual;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public int getFolloweds() {
            return followeds;
        }

        public void setFolloweds(int followeds) {
            this.followeds = followeds;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getFollows() {
            return follows;
        }

        public void setFollows(int follows) {
            this.follows = follows;
        }

        public Object getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(Object remarkName) {
            this.remarkName = remarkName;
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

        public int getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(int authStatus) {
            this.authStatus = authStatus;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
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

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public VipRightsBean getVipRights() {
            return vipRights;
        }

        public void setVipRights(VipRightsBean vipRights) {
            this.vipRights = vipRights;
        }

        public int getEventCount() {
            return eventCount;
        }

        public void setEventCount(int eventCount) {
            this.eventCount = eventCount;
        }

        public int getPlaylistCount() {
            return playlistCount;
        }

        public void setPlaylistCount(int playlistCount) {
            this.playlistCount = playlistCount;
        }

        public static class VipRightsBean {
            /**
             * associator : null
             * musicPackage : {"vipCode":220,"rights":true}
             * redVipAnnualCount : -1
             * redVipLevel : 1
             */

            private Object associator;
            private MusicPackageBean musicPackage;
            private int redVipAnnualCount;
            private int redVipLevel;

            public Object getAssociator() {
                return associator;
            }

            public void setAssociator(Object associator) {
                this.associator = associator;
            }

            public MusicPackageBean getMusicPackage() {
                return musicPackage;
            }

            public void setMusicPackage(MusicPackageBean musicPackage) {
                this.musicPackage = musicPackage;
            }

            public int getRedVipAnnualCount() {
                return redVipAnnualCount;
            }

            public void setRedVipAnnualCount(int redVipAnnualCount) {
                this.redVipAnnualCount = redVipAnnualCount;
            }

            public int getRedVipLevel() {
                return redVipLevel;
            }

            public void setRedVipLevel(int redVipLevel) {
                this.redVipLevel = redVipLevel;
            }

            public static class MusicPackageBean {
                /**
                 * vipCode : 220
                 * rights : true
                 */

                private int vipCode;
                private boolean rights;

                public int getVipCode() {
                    return vipCode;
                }

                public void setVipCode(int vipCode) {
                    this.vipCode = vipCode;
                }

                public boolean isRights() {
                    return rights;
                }

                public void setRights(boolean rights) {
                    this.rights = rights;
                }
            }
        }
    }
}
