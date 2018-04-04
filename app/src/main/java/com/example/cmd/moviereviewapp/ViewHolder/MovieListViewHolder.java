package com.example.cmd.moviereviewapp.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cmd.moviereviewapp.Contractor.IViewHolderContractor;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.Presenter.MovieListPresenter;
import com.example.cmd.moviereviewapp.R;

/**
 * Created by cmd on 18.03.18.
 */

public class MovieListViewHolder extends RecyclerView.ViewHolder
        implements IViewHolderContractor, View.OnClickListener {

    private TextView mTitle;
    public ImageView mImage;
    private MovieListPresenter mPresenter;

    public MovieListViewHolder(View itemView,MovieListPresenter presenter) {
        super(itemView);
        mTitle = (TextView)itemView.findViewById(R.id.title);
        mImage = (ImageView) itemView.findViewById(R.id.poster_iv);
        this.mPresenter = presenter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void setValue(MovieListModel object) {
        mTitle.setText(object.getTitle());
    }

    @Override
    public void onClick(View v) {
        if (mPresenter != null) {
            mPresenter.getMoviePos(getAdapterPosition());
        }
    }
}
