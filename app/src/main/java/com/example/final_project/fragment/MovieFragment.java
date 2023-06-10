package com.example.final_project.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.final_project.R;
import com.example.final_project.model.adapter.MovieRecycleView;
import com.example.final_project.model.adapter.OnMovieListener;
import com.example.final_project.model.MoviesModel;
import com.example.final_project.model.viewmodels.MovieListViewModel;

public class MovieFragment extends Fragment implements OnMovieListener {

    private MovieListViewModel popularMovieListViewModel;
    private RecyclerView recyclerView;
    private MovieRecycleView recycleViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);

        recyclerView = rootView.findViewById(R.id.rv_main);
        recycleViewAdapter = new MovieRecycleView(this);
        recyclerView.setAdapter(recycleViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Set up the ViewModel and observe data changes
        popularMovieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        popularMovieListViewModel.getMovie().observe(getViewLifecycleOwner(), movieList -> {
            // Update the data in the RecyclerView adapter
            recycleViewAdapter.setMovieList(movieList);
        });

//        // Fetch the movie list
//        popularMovieListViewModel.fetchMovieList();

        return rootView;
    }

    @Override
    public void onMovieClick(int pos) {
        // Handle movie click event
        // Example: Get the selected movie from the adapter and perform an action
        MoviesModel selectedMovie = recycleViewAdapter.getMovie(pos);
        // Perform an action with the selected movie
    }
}

