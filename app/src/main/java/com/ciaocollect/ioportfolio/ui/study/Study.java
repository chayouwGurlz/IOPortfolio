package com.ciaocollect.ioportfolio.ui.study;

import android.os.Parcel;
import android.os.Parcelable;

public class Study implements Parcelable {
    private String title, description, year, link;

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getYear() {
        return year;
    }

    void setYear(String year) {
        this.year = year;
    }

    String getLink() { return link; }

    void setLink(String link) { this.link = link; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.year);
        dest.writeString(this.link);
    }

    Study() { }

    private Study(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.year = in.readString();
        this.link = in.readString();
    }

    public static final Parcelable.Creator<Study> CREATOR = new Parcelable.Creator<Study>() {
        @Override
        public Study createFromParcel(Parcel source) {
            return new Study(source);
        }

        @Override
        public Study[] newArray(int size) {
            return new Study[size];
        }
    };
}
