package com.example.final_project.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.final_project.models.MovieModel;
import com.example.final_project.request.MovieApiClient;

import java.util.List;

public class MoviesRepository {

    private static MoviesRepository instance;

    private MovieApiClient movieApiClient;

    public  static  MoviesRepository getInstance(){
        if (instance == null) {
            instance = new MoviesRepository();
        }
        return instance;
    }

    private MoviesRepository(){
        movieApiClient = MovieApiClient.getInstance();
    }

    public MovieApiClient getMovieApiClient() {
        return movieApiClient;
    }

    public LiveData<List<MovieModel>> getMovies(){
        return movieApiClient.getMovies();
    }
}
