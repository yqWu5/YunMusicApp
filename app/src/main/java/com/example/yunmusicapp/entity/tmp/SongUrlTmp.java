package com.example.yunmusicapp.entity.tmp;

import android.os.Parcel;
import android.os.Parcelable;

public class SongUrlTmp implements Parcelable {
    private String name;
    private String id;
    private String ImgUrl;
    private String SingerName;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.id);
        dest.writeString(this.ImgUrl);
        dest.writeString(this.SingerName);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.id = source.readString();
        this.ImgUrl = source.readString();
        this.SingerName = source.readString();
    }

    public SongUrlTmp() {
    }

    protected SongUrlTmp(Parcel in) {
        this.name = in.readString();
        this.id = in.readString();
        this.ImgUrl = in.readString();
        this.SingerName = in.readString();
    }

    public static final Creator<SongUrlTmp> CREATOR = new Creator<SongUrlTmp>() {
        @Override
        public SongUrlTmp createFromParcel(Parcel source) {
            return new SongUrlTmp(source);
        }

        @Override
        public SongUrlTmp[] newArray(int size) {
            return new SongUrlTmp[size];
        }
    };
}
