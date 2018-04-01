package com.example.cmd.moviereviewapp.Contractors;

import com.example.cmd.moviereviewapp.POJO.Movies.MovieListModel;
import com.example.cmd.moviereviewapp.ViewHolders.SingleMoviewViewholder;

/**
 * Created by cmd on 1.04.18.
 */

public interface ISingleMovieContract {

    interface SingleMoviePresenter {
        void onBindViewHolder(SingleMoviewViewholder holder);

    }

    interface SingleMovieInteractor {
        MovieListModel getData();

    }

    interface SingleMovieView {

    }
}
