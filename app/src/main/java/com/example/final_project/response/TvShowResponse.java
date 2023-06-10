package com.example.final_project.response;

import com.example.final_project.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvShowResponse {

    @SerializedName("results")
    @Expose
    private MovieModel tvShow;
    public MovieModel getTvShow(){
        return tvShow;
    }

    @Override
    public String toString() {
        return "TvShowResponse{" +
                "tvShow=" + tvShow +
                '}';
    }
}
