package com.example.cmd.moviereviewapp.Contractor;

import com.example.cmd.moviereviewapp.POJO.Event.MessageEvent;
import com.example.cmd.moviereviewapp.POJO.Movie.MovieListModel;
import com.example.cmd.moviereviewapp.ViewHolder.SingleMoviewViewholder;

/**
 * Created by cmd on 1.04.18.
 */

public interface ISingleMovieContract {

    interface SingleMoviePresenter {
        void onBindViewHolder(SingleMoviewViewholder holder);

    }

    interface SingleMovieInteractor {
        MovieListModel getDataFromOtherLayer(MessageEvent event);
    }

    interface SingleMovieView {

    }
}
