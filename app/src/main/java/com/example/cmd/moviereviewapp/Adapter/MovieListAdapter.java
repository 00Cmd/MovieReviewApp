package com.example.cmd.moviereviewapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cmd.moviereviewapp.Presenter.MovieListPresenter;
import com.example.cmd.moviereviewapp.R;
import com.example.cmd.moviereviewapp.ViewHolder.MovieListViewHolder;
import com.squareup.picasso.Picasso;

import static com.example.cmd.moviereviewapp.Constant.Constants.IMAGE_URL_BASE_PATH;

/**
 * Created by cmd on 19.03.18.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListViewHolder> {
    private MovieListPresenter mPresenter;
    private Context ctx;

    public MovieListAdapter(MovieListPresenter mPresenter,Context context) {
        this.mPresenter = mPresenter;
        this.ctx = context;
    }



    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieListViewHolder(LayoutInflater.from(ctx).inflate
                (R.layout.main_view_movie_list,parent,false), mPresenter);
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {
        mPresenter.bindAtPosition(position,holder);
        String image_url = IMAGE_URL_BASE_PATH + mPresenter.getMoviePosterPath(position);
        Picasso.with(ctx)
                .load(image_url)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return mPresenter.getSize();
    }
}
