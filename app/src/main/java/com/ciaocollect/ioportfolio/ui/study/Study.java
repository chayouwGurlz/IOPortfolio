package com.ciaocollect.ioportfolio.ui.study;

import android.os.Parcel;
import android.os.Parcelable;

public class Study implements Parcelable {
    private String title, description, year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.year);
    }

    public Study() { }

    protected Study(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.year = in.readString();
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
