package com.example.final_project.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.final_project.R;
import com.example.final_project.fragment.FavoriteFragment;
import com.example.final_project.fragment.MovieFragment;
import com.example.final_project.fragment.TvShowFragment;

public class MainActivity extends AppCompatActivity {
    LinearLayout btn_movie, btn_tvShow, btn_favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_movie = findViewById(R.id.btn_movies);
        btn_tvShow = findViewById(R.id.btn_tvShows);
        btn_favorite = findViewById(R.id.btn_favorites);

        FragmentManager fragmentManager = getSupportFragmentManager();

        MovieFragment movieFragment = new MovieFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(MovieFragment.class.getSimpleName());
        if (!(fragment instanceof MovieFragment)) {
            fragmentManager.beginTransaction().add(R.id.fl_main, movieFragment,
                    MovieFragment.class.getSimpleName()).commit();
        }

        btn_movie.setOnClickListener(v -> switchFragment(new MovieFragment()));
        btn_tvShow.setOnClickListener(v -> switchFragment(new TvShowFragment()));
        btn_favorite.setOnClickListener(v -> switchFragment(new FavoriteFragment()));
    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (fragment instanceof MovieFragment) {
            transaction.replace(R.id.fl_main, fragment, MovieFragment.class.getSimpleName()).commit();
        } else {
            transaction.replace(R.id.fl_main, fragment, MovieFragment.class.getSimpleName()).addToBackStack(null).commit();
        }
    }
}
