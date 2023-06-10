package com.example.final_project.adapter;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.final_project.R;
import com.example.final_project.model.MoviesModel;
import com.example.final_project.utils.Credentials;

import java.util.List;

public class MovieRecycleView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MoviesModel> movieList;
    private final OnMovieListener onMovieListener;

    public MovieRecycleView(OnMovieListener onMovieListener) {
        this.onMovieListener = onMovieListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gird_item, parent, false);
        return new MovieViewHolder(view, onMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext()).load(Credentials.POSTER_URL + movieList.get(position).getPoster_image()).into(((MovieViewHolder) holder).iv_poster);

        ((MovieViewHolder) holder).tv_title.setText(movieList.get(position).getTitle());
        ((MovieViewHolder) holder).tv_year.setText(movieList.get(position).getRelease_date());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}