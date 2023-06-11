package com.example.final_project.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project.R;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    CardView cv_container;

    ImageView iv_poster;
    TextView tv_title, tv_release_date;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        cv_container = itemView.findViewById(R.id.cv_container);

        iv_poster = itemView.findViewById(R.id.iv_poster);

        tv_title = itemView.findViewById(R.id.tv_title);
        tv_release_date = itemView.findViewById(R.id.tv_year);

    }

    @Override
    public void onClick(View view) {

    }
}
