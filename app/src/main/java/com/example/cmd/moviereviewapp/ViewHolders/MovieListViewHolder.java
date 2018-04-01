package com.example.cmd.moviereviewapp.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cmd.moviereviewapp.Contractors.IViewHolderContractor;
import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.R;

/**
 * Created by cmd on 18.03.18.
 */

public class MovieListViewHolder extends RecyclerView.ViewHolder implements IViewHolderContractor {
    private TextView mTitle;
    public ImageView mImage;

    public MovieListViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView)itemView.findViewById(R.id.title);
        mImage = (ImageView) itemView.findViewById(R.id.poster_iv);
    }

    @Override
    public void setValue(MovieListModel object) {
        mTitle.setText(object.getTitle());
    }
}
