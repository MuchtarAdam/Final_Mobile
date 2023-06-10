package com.example.final_project.response;

import com.example.final_project.model.MoviesModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponses {
    @SerializedName("results")
    @Expose
    private List<MoviesModel> movies;

    public List<MoviesModel> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieResponses{" +
                "movies=" + movies +
                '}';
    }
}
