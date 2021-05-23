package com.example.yunmusicapp.entity;

public class Privileges {
    private int id;
    private int fee;
    private int payed;
    private int realPayed;
    private int st;
    private int pl;
    private int dl;
    private int sp;
    private int cp;
    private int subp;
    private boolean cs;
    private int maxbr;
    private int fl;
    private PcBean pc;
    private boolean toast;
    private int flag;
    private boolean paidBigBang;
    private boolean preSell;
    private int playMaxbr;
    private int downloadMaxbr;
    private FreeTrialPrivilegeBean freeTrialPrivilege;
    private Object chargeInfoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }

    public int getRealPayed() {
        return realPayed;
    }

    public void setRealPayed(int realPayed) {
        this.realPayed = realPayed;
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getPl() {
        return pl;
    }

    public void setPl(int pl) {
        this.pl = pl;
    }

    public int getDl() {
        return dl;
    }

    public void setDl(int dl) {
        this.dl = dl;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSubp() {
        return subp;
    }

    public void setSubp(int subp) {
        this.subp = subp;
    }

    public boolean isCs() {
        return cs;
    }

    public void setCs(boolean cs) {
        this.cs = cs;
    }

    public int getMaxbr() {
        return maxbr;
    }

    public void setMaxbr(int maxbr) {
        this.maxbr = maxbr;
    }

    public int getFl() {
        return fl;
    }

    public void setFl(int fl) {
        this.fl = fl;
    }

    public PcBean getPc() {
        return pc;
    }

    public void setPc(PcBean pc) {
        this.pc = pc;
    }

    public boolean isToast() {
        return toast;
    }

    public void setToast(boolean toast) {
        this.toast = toast;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public boolean isPaidBigBang() {
        return paidBigBang;
    }

    public void setPaidBigBang(boolean paidBigBang) {
        this.paidBigBang = paidBigBang;
    }

    public boolean isPreSell() {
        return preSell;
    }

    public void setPreSell(boolean preSell) {
        this.preSell = preSell;
    }

    public int getPlayMaxbr() {
        return playMaxbr;
    }

    public void setPlayMaxbr(int playMaxbr) {
        this.playMaxbr = playMaxbr;
    }

    public int getDownloadMaxbr() {
        return downloadMaxbr;
    }

    public void setDownloadMaxbr(int downloadMaxbr) {
        this.downloadMaxbr = downloadMaxbr;
    }

    public FreeTrialPrivilegeBean getFreeTrialPrivilege() {
        return freeTrialPrivilege;
    }

    public void setFreeTrialPrivilege(FreeTrialPrivilegeBean freeTrialPrivilege) {
        this.freeTrialPrivilege = freeTrialPrivilege;
    }

    public Object getChargeInfoList() {
        return chargeInfoList;
    }

    public void setChargeInfoList(Object chargeInfoList) {
        this.chargeInfoList = chargeInfoList;
    }

    public static class PcBean {
        private long id;
        private long userId;
        private int songId;
        private String md5;
        private String song;
        private String artist;
        private String album;
        private int bitrate;
        private String fileName;
        private int songDfsId;
        private long cover;
        private long lyric;
        private int cue;
        private int convertLyric;
        private int version;
        private long addTime;
        private int fileSize;
        private int status;
        private int originalAudioSongId;
        private String lrcType;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public int getSongId() {
            return songId;
        }

        public void setSongId(int songId) {
            this.songId = songId;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public int getBitrate() {
            return bitrate;
        }

        public void setBitrate(int bitrate) {
            this.bitrate = bitrate;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public int getSongDfsId() {
            return songDfsId;
        }

        public void setSongDfsId(int songDfsId) {
            this.songDfsId = songDfsId;
        }

        public long getCover() {
            return cover;
        }

        public void setCover(long cover) {
            this.cover = cover;
        }

        public long getLyric() {
            return lyric;
        }

        public void setLyric(long lyric) {
            this.lyric = lyric;
        }

        public int getCue() {
            return cue;
        }

        public void setCue(int cue) {
            this.cue = cue;
        }

        public int getConvertLyric() {
            return convertLyric;
        }

        public void setConvertLyric(int convertLyric) {
            this.convertLyric = convertLyric;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public long getAddTime() {
            return addTime;
        }

        public void setAddTime(long addTime) {
            this.addTime = addTime;
        }

        public int getFileSize() {
            return fileSize;
        }

        public void setFileSize(int fileSize) {
            this.fileSize = fileSize;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getOriginalAudioSongId() {
            return originalAudioSongId;
        }

        public void setOriginalAudioSongId(int originalAudioSongId) {
            this.originalAudioSongId = originalAudioSongId;
        }

        public String getLrcType() {
            return lrcType;
        }

        public void setLrcType(String lrcType) {
            this.lrcType = lrcType;
        }
    }

    public static class FreeTrialPrivilegeBean {
        private boolean resConsumable;
        private boolean userConsumable;

        public boolean isResConsumable() {
            return resConsumable;
        }

        public void setResConsumable(boolean resConsumable) {
            this.resConsumable = resConsumable;
        }

        public boolean isUserConsumable() {
            return userConsumable;
        }

        public void setUserConsumable(boolean userConsumable) {
            this.userConsumable = userConsumable;
        }
    }
}
