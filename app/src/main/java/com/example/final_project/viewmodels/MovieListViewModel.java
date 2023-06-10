package com.example.final_project.viewmodels;

import android.graphics.Movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.final_project.models.MovieModel;

import java.util.List;

public class MovieListViewModel {

    private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    public  MovieListViewModel(){}

    public LiveData<List<MovieModel>> getMovies(){
        return mMovies;
    }
}
