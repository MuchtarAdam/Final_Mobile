package com.example.final_project.response;

import com.example.final_project.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("results")
    @Expose
    private MovieModel movie;
    public MovieModel getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
