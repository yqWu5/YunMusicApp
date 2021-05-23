package com.example.yunmusicapp.entity;

public class Level {

    private boolean full;
    private DataBean data;
    private int code;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {

        private long userId;
        private String info;
        private double progress;
        private int nextPlayCount;
        private int nextLoginCount;
        private int nowPlayCount;
        private int nowLoginCount;
        private int level;

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public double getProgress() {
            return progress;
        }

        public void setProgress(double progress) {
            this.progress = progress;
        }

        public int getNextPlayCount() {
            return nextPlayCount;
        }

        public void setNextPlayCount(int nextPlayCount) {
            this.nextPlayCount = nextPlayCount;
        }

        public int getNextLoginCount() {
            return nextLoginCount;
        }

        public void setNextLoginCount(int nextLoginCount) {
            this.nextLoginCount = nextLoginCount;
        }

        public int getNowPlayCount() {
            return nowPlayCount;
        }

        public void setNowPlayCount(int nowPlayCount) {
            this.nowPlayCount = nowPlayCount;
        }

        public int getNowLoginCount() {
            return nowLoginCount;
        }

        public void setNowLoginCount(int nowLoginCount) {
            this.nowLoginCount = nowLoginCount;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
