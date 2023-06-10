package com.example.final_project.repositories;

import androidx.lifecycle.LiveData;

import com.example.final_project.model.MoviesModel;
import com.example.final_project.request.MovieApiClient;

import java.util.List;

public class MovieRepository {
    private static MovieRepository instance;
    private MovieApiClient MovieApiClient;

    private int page;

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }

        return instance;
    }

    private MovieRepository() {
        MovieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<MoviesModel>> getPopularMovie() {
        return MovieApiClient.getMovie();
    }

    public void getMovie(int page) {
        this.page = page;
        MovieApiClient.getMovie(page);
    }

    // next page
    public void MovieNextPage() {
        getMovie(page+1);
    }
}
