package com.example.final_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.final_project.R;
import com.example.final_project.models.MovieModel;
import com.example.final_project.viewmodels.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity{

//   LinearLayout btn_movie, btn_tvShow, btn_favorite;

    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        ObserveAnyChange();

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchMovieApi("fast", 2);
            }

            private void searchMovieApi(String query, int pageNumber){
                movieListViewModel.searchMovieApi(query, pageNumber);
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

    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if (movieModels != null) {
                    for (MovieModel movieModel: movieModels){
                        Log.v("Tag", "onChanged" + movieModel.getTitle());
                    }
                }
            }
        });
    }
//        private void switchFragment(Fragment fragment) {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//        if (fragment instanceof MovieFragment) {
//            transaction.replace(R.id.fl_main, fragment, MovieFragment.class.getSimpleName()).commit();
//        } else {
//            transaction.replace(R.id.fl_main, fragment, MovieFragment.class.getSimpleName()).addToBackStack(null).commit();
//        }
//    }
}
