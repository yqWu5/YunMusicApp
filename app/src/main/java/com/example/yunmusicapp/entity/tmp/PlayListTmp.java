package com.example.yunmusicapp.entity.tmp;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.yunmusicapp.entity.PlayListDetail;

public class PlayListTmp implements Parcelable {
    private long id;
    private String name;
    private String ImgUrl;
    private String creator_Name;
    private String creator_ImgUrl;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getCreator_Name() {
        return creator_Name;
    }

    public void setCreator_Name(String creator_Name) {
        this.creator_Name = creator_Name;
    }

    public String getCreator_ImgUrl() {
        return creator_ImgUrl;
    }

    public void setCreator_ImgUrl(String creator_ImgUrl) {
        this.creator_ImgUrl = creator_ImgUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.ImgUrl);
        dest.writeString(this.creator_Name);
        dest.writeString(this.creator_ImgUrl);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readLong();
        this.name = source.readString();
        this.ImgUrl = source.readString();
        this.creator_Name = source.readString();
        this.creator_ImgUrl = source.readString();
    }

    public PlayListTmp() {
    }

    protected PlayListTmp(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.ImgUrl = in.readString();
        this.creator_Name = in.readString();
        this.creator_ImgUrl = in.readString();
    }

    public static final Creator<PlayListTmp> CREATOR = new Creator<PlayListTmp>() {
        @Override
        public PlayListTmp createFromParcel(Parcel source) {
            return new PlayListTmp(source);
        }

        @Override
        public PlayListTmp[] newArray(int size) {
            return new PlayListTmp[size];
        }
    };
}
