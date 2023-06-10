package com.example.final_project.model.viewmodels;

import androidx.lifecycle.LiveData;

import com.example.final_project.model.MoviesModel;
import com.example.final_project.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel {
    private MovieRepository movieRepository;

    public MovieListViewModel() {
        movieRepository = movieRepository.getInstance();
    }

    public LiveData<List<MoviesModel>> getPopularMovie() {
        return movieRepository.getMovie();
    }

    public void getMovie(int page) {
        movieRepository.getMovie(page);
    }

    // next page
    public void movieNextPage() {
        movieRepository.movieNextPage();
    }
}
