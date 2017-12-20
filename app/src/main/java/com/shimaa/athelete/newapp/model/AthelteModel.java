package com.shimaa.athelete.newapp.model;

import android.os.Parcel;
import android.os.Parcelable;


public class AthelteModel implements Parcelable {
    private String name;
    private String image;
    private String brief;

    protected AthelteModel(Parcel in) {
        name = in.readString();
        image = in.readString();
        brief = in.readString();
    }

    public static final Creator<AthelteModel> CREATOR = new Creator<AthelteModel>() {
        @Override
        public AthelteModel createFromParcel(Parcel in) {
            return new AthelteModel(in);
        }

        @Override
        public AthelteModel[] newArray(int size) {
            return new AthelteModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getBrief() {
        return brief;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(image);
        parcel.writeString(brief);
    }
}
