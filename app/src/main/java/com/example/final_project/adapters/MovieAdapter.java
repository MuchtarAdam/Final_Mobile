package com.example.final_project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.final_project.R;
import com.example.final_project.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<MovieModel> mMovies;
    private OnMovieListener onMovieListener;

    public MovieAdapter(OnMovieListener onMovieListener) {
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gird_item,parent,false);
        return new MovieViewHolder(view, onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).
                load(mMovies.get(position))
                .into(((MovieViewHolder)holder).iv_poster);

        ((MovieViewHolder)holder).tv_title.setText(mMovies.get(position).getTitle());
        ((MovieViewHolder)holder).tv_release_date.setText(mMovies.get(position).getRelease_date());
    }

    @Override
    public int getItemCount() {
        if (mMovies != null) {
            return mMovies.size();
        }
        return 0;
    }

    public List<MovieModel> getmMovies() {
        return mMovies;
    }

    public void setMovie(List<MovieModel> movieModels) {
        this.mMovies = mMovies;
        notifyDataSetChanged();
    }
}
