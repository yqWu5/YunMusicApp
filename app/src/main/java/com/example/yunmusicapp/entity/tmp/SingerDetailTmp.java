package com.example.yunmusicapp.entity.tmp;

import android.os.Parcel;
import android.os.Parcelable;

public class SingerDetailTmp implements Parcelable {
    private String id;
    private String url;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.url);
        dest.writeString(this.name);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readString();
        this.url = source.readString();
        this.name = source.readString();
    }

    public SingerDetailTmp() {
    }

    protected SingerDetailTmp(Parcel in) {
        this.id = in.readString();
        this.url = in.readString();
        this.name = in.readString();
    }

    public static final Creator<SingerDetailTmp> CREATOR = new Creator<SingerDetailTmp>() {
        @Override
        public SingerDetailTmp createFromParcel(Parcel source) {
            return new SingerDetailTmp(source);
        }

        @Override
        public SingerDetailTmp[] newArray(int size) {
            return new SingerDetailTmp[size];
        }
    };
}
