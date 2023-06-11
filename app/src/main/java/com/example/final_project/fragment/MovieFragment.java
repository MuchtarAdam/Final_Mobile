package com.example.final_project.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.final_project.R;
import com.example.final_project.adapters.MovieAdapter;
import com.example.final_project.adapters.OnMovieListener;
import com.example.final_project.models.MovieModel;
import com.example.final_project.viewmodels.MovieListViewModel;

import java.util.List;

public class MovieFragment extends Fragment implements OnMovieListener {

    private MovieListViewModel movieListViewModel;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        ObserveAnyChange();
        ConfigureRecyclerView();
        movieListViewModel.searchMovieApi("fast", 1);

        return rootView;
    }

    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(getViewLifecycleOwner(), new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if (movieModels != null) {
                    for (MovieModel movieModel: movieModels){
                        Log.v("Tag", "onChanged" + movieModel.getTitle());

                        movieAdapter.setMovie(movieModels);
                    }
                }
            }
        });
    }

    private void ConfigureRecyclerView() {
        movieAdapter = new MovieAdapter(this);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onMovieClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }
}

