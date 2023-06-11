package com.example.final_project.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.final_project.models.MovieModel;
import com.example.final_project.repositories.MoviesRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    private MoviesRepository moviesRepository;

    public MovieListViewModel(){
        moviesRepository = MoviesRepository.getInstance();
    }
    public LiveData<List<MovieModel>> getMovies(){
        return moviesRepository.getMovies();
    }
}
