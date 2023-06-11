package com.example.final_project.utils;

import com.example.final_project.models.MovieModel;
import com.example.final_project.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET Call<MovieSearchResponse> searchMovie(
      @Query("key") String key,
      @Query("query") String query,
      @Query("page") int pageNumber
    );

    @GET("movie/popular/")
    Call<MovieModel> getMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );
}
