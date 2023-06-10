package com.example.final_project.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.final_project.R;
import com.example.final_project.models.MovieModel;
import com.example.final_project.response.MovieSearchResponse;
import com.example.final_project.utils.Credentials;
import com.example.final_project.utils.MovieApi;
import com.example.final_project.utils.Servicey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//    LinearLayout btn_movie, btn_tvShow, btn_favorite;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRetrofitResponse();
            }

//            private void GetRetrofitResponse() {
//                MovieApi movieApi = Servicey.getMovieApi();
//
//                Call<MovieSearchResponse> responseCall =  movieApi
//                        .searchMovie(
//                                Credentials.KEY,
//                                "Jack Reacher",
//                                1
//                        );
//
//                responseCall.enqueue(new Callback<MovieSearchResponse>() {
//                    @Override
//                    public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
//                        if (response.code() == 200) {
//                            Log.v("Tag", "the response" + response.body().toString());
//                            List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
//                            for(MovieModel movie: movies){
//                                Log.v("Tag", "The release date" + movie.getRelease_date());
//                            }
//                        }else {
//                            try{
//                                Log.v("Tag", "Error" + response.errorBody().string());
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
//
//                    }
//                });
//            }

            private void GetRetrofitResponse() {
                MovieApi movieApi = Servicey.getMovieApi();

                Call<MovieSearchResponse> responseCall = movieApi.searchMovie(
                        Credentials.KEY,
                        "Jack Reacher",
                        1
                );

                responseCall.enqueue(new Callback<MovieSearchResponse>() {
                    @Override
                    public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                        if (response.isSuccessful()) {
                            Log.v("Tag", "the response" + response.body().toString());
                            List<MovieModel> movies = response.body().getMovies();
                            for (MovieModel movie : movies) {
                                Log.v("Tag", "The release date" + movie.getRelease_date());
                            }
                        } else {
                            try {
                                Log.v("Tag", "Error" + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

                    }
                });
            }

        });

//        btn_movie = findViewById(R.id.btn_movies);
//        btn_tvShow = findViewById(R.id.btn_tvShows);
//        btn_favorite = findViewById(R.id.btn_favorites);
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        MovieFragment movieFragment = new MovieFragment();
//        Fragment fragment = fragmentManager.findFragmentByTag(MovieFragment.class.getSimpleName());
//        if (!(fragment instanceof MovieFragment)) {
//            fragmentManager.beginTransaction().add(R.id.fl_main, movieFragment,
//                    MovieFragment.class.getSimpleName()).commit();
//        }

//        btn_movie.setOnClickListener(v -> switchFragment(new MovieFragment()));
//        btn_tvShow.setOnClickListener(v -> switchFragment(new TvShowFragment()));
//        btn_favorite.setOnClickListener(v -> switchFragment(new FavoriteFragment()));
    }

//    private void switchFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        if (fragment instanceof MovieFragment) {
//            transaction.replace(R.id.fl_main, fragment, MovieFragment.class.getSimpleName()).commit();
//        } else {
//            transaction.replace(R.id.fl_main, fragment, MovieFragment.class.getSimpleName()).addToBackStack(null).commit();
//        }
//    }
}
