package com.example.final_project.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.final_project.model.MoviesModel;
import com.example.final_project.response.MovieResponses;
import com.example.final_project.utils.AppExecutor;
import com.example.final_project.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class MovieApiClient {
    private static MovieApiClient instance;
    public static MovieApiClient getInstance() {
        if (instance == null) {
            instance = new MovieApiClient();
        }
        return instance;
    }

    private final MutableLiveData<List<MoviesModel>> popularMovieLiveData;

    private PopularRunnable popularRunnable;

    private MovieApiClient() {
        popularMovieLiveData = new MutableLiveData<>();
    }

    public LiveData<List<MoviesModel>> getPopularMovie() {
        return popularMovieLiveData;
    }

    public void getPopularMovie(int page) {
        if (popularRunnable != null) {
            popularRunnable = null;
        }

        popularRunnable = new PopularRunnable(page);

        final Future handler = AppExecutor.getInstance().getNetworkIO().submit(popularRunnable);

        AppExecutor.getInstance().getNetworkIO().schedule(() -> {
            handler.cancel(true);
        },3000, TimeUnit.MILLISECONDS);
    }

    private class PopularRunnable implements Runnable {

        private final int page;
        boolean cancleRequest;

        public PopularRunnable(int page) {
            this.page = page;
            cancleRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getPopularMovie(page).execute();

                if (cancleRequest) {
                    return;
                }

                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        assert response.body() != null;
                        List<MoviesModel> popularMovieList = new ArrayList<>(((MovieResponses) response.body()).getMovies());

                        if (page == 1) {
                            popularMovieLiveData.postValue(popularMovieList);
                        } else {
                            List<MoviesModel> currentMovie = popularMovieLiveData.getValue();
                            assert currentMovie != null;
                            currentMovie.addAll(popularMovieList);
                            popularMovieLiveData.postValue(currentMovie);
                        }
                    } else {
                        assert response.errorBody() != null;
                        System.out.println(response.errorBody().string());
                        popularMovieLiveData.postValue(null);
                    }
                } else {
                    System.out.println("request isnt successful");
                }
            } catch (IOException e) {
                System.out.println(e);
                popularMovieLiveData.postValue(null);
            }
        }

        private Call<MovieResponses> getPopularMovie(int page) {
            return ApiService.getMovieApi().getPopularMovie(Credentials.KEY,page);
        }
    }
}

