package com.example.final_project.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class MoviesModel implements Parcelable {
    private int id;
    private String title;
    private String backdrop_image;
    private String poster_image;
    private String release_date;
    private float vote_average;
    private String overView;

    public MoviesModel(int id, String title, String backdrop_image, String poster_image, String release_date, float vote_average, String overView) {
        this.id = id;
        this.title = title;
        this.backdrop_image = backdrop_image;
        this.poster_image = poster_image;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.overView = overView;
    }

    protected MoviesModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        backdrop_image = in.readString();
        poster_image = in.readString();
        release_date = in.readString();
        vote_average = in.readFloat();
        overView = in.readString();
    }

    public static final Creator<MoviesModel> CREATOR = new Creator<MoviesModel>() {
        @Override
        public MoviesModel createFromParcel(Parcel in) {
            return new MoviesModel(in);
        }

        @Override
        public MoviesModel[] newArray(int size) {
            return new MoviesModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdrop_image() {
        return backdrop_image;
    }

    public String getPoster_image() {
        return poster_image;
    }

    public String getRelease_date() {
        return release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public String getOverView() {
        return overView;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(backdrop_image);
        parcel.writeString(poster_image);
        parcel.writeString(release_date);
        parcel.writeFloat(vote_average);
        parcel.writeString(overView);
    }

    @Override
    public String toString() {
        return "MoviesModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", backdrop_image='" + backdrop_image + '\'' +
                ", poster_image='" + poster_image + '\'' +
                ", release_date='" + release_date + '\'' +
                ", vote_average=" + vote_average +
                ", overView='" + overView + '\'' +
                '}';
    }
}
