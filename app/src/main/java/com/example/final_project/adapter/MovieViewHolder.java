package com.example.final_project.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView iv_poster;
    TextView tv_title,tv_year;
    OnMovieListener onMovieListener;

    public MovieViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
        super(itemView);
        this.onMovieListener = onMovieListener;

        iv_poster = itemView.findViewById(R.id.iv_poster);
        tv_title = itemView.findViewById(R.id.tv_title);
        tv_year = itemView.findViewById(R.id.tv_year);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onMovieListener.onMovieClick(getPosition());
    }
}
