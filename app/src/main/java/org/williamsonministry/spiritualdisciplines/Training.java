package org.williamsonministry.spiritualdisciplines;

import android.os.Parcel;
import android.os.Parcelable;

public class Training implements Parcelable {
    private int id;
    private String name;
    private String longDesc;
    private String shortDesc;
    private String imageURL;

    public Training(int id, String name, String shortDesc, String longDesc, String imageURL) {
        this.id = id;
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.imageURL = imageURL;
    }

    protected Training(Parcel in) {
        id = in.readInt();
        name = in.readString();
        longDesc = in.readString();
        shortDesc = in.readString();
        imageURL = in.readString();
    }

    public static final Creator<Training> CREATOR = new Creator<Training>() {
        @Override
        public Training createFromParcel(Parcel in) {
            return new Training(in);
        }

        @Override
        public Training[] newArray(int size) {
            return new Training[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longDesc='" + longDesc + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(longDesc);
        dest.writeString(shortDesc);
        dest.writeString(imageURL);
    }
}
