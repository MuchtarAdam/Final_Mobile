package com.example.final_project.utils;

import com.example.final_project.response.MovieResponses;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("movie/popular")
    Call<MovieResponses> getMovie(@Query("api_key") String key,
                                         @Query("page") int page);
}
