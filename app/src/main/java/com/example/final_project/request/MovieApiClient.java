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

    private final MutableLiveData<List<MoviesModel>> MovieLiveData;
    private PopularRunnable popularRunnable;

    private MovieApiClient() {
        MovieLiveData = new MutableLiveData<>();
    }

    public LiveData<List<MoviesModel>> getMovie() {
        return MovieLiveData;
    }

    public void getMovie(int page) {
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
                Response response = getMovie(page).execute();

                if (cancleRequest) {
                    return;
                }

                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        assert response.body() != null;
                        List<MoviesModel> movieList = new ArrayList<>(((MovieResponses) response.body()).getMovies());

                        if (page == 1) {
                            MovieLiveData.postValue(movieList);
                        } else {
                            List<MoviesModel> currentMovie = MovieLiveData.getValue();
                            assert currentMovie != null;
                            currentMovie.addAll(movieList);
                            MovieLiveData.postValue(currentMovie);
                        }
                    } else {
                        assert response.errorBody() != null;
                        System.out.println(response.errorBody().string());
                        MovieLiveData.postValue(null);
                    }
                } else {
                    System.out.println("request isn't successful");
                }
            } catch (IOException e) {
                System.out.println(e);
                MovieLiveData.postValue(null);
            }
        }

        private Call<MovieResponses> getMovie(int page) {
            return ApiService.getMovieApi().getMovie(Credentials.KEY,page);
        }
    }
}