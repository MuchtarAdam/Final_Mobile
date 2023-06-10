package com.example.final_project.model;

public class MoviesModel {
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
}
