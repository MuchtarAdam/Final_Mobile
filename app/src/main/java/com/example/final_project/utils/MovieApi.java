package com.example.final_project.utils;

import com.example.final_project.models.MovieModel;
import com.example.final_project.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

//    https://api.themoviedb.org/3/search/movie?api_key=45cf6f17c3b027741256fb8c7ecfeaa7&query=Jack+Reacher
    @GET("3/movie/popular/{movie_id}?")
    Call<MovieModel> getMovie(
            @Query("api_key") String key,
            @Query("page") int page
    );

    Call<MovieSearchResponse> searchMovie(String key, String query, int pageNumber);
}
