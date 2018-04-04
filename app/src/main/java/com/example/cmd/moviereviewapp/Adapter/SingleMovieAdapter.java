package com.example.cmd.moviereviewapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.cmd.moviereviewapp.Presenter.SingleMoviePresenter;
import com.example.cmd.moviereviewapp.R;
import com.example.cmd.moviereviewapp.ViewHolder.SingleMoviewViewholder;
import com.squareup.picasso.Picasso;

import static com.example.cmd.moviereviewapp.Constant.Constants.IMAGE_URL_BASE_PATH;

/**
 * Created by cmd on 1.04.18.
 */

public class SingleMovieAdapter extends RecyclerView.Adapter<SingleMoviewViewholder> {
    private Context ctx;
    private SingleMoviePresenter mPresenter;

    public SingleMovieAdapter(Context ctx, SingleMoviePresenter mPresenter) {
        this.ctx = ctx;
        this.mPresenter = mPresenter;
    }

    @Override
    public SingleMoviewViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SingleMoviewViewholder(LayoutInflater.from(ctx).inflate
                (R.layout.single_movie_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(SingleMoviewViewholder holder, int position) {
//        mPresenter.
//        String image_url = IMAGE_URL_BASE_PATH + mPresenter.getMoviePosterPath(position);
//        Picasso.with(ctx)
//                .load(image_url)
//                .placeholder(android.R.drawable.sym_def_app_icon)
//                .error(android.R.drawable.sym_def_app_icon)
//                .into(holder.mImage);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
