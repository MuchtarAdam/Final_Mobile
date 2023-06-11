package com.example.final_project.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.final_project.models.MovieModel;

import java.util.List;

public class MoviesRepository {

    private static MoviesRepository instance;
    private MutableLiveData<List<MovieModel>> mMovies;

    public  static  MoviesRepository getInstance(){
        if (instance == null) {
            instance = new MoviesRepository();
        }
        return instance;
    }

    private MoviesRepository(){
        mMovies = new MutableLiveData<>();
    }
    public LiveData<List<MovieModel>> getMovies(){
        return mMovies;
    }
}
